package com.url;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClients;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author wentianlou
 * Date 2019/10/17 9:43
 **/
public class HttpclientDemo {

    private HttpClient httpclient;
    private ExecutorService executorService;

    public HttpclientDemo(){
        this.executorService = new ThreadPoolExecutor(5,
                5,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());

        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(1000)
                .setConnectionRequestTimeout(1000)
                .setSocketTimeout(1000)
                .build();
        this.httpclient = HttpClients
                .custom()
                .setDefaultRequestConfig(requestConfig)
                .setMaxConnTotal(5)
                .setMaxConnPerRoute(5)
                .build();

        for(int i = 0;i < 10; i++)
        {
            HttpClientTask task = new HttpClientTask(httpclient);
            executorService.submit(task);
        }
    }

    public static void main(String[] args) {
        new HttpclientDemo();
    }

    public static void mainThreadPoolExecutortest(String[] args) {
        //ArrayBlockingQueue:是一个基于数组结构的有界阻塞队列，按FIFO原则进行排序
        //提交的任务超过blockingQueue大小会报异常（task num > maximumPoolSize + blockingQueue.size()）
        BlockingQueue blockingQueue = new ArrayBlockingQueue<>(5);

        //LinkedBlockingQueue:一个基于链表结构的阻塞队列，吞吐量高于ArrayBlockingQueue
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();

        //SynchronousQueue: 一个不存储元素的阻塞队列。每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量高于LinkedBlockingQueue

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                5, //值得注意的是，如果使用了无界的任务队列(linkedBlockingQueue)这个参数就没用了。
                1,
                TimeUnit.MINUTES,
                blockingQueue
        );

        for(int i = 0;i < 10; i++)
        {
            Runnable runnable = new TaskWithoutResult(2000,i);
            threadPoolExecutor.submit(runnable);
        }
        System.out.println("..length = " + blockingQueue.size());
        threadPoolExecutor.shutdown();//不会触发中断,会继续跑完任务，shutdown方法只是发出了停止信号，等所有线程执行完毕会关闭线程池。
//        threadPoolExecutor.shutdownNow();//会触发中断，不会继续跑完任务，直接跑异常InterruptedException，shutdownNow则是立即停止所有任务


        System.out.print(".......");
    }
}

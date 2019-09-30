package com.task;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 同步辅助类CountDownLatch使用
 * countdownlatch 是一个同步类工具，不涉及锁定，当count的值为零时当前线程继续运行，
 * 不涉及同步，只涉及线程通信的时候，使用它较为合适
 * Author wentianlou
 * Date 2019/9/30 9:47
 **/
public class CountDownLatchDemo {

    public CountDownLatchDemo() {

    }

    public static void main(String[] args) {
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(2);
        CountDownLatch countDownLatch = new CountDownLatch(1);

        for(int i=0; i<3; i++){
            Thread thread = new Thread(new Player(begin,end),String.valueOf(i));
            thread.start();
        }

        try{
            System.out.println("the race begin");
            begin.countDown();
            //await() 方法具有阻塞作用，也就是说主线程在这里暂停
            end.await();
            System.out.println("the race end");
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("go ....111.. ");
        try {
            //如果等待时间过去但是count>0，则返回false
            //如果等待时间时间小于或等于零，方法将不会等待。
            if(!countDownLatch.await(2, TimeUnit.SECONDS)){
                System.out.println("超时，不等了.. ");
            }

            System.out.println("1111111111111111111111111111");
        }
        catch (InterruptedException e){

        }catch (Exception e){

        }finally {

        }

    }
}

package com.task;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Author wentianlou
 * Date 2019/10/21 10:11
 **/
public class ScheduledExecutorServiceDemo {

    // 通过静态方法创建ScheduledExecutorService的实例
    private ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);

    public ScheduledExecutorServiceDemo(){
        executorService.schedule(new MyTask("aa"),5, TimeUnit.SECONDS);
        String s = new String();
    }

    public static void main(String[] args) {
        new ScheduledExecutorServiceDemo();
    }
}

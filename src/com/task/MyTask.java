package com.task;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Author wentianlou
 * Date 2019/10/21 10:25
 **/
public class MyTask implements Callable<String> {
    private String name;

    public MyTask(String name) {
        super();
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.println("任务开始执行时间：" + new Date());
        return name;
    }
}

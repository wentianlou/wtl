package com.task;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 阿里巴巴不推荐使用：多线程并行处理定时任务时，Timer运行多个TimeTask时，只要其中之一没有捕获抛出的异常，
 * 其它任务便会自动终止运行，使用ScheduledExecutorService则没有这个问题。
 * Author wentianlou
 * Date 2019/9/30 10:16
 **/
public class TimerDemo {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("2000毫米后执行一次。");
            }
        }, 2000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("5000毫米后执行一次。");
            }
        }, new Date(System.currentTimeMillis() + 5000));

        Timer timer1 = new Timer();
        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(111);
            }
        }, 1000, 2000); // 1000毫米后执行第一次，之后每2000毫米执行一次


        Thread.sleep(8000);
        timer1.cancel();
        timer1 = null;
        System.out.println("end");
    }
}

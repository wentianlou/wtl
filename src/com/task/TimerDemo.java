package com.task;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
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

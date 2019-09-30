package com.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 如果任务还没跑完，下一个周期任务是不会开始的
 * Author wentianlou
 * Date 2019/9/30 10:32
 **/
@Component
public class ScheduledTask {

    @Scheduled(initialDelay = 1000,fixedDelay = 1000)
    public void task1() {
        System.out.println("延迟1000毫秒后执行，任务执行完1000毫秒之后执行！");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedRate = 2000)
    public void task2() {
        System.out.println("延迟1000毫秒后执行，之后每2000毫秒执行一次！");
    }

    @Scheduled(cron = "*/2 * * * * ?")
    public void task3() {
        System.out.println("每2秒执行一次！");
    }
}

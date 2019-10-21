package com.task;

import java.util.concurrent.CountDownLatch;

/**
 * Author wentianlou
 * Date 2019/9/30 9:53
 **/
public class Player implements Runnable{

    private CountDownLatch begin;

    private CountDownLatch end;

    Player(CountDownLatch begin,CountDownLatch end){
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " start !");
            //因为此时已经为0了，所以不阻塞
            begin.await();
            System.out.println(Thread.currentThread().getName() + " arrived !");

            //countDown() 并不是直接唤醒线程,当end.getCount()为0时线程会自动唤醒
            end.countDown();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
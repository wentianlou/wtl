package com.threadstudy;

public class Main {

    public static void main(String[] args) {
	    System.out.println(Thread.currentThread().getName());

        try{
            MyThread myThread = new MyThread();
            myThread.setName("myThread");
            //如果有多个线程一起执行start方法，start方法的顺序不代表线程启动的顺序。
            myThread.start(); //异步执行，通知操作系统可以调用线程的run方法了。
            //myThread.run(); 这是同步执行，不是异步，马上执行。

            for(int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("main=" + Thread.currentThread().getName());
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("运行结束！");
    }
}

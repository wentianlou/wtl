package com.threadstudy;

public class Main {

    public static void main(String[] args) {
	    System.out.println(Thread.currentThread().getName());

        try{
            MyThread myThread = new MyThread();
            myThread.setName("myThread");
            //����ж���߳�һ��ִ��start������start������˳�򲻴����߳�������˳��
            myThread.start(); //�첽ִ�У�֪ͨ����ϵͳ���Ե����̵߳�run�����ˡ�
            //myThread.run(); ����ͬ��ִ�У������첽������ִ�С�

            for(int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("main=" + Thread.currentThread().getName());
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("���н�����");
    }
}

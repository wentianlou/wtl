package com.url;

/**
 * Author wentianlou
 * Date 2019/10/17 10:06
 **/
class TaskWithoutResult implements Runnable
{
    //默认睡眠时间1s
    private int sleepTime = 1000;
    private int index;

    public TaskWithoutResult(int sleepTime, int index)
    {
        this.sleepTime = sleepTime;
        this.index = index;
    }

    @Override
    public void run()
    {
        System.out.println("线程 "+Thread.currentThread()+" 开始运行" + " index=" + index);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {//捕捉中断异常
            System.out.println("线程 "+Thread.currentThread()+" 被中断");
        }
        System.out.println(" 线程"+Thread.currentThread()+" 结束运行"  + " index=" + index);
    }



}

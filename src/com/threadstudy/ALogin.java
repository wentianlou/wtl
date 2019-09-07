package com.threadstudy;

/**
 * Author wentianlou
 * Date 2019/7/12 19:46
 **/
public class ALogin extends Thread {
    @Override
    public void run() {
        LoginServlet.doPost("a","aa");
    }
}

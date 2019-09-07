package com.threadstudy;

/**
 * Author wentianlou
 * Date 2019/7/12 19:47
 **/
public class BLogin extends Thread {
    @Override
    public void run() {
        LoginServlet.doPost("b","bb");
    }
}

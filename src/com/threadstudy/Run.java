package com.threadstudy;

/**
 * Author wentianlou
 * Date 2019/7/12 19:47
 **/
public class Run {
    public static void main(String[] args) {
        ALogin aLogin = new ALogin();
        aLogin.start();
        BLogin bLogin = new BLogin();
        bLogin.start();
    }
}

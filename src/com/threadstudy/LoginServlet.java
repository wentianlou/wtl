package com.threadstudy;

/**
 * Author wentianlou
 * Date 2019/7/12 19:42
 **/
public class LoginServlet {
    private static String userNameRef;
    private static String passwordRef;

            synchronized public static void doPost(String userName, String password){
                try {
                    userNameRef = userName;
                    if("a".equals(userName)) {
                        Thread.sleep(5000);
                    }
                    passwordRef = password;
                    System.out.println("userName=" + userNameRef + " passwoed=" + password);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
}

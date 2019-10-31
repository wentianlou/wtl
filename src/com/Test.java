package com;

import jdk.nashorn.internal.parser.JSONParser;

import java.util.Date;

/**
 * @author wentianlou
 * @date 2019/10/29 14:27
 **/
public class Test {
    private static final long DAY_MILLIS = 2592000000L;

    public static void main(String[] args) {
        System.out.println(".....................");

//        Date classStartTime = new Date("2019-10-29 13:58:05");

        //超过上课时间30天,不提供问卷调查
//        long overTime = 1572328685000L + DAY_MILLIS;
//        long currTime = System.currentTimeMillis();
//        boolean isOverTime = currTime > overTime;
//
//        System.out.print("isOverTime:"+isOverTime);


        String value = "[{'display':'020-123456','phone':'020123456'},{'display':'020-923456','phone':'020923456'}]";
        value = value.substring(1,value.length() - 1);
        System.out.println(value);

        String[] subValues = value.split(",");
        for (String v : subValues){
            System.out.println(v);
            if(v.indexOf("phone") != -1){
                String[] phoneInfo = v.split(":");
                String phone = phoneInfo[1];
                if(phone != null && phone.length() > 0){
                    phone = phone.substring(1,phone.length() -2);
                    System.out.println(phone);
                }

            }
        }
    }
}

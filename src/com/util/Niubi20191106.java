package com.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lym
 * @Date 2019/11/6 9:13
 * @qq 1317113287
 * @Description
 */
public class Niubi20191106 {

    public static void main(String[] args) {

        // 你想要替换的字符串
        String replace = "wentianlou";
        // 原始字符串
        String str= "?params={\"token\":\"abc\"}";

        String result = str.replaceAll("\"token\":\".*?\"", String.format("\"token\":\"%s\"", replace));
        System.out.println(result);
    }
}

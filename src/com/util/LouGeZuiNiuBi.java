package com.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lym
 * @Date 2019/10/31 11:17
 * @qq 1317113287
 * @Description 楼哥最牛逼 string to java field
 */
public class LouGeZuiNiuBi {

    private static final String PATTERN = "'display':'(.*?)'.*?'phone':'(.*?)'";
    public static void main(String[] args) {
        String input = "[{'display':'020-123456','phone':'020123456'},{'display':'021-923456','phone':'020923456'}]";
        List<Phone> test = test(input);
        test.forEach(phone -> {
            System.out.println(phone.getDisplay());
        });
    }

    /**
     * "[{'display':'020-123456','phone':'020123456'},{'display':'020-923456','phone':'020923456'}]"
     */
    private static List<Phone> test(String input){
        List<Phone> phones = new ArrayList<>();
        Pattern compile = Pattern.compile(PATTERN);
        Matcher matcher = compile.matcher(input);
        int i = 0;
        while (matcher.find(i)) {
//          System.out.println("display="+matcher.group(1)+",phone="+matcher.group(2));
            i += matcher.group(0).length();
            phones.add(new Phone(matcher.group(1), matcher.group(2)));
        }
        return phones;
    }

    static class  Phone{
        String display;
        String phone;

        public Phone(String display, String phone) {
            this.display = display;
            this.phone = phone;
        }

        public String getDisplay() {
            return display;
        }

        public void setDisplay(String display) {
            this.display = display;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}

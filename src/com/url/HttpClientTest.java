package com.url;

/**
 * Author wentianlou
 * Date 2019/10/9 11:15
 **/
public class HttpClientTest {
    public static void main(String[] args) {
        String url = "https://hualala-live.oss-cn-shenzhen.aliyuncs.com/student_homework/picture/20190120/cropped-922055148.jpg";
        String result = HttpClient4.doGet(url);
        System.out.println(result);
    }
}

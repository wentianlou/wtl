package com.url;

import ch.qos.logback.core.util.FileUtil;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.HttpClient;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * Author wentianlou
 * Date 2019/10/17 11:15
 **/
public class HttpClientTask implements Runnable {

    private HttpClient httpclient;

    public HttpClientTask(HttpClient httpclient){
        this.httpclient = httpclient;
    }

    @Override
    public void run() {
        String fileUrl = "https://hualala-live.oss-cn-shenzhen.aliyuncs.com/student_homework/audio/20191016/114efcd8-90e9-443d-a83a-b1d9ca39dda4.mp3";
        HttpGet httpGet = new HttpGet(fileUrl);
        String tempPath = "D:/mp3";
        File accFile = new File(tempPath, UUID.randomUUID().toString() + ".mp3");
        InputStream content = null;
        try{
            HttpResponse response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            content = entity.getContent();
            FileUtils.copyInputStreamToFile(content, accFile);
        } catch (Exception e) {
            System.out.print(e);
        } finally {
            if(content != null){
                try {
                    content.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("........task end.....");
        }
    }
}

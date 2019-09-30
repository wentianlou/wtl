package com.util;


import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.InputStream;

/**
 * 这是一个从服务器上下载文件的demo service
 * httpClient.execute 方式
 * Author wentianlou
 * Date 2019/9/19 10:27
 **/
public class LoadFileUseHttpClient {

    private HttpClient httpClient;
    private String tempPath = "D:/workspace/threadstudy/temp";

    private void init(){
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(3000)
                .setConnectionRequestTimeout(3000)
                .setSocketTimeout(3000)
                .build();

        this.httpClient = HttpClients
                .custom()
                .setDefaultRequestConfig(requestConfig)
                .setMaxConnTotal(1)
                .setMaxConnPerRoute(1)
                .build();
    }

    public LoadFileUseHttpClient(){
        System.out.println("tempPath:"+tempPath);

        init();

        String urlPath = "https://hualala-live.oss-cn-shenzhen.aliyuncs.com/student_homework/picture/20190416/c2bae615-2831-4e7b-8e15-9f6ff23208f6.jpg";
        String mp3FileName = getFileName(urlPath);
        System.out.println("mp3FileName:" + mp3FileName);
        File file = new File(tempPath, mp3FileName);

        try {
            HttpGet httpGet = new HttpGet(urlPath);
            HttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                System.out.println("get file failed,url: " + urlPath);
            }
            else {
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                //把下载回来的文件写到file里面
                FileUtils.copyInputStreamToFile(content, file);
                if (!file.exists()) {
                    System.out.println("文件不存在, 下载失败");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {

        }
    }

    public static void main(String[] args) {
        //1. httpClient方式下载资源
        LoadFileUseHttpClient service = new LoadFileUseHttpClient();
    }

    private String getFileName(String urlPath) {
        int index = urlPath.lastIndexOf("/");
        if (index != -1) {
            return urlPath.substring(index + 1);
        }
        return urlPath;
    }
}

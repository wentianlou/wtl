package com.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

/**
 * 使用url的方式下载资源
 * Author wentianlou
 * Date 2019/9/19 11:11
 **/
public class LoadFileUseUrl {
    private String tempPath = "D:/workspace/threadstudy/temp";

    public LoadFileUseUrl(){
        String urlPath = "https://hualala-live.oss-cn-shenzhen.aliyuncs.com/student_homework/audio/20190912/8fa8f6b2-cf3d-4ac7-854d-69926a2a25e8.mp3";
        String mp3FileName = getFileName(urlPath);
        System.out.println("mp3FileName:" + mp3FileName);
        File file = new File(tempPath, mp3FileName);

        try {
            URL url = new URL(urlPath);
            FileUtils.copyURLToFile(url,file);
        }catch (Exception e) {
            System.out.println(e);
        }

    }

    private void init(){

    }

    public static void main(String[] args) {
        new LoadFileUseUrl();
    }

    private String getFileName(String urlPath) {
        int index = urlPath.lastIndexOf("/");
        if (index != -1) {
            return urlPath.substring(index + 1);
        }
        return urlPath;
    }
}

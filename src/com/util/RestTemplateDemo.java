package com.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 记录spring RestTemplate 的使用方法(post方法)
 * @author wentianlou
 * @date 2019/11/12 20:43
 **/
public class RestTemplateDemo {

    private SimpleClientHttpRequestFactory requestFactory;

    public RestTemplateDemo(){
        init();
    }

    /**
     * 设置超时时间
     */
    private void init() {
        requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(3000);
        requestFactory.setReadTimeout(6000);
    }

    public Result getVerificationCode(String phone) {
        RestTemplate restTemplate = new RestTemplate(requestFactory);

        String url = "/o/v1.0/live/sendSmsCaptcha";
        try{
            JSONObject postData = new JSONObject();
            postData.put("phone", phone);

            HttpEntity<String> formEntity = getHttpEntity(postData);

            JSONObject result = restTemplate.postForObject(url, formEntity, JSONObject.class);
            result.getInteger("code"); //获取返回代码
            result.get("data");//获取返回的对象
        }
        catch(Exception e){

        }

        return new Result();
    }

    private HttpEntity<String> getHttpEntity(JSONObject postData){
        //设置Http Header
        HttpHeaders headers = new HttpHeaders();
        //设置请求媒体数据类型
        headers.setContentType(MediaType.APPLICATION_JSON);
        //设置返回媒体数据类型
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(postData.toString(), headers);
        return formEntity;
    }
}

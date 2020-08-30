package com.itheima.crawer;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class FitsrCrwerTest {
    public static void main(String[] args) throws IOException {
        //1.打开浏览器 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //2.输入网址 发起GET请求创建HttpGet对象
        HttpGet httpGet = new HttpGet("http://www.baidu.com");

        //3.按回车 发起请求 获取使用httpClient发起请求 获取响应
        CloseableHttpResponse response = httpClient.execute(httpGet);

        //4.解析响应 获取数据
        //判断状态码是否是200
        if(response.getStatusLine().getStatusCode()==200){
            HttpEntity entity = response.getEntity();
            //获取到网页内容
            String content = EntityUtils.toString(entity, "utf8");
            System.out.println(content);
        }
    }
}

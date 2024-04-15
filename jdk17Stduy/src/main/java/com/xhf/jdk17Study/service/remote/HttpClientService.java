package com.xhf.jdk17Study.service.remote;

import com.xhf.study.service.tool.MyGsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class HttpClientService {

    public String get(Map<String, String> paramMap, String url) throws Exception {
        log.info("开始调用接口 get " + url);
        CloseableHttpClient httpClient = getCloseableHttpClient();
        HttpGet request = new HttpGet(url);
        if (paramMap != null) {
            URI targetUrl = this.enclosureGetParam(url, paramMap);
            if (null != targetUrl) {
                request.setURI(targetUrl);
            }
        }
        RequestConfig requestConfig = getRequestConfig();
        request.setConfig(requestConfig);
        request.setHeader("Content-Type", "application/json");
//        log.info("调用接口" + JSONUtil.toJsonStr(request));
        return httpClient.execute(request, new BasicResponseHandler());
    }

    public String post(Map<String, String> paramMap, String url, String token) throws Exception {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpClient httpClient = getCloseableHttpClient();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        UrlEncodedFormEntity entity = enclosurePostParam(paramMap);
        if (entity != null) {
            httpPost.setEntity(entity);
        }
        RequestConfig requestConfig = getRequestConfig();
        httpPost.setConfig(requestConfig);
        // 执行http请求
        httpPost.setHeader("auth", token);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        return EntityUtils.toString(response.getEntity(), "utf-8");
    }

    public HttpResponse postBody(Object param, String url, String token) throws Exception {
        // 创建HttpClient实例
//        HttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpClient httpClient = getCloseableHttpClient();
        // 创建HttpPost请求
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.setHeader("auth", token);

        // 创建multipart/form-data请求体
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("imageString", param.toString())); // 添加Base64编码的图片字符串作为表单字段

        // 设置请求体
        HttpEntity entity = new UrlEncodedFormEntity(params); // 将表单参数编码为键值对形式
        httpPost.setEntity(entity);

        // 发送请求
        return httpClient.execute(httpPost);
    }


    public Object postBody1(Object base64ImageString, String url, String token) throws Exception {
        // 创建HttpClient实例
        try {

            // 创建URL对象
            URL endpointUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) endpointUrl.openConnection();

            // 设置请求方法为POST
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            // 设置请求头部信息
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("auth", token);

            // 构建请求体
            String requestBody = "{\"imageString\": \"" + base64ImageString + "\"}";

            // 发送请求
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(requestBody.getBytes(StandardCharsets.UTF_8));

            // 获取响应
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // 请求成功
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                System.out.println("Response: " + response);
            } else {
                // 请求失败
                System.out.println("Request Failed. Response Code: " + responseCode);
            }

            // 断开连接
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String postEntity(Object param, String url, String token) throws Exception {
        log.info("开始调用接口 post " + url);
//        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpClient httpClient = getCloseableHttpClient();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.setHeader("auth", token);
        StringEntity entity = new StringEntity(MyGsonUtils.gsonString(param), "utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        RequestConfig requestConfig = getRequestConfig();
        httpPost.setConfig(requestConfig);
        // 执行http请求
        CloseableHttpResponse response = httpClient.execute(httpPost);
        return EntityUtils.toString(response.getEntity(), "utf-8");
    }

    public String delete(Map<String, String> paramMap, String url, String token) throws Exception {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpClient httpClient = getCloseableHttpClient();
        HttpDelete httpDelete = new HttpDelete(url);
        URI targetUrl = this.enclosureGetParam(url, paramMap);
        if (null != targetUrl) {
            httpDelete.setURI(targetUrl);
        }
        RequestConfig requestConfig = getRequestConfig();
        httpDelete.setHeader("auth", token);
        httpDelete.setHeader("Content-Type", "application/json");
        httpDelete.setConfig(requestConfig);
        return httpClient.execute(httpDelete, new BasicResponseHandler());
    }

    public String putEntity(Object param, String url, String token) throws Exception {
        log.info("开始调用接口 put " + url);
//        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpClient httpClient = getCloseableHttpClient();
        HttpPut httpPut = new HttpPut(url);
        httpPut.addHeader("Content-Type", "application/json");
        httpPut.setHeader("auth", token);
        StringEntity entity = new StringEntity(MyGsonUtils.gsonString(param), "utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPut.setEntity(entity);
        RequestConfig requestConfig = getRequestConfig();
        httpPut.setConfig(requestConfig);
        // 执行http请求
        CloseableHttpResponse response = httpClient.execute(httpPut);
        return EntityUtils.toString(response.getEntity(), "utf-8");
    }

    public URI enclosureGetParam(String url, Map<String, String> paramMap) throws Exception {
        URI targetUrl = null;
        if (paramMap != null) {
            URIBuilder builder = new URIBuilder(url);
            for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                builder = builder.setParameter(entry.getKey(), entry.getValue());
            }
            targetUrl = builder.build();
        }
        return targetUrl;
    }

    public UrlEncodedFormEntity enclosurePostParam(Map<String, String> paramMap) throws UnsupportedEncodingException {

        if (paramMap != null) {
            List<NameValuePair> paramList = new ArrayList<>();
            for (String key : paramMap.keySet()) {
                paramList.add(new BasicNameValuePair(key, paramMap.get(key)));
            }
            // 模拟表单
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, "utf-8");
            return entity;
        }
        return null;
    }

    public CloseableHttpClient getCloseableHttpClient() {
        // 创建凭证提供程序
//        if (BrowserConstant.proxyDto == null) {
        return HttpClients.createDefault();
//        } else {
//            CredentialsProvider credsProvider = new BasicCredentialsProvider();
//            credsProvider.setCredentials(new AuthScope(BrowserConstant.proxyDto.proxyHost, BrowserConstant.proxyDto.proxyPort),
//                    new UsernamePasswordCredentials(BrowserConstant.proxyDto.proxyUser, BrowserConstant.proxyDto.proxyPassword));
//
//            return HttpClients.custom()
//                    .setDefaultCredentialsProvider(credsProvider)
//                    .setProxy(new HttpHost(BrowserConstant.proxyDto.proxyHost, BrowserConstant.proxyDto.proxyPort))
//                    .build();
//        }
    }

    public RequestConfig getRequestConfig() {
//        if (BrowserConstant.proxyDto == null) {
        return RequestConfig.custom()
                .setConnectTimeout(60 * 1000).setSocketTimeout(60 * 1000).setConnectionRequestTimeout(60 * 1000).build();
//        } else {
//            return RequestConfig.custom()
//                    .setProxy(new HttpHost(BrowserConstant.proxyDto.proxyHost, BrowserConstant.proxyDto.proxyPort))
//                    .setConnectTimeout(60 * 1000).setSocketTimeout(60 * 1000).setConnectionRequestTimeout(60 * 1000).build();
//        }
    }

}

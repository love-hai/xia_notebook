package com.xhf.jdk17Study.service.remote;

import com.xhf.jdk17Study.model.MyIp;
import com.xhf.tool.MyGsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiahaifeng
 * @since 2024/4/13 9:49
 */
@Service
@Slf4j
public class OtherApiService {
    @Autowired
    private HttpClientService httpClientService= new HttpClientService();

    public MyIp queryMyNetIp() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("lang", "zh-CN");
        String result = httpClientService.get(params, "http://ip-api.com/json/");
        MyIp response = MyGsonUtils.gsonToBean(result, MyIp.class);
        return response;
    }
}

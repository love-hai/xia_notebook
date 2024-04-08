package com.xhf.study.service.tool;

import lombok.Data;

import java.util.Map;

/**
 * @author xiahaifeng
 * @since 2024/4/8 14:38
 */
@Data
public class urlEntity {
    String url;
    String host;

    Map<String, String> params;

    public urlEntity(String urlStr) {
        this.url = urlStr;
        this.host = urlStr.substring(0, urlStr.indexOf("?"));
        String paramStr = urlStr.substring(urlStr.indexOf("?") + 1);
        params = new java.util.HashMap<>();
        for (String param : paramStr.split("&")) {
            String[] pair = param.split("=");
            String key = pair[0];
            String value = pair.length > 1 ? pair[1] : "";
            params.put(key, value);
        }
    }
}

package com.xhf.jdk17Study.model;

import lombok.Data;

/**
 * @author xiahaifeng
 * @since 2024/4/13 9:46
 */
@Data
public class MyIp {
    private String status;
    private String country;
    private String countryCode;
    private String region;
    private String regionName;
    private String city;
    private String timezone;
    private String isp;
    private String org;
    private String as;
    private String query;
}

package com.xhf.test.service;

/**
 * @projectName: test
 * @package: com.xhf.test.service
 * @className: MyFeignConfig
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/9/5 16:09
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/5 16:09
 * @updateRemark:
 * @version: v1.0
 */

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFeignConfig {
    @Bean
    public Request.Options requestOptions() {
        // 配置连接超时和读取超时
        return new Request.Options(5000, 30000); // 连接超时：5秒，读取超时：30秒
    }

    // 可以添加其他自定义配置
}

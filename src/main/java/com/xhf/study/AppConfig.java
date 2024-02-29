package com.xhf.study;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @projectName: test
 * @package: com.xhf.study
 * @className: AppConfig
 * @descriptions: 配置类
 * @author: xiahaifeng
 * @createDate: 2023/9/7 9:08
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/7 9:08
 * @updateRemark:
 * @version: v1.0
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.xhf")
public class AppConfig {

}

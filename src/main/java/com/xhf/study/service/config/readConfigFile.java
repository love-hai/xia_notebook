package com.xhf.study.service.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.util.Properties;

/**
 * @author xiahaifeng
 * @since 2024/2/26 9:52
 */

public class readConfigFile {
    public static void main(String[] args) {
        YamlPropertiesFactoryBean yamlProFb = new YamlPropertiesFactoryBean();
        yamlProFb.setResources(new ClassPathResource("src/main/resources/application2.yml"));
        Properties properties = yamlProFb.getObject();
        System.out.println(properties.get("person2.name"));
        System.out.println(properties.get("person2.gender"));
        System.out.println(properties.toString());
    }
}

package com.xhf.study.service.config;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

/**
 * @author xiahaifeng
 * @since 2024/2/26 9:52
 */

public class ReadConfigFile {

    public static void main(String[] args) {
        // 指定要加载的YAML文件路径
        String yamlFilePath = "D:\\work\\IdeaProjects\\test\\config\\application2.yml";

        // 创建Yaml对象
        Yaml yaml = new Yaml();
        File file = new File(yamlFilePath);
        // 加载YAML文件并解析为Map对象
        try (InputStream inputStream = new FileInputStream(file); ) {
            Map<String, Object> yamlData = yaml.load(inputStream);
            // 输出Map中的值
            if (yamlData != null) {
                System.out.println( ((Map<?, ?>) yamlData.get("person2")).get("name"));
                System.out.println(yamlData.toString());
            } else {
                System.out.println("Failed to load YAML file.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

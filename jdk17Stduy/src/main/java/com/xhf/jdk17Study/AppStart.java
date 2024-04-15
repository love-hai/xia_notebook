package com.xhf.jdk17Study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;

/**
 * @author xiahaifeng
 * @since 2024/4/13 10:32
 */
@Slf4j
public class AppStart {
    public static void main(String[] args){
        System.out.println("Hello World!");
        SpringApplication.run(HaiApplication.class, args);
        log.info("Application started successfully!");
    }

}

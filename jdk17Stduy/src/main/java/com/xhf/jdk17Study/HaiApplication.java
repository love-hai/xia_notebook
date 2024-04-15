package com.xhf.jdk17Study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.xhf"})
public class HaiApplication extends SpringApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(HaiApplication.class)
                .build()
                .run(args);
    }

}
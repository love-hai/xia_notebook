package com.xhf.study;

import com.xhf.study.service.thread.ChangeWebTitle;
import com.xhf.study.service.thread.MainThreadEngine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Callable;

/**
 * @projectName: test
 * @package: com.xhf.study
 * @className: XhfTestApplication
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/9/7 9:18
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/7 9:18
 * @updateRemark:
 * @version: v1.0
 */
@EnableFeignClients
@Configuration
@EnableAsync
@SpringBootApplication
@ComponentScan(basePackages = {"com.xhf"})
@Slf4j
public class XhfTestApplication {
    public static void main(String[] args) {
        Callable callable = new ChangeWebTitle("Temu浏览器帮助文档");
        MainThreadEngine mainThreadEngine=new MainThreadEngine(callable);
        Boolean result = mainThreadEngine.call();
        log.info("result:{}",result);
    }

}

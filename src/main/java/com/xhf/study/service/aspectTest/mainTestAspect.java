package com.xhf.study.service.aspectTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;

/**
 * @projectName: test
 * @package: com.xhf.study.service.aspectTest
 * @className: mianTestAspect
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/9/6 14:47
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/6 14:47
 * @updateRemark:
 * @version: v1.0
 */
@Slf4j
@ComponentScan("com.xhf.study.service.aspectTest")
public class mainTestAspect {

    public static void main(String[] args) {
        AopDemoService aopDemoService = new AopDemoService();
        aopDemoService.doMethod1();
        aopDemoService.doMethod2();
        try {
            aopDemoService.doMethod3();
        } catch (Exception e) {
            log.error("exception: ", e);
        }
    }
}

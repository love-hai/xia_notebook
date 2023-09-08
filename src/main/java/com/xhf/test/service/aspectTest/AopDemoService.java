package com.xhf.test.service.aspectTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @projectName: test
 * @package: com.xhf.test.service.aspectTest
 * @className: AopDemoService
 * @descriptions: 需要被切面的目标类
 * @author: xiahaifeng
 * @createDate: 2023/9/6 14:45
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/6 14:45
 * @updateRemark:
 * @version: v1.0
 */
@Slf4j
@Service
public class AopDemoService {
    public void doMethod1() {
        log.info("AopDemoServiceImpl.doMethod1()");
    }
    public String doMethod2() {
        log.info("AopDemoServiceImpl.doMethod2()");
        return "hello world";
    }

    public String doMethod3() throws Exception {
        log.info("AopDemoServiceImpl.doMethod3()");
        throw new Exception("some exception");
    }


}

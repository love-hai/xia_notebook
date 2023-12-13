package com.xhf.test.service;

import com.xhf.test.model.IntWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @projectName: test
 * @package: com.xhf.test.service
 * @className: mainTest
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/9/21 14:20
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/21 14:20
 * @updateRemark:
 */
@Slf4j
public class mainTest {
    @Autowired
    private static ReadTime readTime;

    public static void main(String[] args) {
       String a ="123";
        int i = a.charAt(1) - '0';
        System.out.println(i);


    }

    private void test(IntWrapper a,int b){
        a.setValue(a.getValue()+1);
        b = 2;
        log.info("a:{},b:{}",a.getValue(),b);
    }
}

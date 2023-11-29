package com.xhf.test.service;

import com.xhf.test.model.IntWrapper;
import lombok.extern.slf4j.Slf4j;


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

    public static void main(String[] args) {
        IntWrapper q = new IntWrapper(1);
        int b = 1;
        mainTest mainTest = new mainTest();
        mainTest.test(q,b);
        log.info("a:{},b:{}",q.getValue(),b);
    }

    private void test(IntWrapper a,int b){
        a.setValue(a.getValue()+1);
        b = 2;
        log.info("a:{},b:{}",a.getValue(),b);
    }
}

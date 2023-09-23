package com.xhf.test.service;

import java.util.List;

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

public class mainTest {

    public static void main(String[] args) {
//        List<String> list = Lists.newArrayList();
        Integer count = 1;
        while (count <= 100) {
            List<String> list = new A1(count).getList();
            list=null;
            System.gc();
            System.out.println(list);
            count++;
        }
    }
}

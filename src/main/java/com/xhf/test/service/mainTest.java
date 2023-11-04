package com.xhf.test.service;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
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
@Slf4j
public class mainTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("178895");
        list.add("1.1.-8");
        list.add("1.1");
        list.add("1.1.1");
        list.add("");
        list.add(".");
        list.add("1.");
        list.add(".1");
        list.add("1.1.");
        list.add("1.1.1.");
        list.add("56xw.555");
        list.add(".555");
        String regex = "^[0-9]+(.[0-9]+)*$";
        list.forEach(versionNo -> {
            Boolean result = versionNo.matches(regex);
            log.info("versionNo: {}", versionNo);
            log.info("result: {}", result);
        });

    }
}

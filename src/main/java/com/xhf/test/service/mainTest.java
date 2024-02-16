package com.xhf.test.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

@Slf4j
public class mainTest {

    public static void main(String[] args) {
        List<String> a = null;
        if(CollectionUtils.isNotEmpty(a)){
            log.info("a is not empty");
        }else {
            log.info("a is empty");
        }
    }
}

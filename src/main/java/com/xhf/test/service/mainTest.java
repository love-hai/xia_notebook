package com.xhf.test.service;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class mainTest {

    public static void main(String[] args) {
        BigDecimal deductionRate= new BigDecimal("0.03");
        log.info("deductionRate:{}",deductionRate);
        log.info(new BigDecimal("1").subtract(deductionRate).toString());
    }
}

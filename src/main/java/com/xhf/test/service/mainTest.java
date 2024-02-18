package com.xhf.test.service;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

@Slf4j
public class mainTest {

    public static void main(String[] args) {
        int j=1;
        try {
            new TestCall(j).call();
        } catch (Exception e) {
            log.error("线程{}执行异常",j);
        }
    }


    public static class TestCall implements Callable<String> {

        private Integer i;
        public TestCall(Integer i) {
            this.i = i;
        }
        @Override
        public String call() throws Exception {
            log.info("线程{}开始执行",i);
            while (true){
                i++;
                log.info("线程{}执行中",i);
                if(i>=10){
                    break;
                }
            }
            return "线程"+i+"执行完成";
        }
    }
}

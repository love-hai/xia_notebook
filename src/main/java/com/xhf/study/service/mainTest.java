package com.xhf.study.service;

import com.xhf.study.model.A;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class mainTest {

    public static void main(String[] args) {
        List<A> list = new ArrayList<>();
        A a = new A();
        a.setA("1");
        a.setB(false);
        list.add(a);
        A a1 = new A();
        a1.setA("2");
        a1.setB(true);
        list.add(a1);
        A a2 = new A();
        a2.setA("2");
        a2.setB(true);
        list.add(a2);
        list = list.stream().distinct().collect(java.util.stream.Collectors.toList());
        log.info("list:{}", list);

    }
}
package com.xhf.study.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Student
 * @author xiahaifeng
 * @since 2023/11/22 13:38
 */
@Data
public class Student implements Serializable {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

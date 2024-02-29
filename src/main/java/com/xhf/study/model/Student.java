package com.xhf.study.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @projectName: test
 * @package: com.xhf.study.model
 * @className: Student
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/11/22 13:38
 * @updateUser: xiahaifeng
 * @updateDate: 2023/11/22 13:38
 * @updateRemark:
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

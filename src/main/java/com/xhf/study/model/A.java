package com.xhf.study.model;

import lombok.Data;

/**
 * A
 * @author xiahaifeng
 * @since 2023/9/5 11:34
 */
@Data
public class A {
    private String a;

    private Boolean b=true;

    public int cAdd(){
        return c++;
    }

    private Integer c=1;
}

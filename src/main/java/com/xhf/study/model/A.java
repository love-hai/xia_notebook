package com.xhf.study.model;

import lombok.Data;

/**
 * @projectName: test
 * @package: com.xhf.study.model
 * @className: A
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/9/5 11:34
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/5 11:34
 * @updateRemark:
 * @version: v1.0
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

package com.xhf.study.service;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: test
 * @package: com.xhf.study.service
 * @className: A1
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/9/21 16:45
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/21 16:45
 * @updateRemark:
 */
@Data
public class A1{
    public A1(Integer a){
        for(Integer i=0;i<a;i++){
            list.add(i.toString());
        }
    }
    private List<String> list=new ArrayList<>();

}

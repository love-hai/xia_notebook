package com.xhf.study.service;

import com.xhf.study.model.A;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: test
 * @package: com.xhf.study.service
 * @className: ChangeModel
 * @descriptions: 了解引用的规则
 * @author: xiahaifeng
 * @createDate: 2023/9/18 17:14
 * @updateUser: xiahaifeng
 * @updateDate: 2023/9/18 17:14
 * @updateRemark:
 */

/**
 * 我们运行程序可以看到，当递归返回时，引用数据类型的值变成了最后一次递归的值，而基本数据类型的值没有变化则是在对应的堆栈中的值。
 */
public class ChangeModel {

    public static void main(String[] args) {
//        A a = new A();
//        a.setA("1");
//        a.setB(true);
//        Integer count=1;
//        count++;
//        count++;
//        count++;
//        count++;
//        count++;
//        change(a,count,true);
        List<Integer> list = new ArrayList<>();
        change(list);
        change(list);
    }

    /**
     * @Description: 
     * @param a     com.xhf.study.model.A  :引用数据类型
     * @param count java.lang.Integer     : 
     * @return: void
     * @Author: xiahaifeng
     * @Date: 2023/9/18 17:25
     */
    private static void change(A a, Integer count,Boolean flag) {
        A a1 =new A();
        BeanUtils.copyProperties(a,a1);
        if(count<10){
            a.setA(count.toString());
            a.setB(flag);
            System.out.println(a.toString());
            change(a,++count,!flag);
        }
        System.out.println(a1.toString());
        System.out.println(count);
        System.out.println(flag);

    }

    private static void change(List<Integer> list){
        Integer num =list.size();
        num++;
        list.add(num);
        System.out.println(list.toString());
    }

}

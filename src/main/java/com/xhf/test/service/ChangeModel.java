package com.xhf.test.service;

import com.xhf.test.model.A;

/**
 * @projectName: test
 * @package: com.xhf.test.service
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
        A a = new A();
        a.setA("1");
        a.setB(true);
        Integer count=1;
        count++;
        count++;
        count++;
        count++;
        count++;
        change(a,count,true);
    }

    /**
     * @Description: 
     * @param a     com.xhf.test.model.A  :引用数据类型
     * @param count java.lang.Integer     : 
     * @return: void
     * @Author: xiahaifeng
     * @Date: 2023/9/18 17:25
     */
    private static void change(A a, Integer count,Boolean flag) {
        if(count<5){
            a.setA(count.toString());
            a.setB(flag);
            System.out.println(a.toString());
            change(a,++count,!flag);
        }
        System.out.println(a.toString());
        System.out.println(count);
        System.out.println(flag);

    }

}

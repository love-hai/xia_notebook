package com.xhf.test.service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @projectName: test
 * @package: com.xhf.test.service
 * @className: reflectionTest
 * @descriptions:
 * @author: xiahaifeng
 * @createDate: 2023/8/17 11:21
 * @updateUser: xiahaifeng
 * @updateDate: 2023/8/17 11:21
 * @updateRemark:
 * @version: v1.0
 */

public class ReflectionTest {
    public static void main(String[] args) {
        ImportExcelFile importExcelFile = new ImportExcelFile();
        Class<?> clazz = importExcelFile.getClass();

        // 获取所有属性
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field Name: " + field.getName());
            System.out.println("Field Type: " + field.getType());
            System.out.println();
        }

        // 获取所有方法
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method Name: " + method.getName());
            System.out.println("Parameter Count: " + method.getParameterCount());
            System.out.println("Parameter Types: " + method.getParameterTypes()[0].getName());
            System.out.println("Return Type: " + method.getReturnType());
            System.out.println();
        }
    }
}

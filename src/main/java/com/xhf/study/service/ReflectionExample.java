package com.xhf.study.service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射示例
 * @author xiahaifeng
 * @since 2023/8/17 11:21
 */

public class ReflectionExample {
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
            for(Class<?> parameterType : method.getParameterTypes()) {
                System.out.println("Parameter Types: " + parameterType.getName());
            }
            System.out.println("Return Type: " + method.getReturnType());
            System.out.println();
        }
    }
}

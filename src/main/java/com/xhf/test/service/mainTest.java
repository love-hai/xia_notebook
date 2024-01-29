package com.xhf.test.service;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class mainTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入文本（遇到换行符即结束）：");

        // 使用 hasNextLine() 判断是否还有下一行输入
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println("你输入的是：" + line);

            // 如果输入为空行（只有换行符），则结束循环
            if (line.isEmpty()) {
                break;
            }
        }

        // 关闭 Scanner
        scanner.close();
    }

}

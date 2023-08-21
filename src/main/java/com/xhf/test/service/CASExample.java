package com.xhf.test.service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @projectName: test
 * @package: com.xhf.test.service
 * @className: CASTest
 * @descriptions: 测试CAS锁
 * @author: xiahaifeng
 * @createDate: 2023/8/21 9:01
 * @updateUser: xiahaifeng
 * @updateDate: 2023/8/21 9:01
 * @updateRemark:
 * @version: v1.0
 */

public class CASExample {
    private AtomicInteger value = new AtomicInteger(0);

    public int increment() {
        int current;
        int next;
        while(true) {
            if (value.get() == 100) {
                return -1;
            }
            current = value.get();
            next = current + 1;
            if (value.compareAndSet(current, next)) {
                return next;
            }
        }
    }

    public int getValue() {
        return value.get();
    }

    public static void main(String[] args) {
        CASExample counter = new CASExample();

        // 创建多个线程并发地增加计数器的值
        Thread thread1 = new Thread(() -> {
            while (true) {
                int value = counter.increment();
                System.out.println("thread1:页数"+value);
                if(value== -1){
                    break;
                }else{
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                int value = counter.increment();
                System.out.println("thread2:页数"+value);
                if(value== -1){
                    break;
                }else{
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

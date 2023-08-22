package com.xhf.test.service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
/**
 * @projectName: test
 * @package: com.xhf.test.service
 * @className: AQSExample
 * @descriptions: AQS示例
 * @author: xiahaifeng
 * @createDate: 2023/8/22 8:43
 * @updateUser: xiahaifeng
 * @updateDate: 2023/8/22 8:43
 * @updateRemark:
 * @version: v1.0
 */

public class AQSExample {
    private Sync sync = new Sync();

    // 获取锁
    public void lock() {
        sync.acquire(1);
    }

    // 释放锁
    public void unlock() {
        sync.release(1);
    }

    // 内部静态类，继承自AQS
    private static class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int acquires) {
            // 通过CAS操作尝试获取锁
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int releases) {
            // 释放锁，将状态置为0
            if (getState() == 0)
                throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
    }

    public static void main(String[] args) {
        AQSExample mutex = new AQSExample();
        // 创建两个线程来演示互斥锁的使用
        Thread thread1 = new Thread(() -> {
            mutex.lock();
            try {
                System.out.println("Thread 1: Lock acquired.");
                Thread.sleep(2000); // 模拟工作
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                mutex.unlock();
                System.out.println("Thread 1: Lock released.");
            }
        });

        Thread thread2 = new Thread(() -> {
            mutex.lock();
            try {
                System.out.println("Thread 2: Lock acquired.");
                Thread.sleep(1000); // 模拟工作
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                mutex.unlock();
                System.out.println("Thread 2: Lock released.");
            }
        });

        thread1.start();
        thread2.start();
    }
}


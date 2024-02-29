package com.xhf.study.service;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * AQS示例
 * @author: xiahaifeng
 * @since 2023/8/22 8:43
 */

/**
 * 公平锁（Fair Lock）：
 * 在公平锁中，线程按照请求锁的顺序依次获得锁。当一个线程请求锁时，如果发现锁已经被其他线程占用，
 * 它会被放入一个等待队列中，按照先来后到的原则等待获取锁。公平锁确保了等待时间最长的线程最终能
 * 够获取锁，避免了线程饥饿现象。公平锁通常会引入较大的性能开销，因为需要维护等待队列和线程的顺序。
*/
/**
 * 非公平锁（Unfair Lock）：
 * 在非公平锁中，线程请求锁时，如果锁已经被其他线程占用，它会立即尝试获取锁，而不会进入等待队列。
 * 这意味着后来的线程可能在早期的线程之前获得锁，不考虑等待时间的长短。非公平锁通常比公平锁具有
 * 更高的性能，因为不需要维护严格的等待队列顺序，但可能会导致某些线程长时间等待，产生线程饥饿问题。
 * 选择使用公平锁还是非公平锁取决于应用程序的需求。如果需要确保所有线程都能公平地访问共享资源，可
 * 以选择公平锁。但要注意，公平锁可能会降低系统的吞吐量。如果对吞吐量要求较高，可以选择非公平锁，
 * 但需要注意可能会出现线程饥饿的情况，需要采取其他手段来解决。Java中的ReentrantLock类可以根
 * 据需要选择公平锁或非公平锁，通过构造函数的参数来指定。默认情况下，ReentrantLock是非公平锁。
 */
public class AQSExample {
    private Sync sync = new Sync();
    /**
     * @Description: 获取锁，如果锁已被占用，则加入等待队列
     * @Param: []:[]
     * @return: void
     * @Author: xiahaifeng
     * @Date: 2023/8/22 10:24
     */
    public void lock() {
        sync.acquire(1);
    }

    // 释放锁，并且检查队列是否有等待者，如果有，则唤醒等待队列中的第一个线程
    public void unlock() {
        sync.release(1);
    }

    // 内部静态类，继承自AQS
    private static class Sync extends AbstractQueuedSynchronizer {
        /**
         * @Description: 尝试获取锁，立即返回。成功则将该线程变成该锁的拥有者，返回true，否则返回false。
         * @Param: [int]:[acquires]
         * @return: boolean
         * @Author: xiahaifeng
         * @Date: 2023/8/22 10:20
         */
        @Override
        protected boolean tryAcquire(int acquires) {
            // 通过CAS操作尝试获取锁
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        /**
         * @Description: 尝试释放锁，立即返回。如果锁本来就是被释放的，就会被报错，否则将锁的拥有者置为null，返回true
         * @Param: [int]:[releases]
         * @return: boolean
         * @Author: xiahaifeng
         * @Date: 2023/8/22 10:26
         */
        @Override
        protected boolean tryRelease(int releases) {
            // 释放锁，将状态置为0
            if (getState() == 0)
                throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
        /**
         * @Description: 判断锁是否被占用
         * @Param: []:[]
         * @return: boolean
         * @Author: xiahaifeng
         * @Date: 2023/8/22 10:29
         */
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


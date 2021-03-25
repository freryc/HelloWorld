/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer19;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用ReentrantLock类解决线程死锁的问题--jdk5.0新增
 * <p>
 * 面试题：synchronize 与 lock的异同点：
 * 相同：都可以解决线程安全问题
 * 异同：synchronize自动解锁，lock手动上锁和解锁(更加灵活)
 * <p>
 * 推荐使用：lock() > synchronize代码块 > synchronize方法
 *
 * @author z00440867
 * @since 2021-01-23
 */
public class LockTest {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread thread1 = new Thread(ticket);
        Thread thread2 = new Thread(ticket);
        Thread thread3 = new Thread(ticket);

        thread1.setName("线程一");
        thread2.setName("线程二");
        thread3.setName("线程三");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Ticket implements Runnable {
    private static int ticketNum = 100;

    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();

                if (ticketNum > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "票号：" + ticketNum);
                    ticketNum--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer18;

/**
 * 同步代码块解决线程安全问题
 * 1.同步代码块
 * *使用如下结构将可能操作共享数据的放在大括号里；
 * synchronized (消息监视器) {
 * // 需要被同步的代码
 * }
 * *消息检视器也被成为“锁”
 * *必须使用同一把锁，锁可以是任意对象
 *
 * @author z00440867
 * @since 2021-01-23
 */
public class TicketTest {
    public static void main(String[] args) {
        // grabTicketsExtends();
        grabTicketsRunnable();
    }

    private static void grabTicketsExtends() {
        TicketExtendsTest ticketExtendsTest1 = new TicketExtendsTest();
        TicketExtendsTest ticketExtendsTest2 = new TicketExtendsTest();
        TicketExtendsTest ticketExtendsTest3 = new TicketExtendsTest();

        ticketExtendsTest1.setName("线程一");
        ticketExtendsTest2.setName("线程二");
        ticketExtendsTest3.setName("线程三");

        ticketExtendsTest1.start();
        ticketExtendsTest2.start();
        ticketExtendsTest3.start();
    }

    private static void grabTicketsRunnable() {
        TicketRunnableTest ticketRunnableTest = new TicketRunnableTest();
        Thread thread1 = new Thread(ticketRunnableTest);
        Thread thread2 = new Thread(ticketRunnableTest);
        Thread thread3 = new Thread(ticketRunnableTest);

        thread1.setName("线程一");
        thread2.setName("线程二");
        thread3.setName("线程三");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class TicketExtendsTest extends Thread {
    private static int ticketNum = 100;

    private static final Object object = new Object();

    @Override
    public void run() {
        while (true) {
            // 同步代码块解决线程同步问题，必须使用同一把锁，锁可以是任一对象
            // synchronized (TicketExtendsTest.class) {
            synchronized (object) {
                if (ticketNum > 0) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() + "票号：" + ticketNum);
                    ticketNum--;
                } else {
                    break;
                }
            }
        }
    }
}

class TicketRunnableTest implements Runnable {
    private static int ticketNum = 100;

    @Override
    public void run() {
        show();
    }

    private synchronized void show() {// 同步锁是this
        while (true) {
            if (ticketNum > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() + "票号：" + ticketNum);
                ticketNum--;
            } else {
                break;
            }
        }
    }
}
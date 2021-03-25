/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer19;

/**
 * 同步方法解决线程安全问题
 * 2.同步方法
 * 同步方法只是没有显式的写出锁名称，依然是上锁的思想来保证线程同步
 *
 * @author z00440867
 * @since 2021-01-23
 */
public class TicketTest {
    public static void main(String[] args) {
        grabTicketsExtends();
        // grabTicketsRunnable();
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

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    public static synchronized void show() {// 此时的锁是TicketExtendsTest类
        if (ticketNum > 0) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getName() + "票号：" + ticketNum);
            ticketNum--;
        }
    }
}

class TicketRunnableTest implements Runnable {
    private static int ticketNum = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    public synchronized void show() {//此时的锁是this
        if (ticketNum > 0) {
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程" + Thread.currentThread().getName() + "票号：" + ticketNum);
            ticketNum--;
        }
    }
}
/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer17;

/**
 * 多线程的创建与执行：
 * 1.创建一个自定义线程类继承与基类Thread
 * 2.重写自定义线程类中的run方法
 * 3.创建一个自定义线程类的对象
 * 4.对象调用start()方法
 * <p>
 * 线程的常用方法：
 * 1.start():启动当前线程，并调用该线程的run()
 * 2.run():将创建的线程要执行的操作声明在此方法中
 * 3.currentThread():静态方法，返回当前线程对象
 * 4.getName():获取当前线程名称
 * 5.setName():设置当前线程名称
 * 6.yield():释放当前cpu的执行权
 * 7.join():在线程a中调用b.join()时，此时线程a就进入阻塞状态，直到线程b完全执行完后，线程a才结束阻塞状态
 * 8.stop():已过时，当执行此方法时，强制结束当前线程。
 * 9.sleep(long milltime):让当前线程“睡眠”指定的毫秒，在指定的睡眠时间内，当前线程为阻塞状态
 * 10.isAlive():查询当前线程是否存活
 * <p>
 * 线程的优先级：
 * 1.MAX_PRIORITY:10
 * 2.MIN_PRIORITY:1
 * 3.NORM_PRIORITY:5
 * 如何获取和设置当前线程的优先级：
 * getPriority():获取当前线程的优先级
 * setPriority:设置当前线程的优先级
 * 说明：高优先级的线程会抢占低优先级线程的cpu执行权。但是只是从概率上讲，高优先级的线程高概率被执行。
 * 并不意味着只有当高优先级的线程执行完后，低优先级的线程才执行。
 *
 * @author z00440867
 * @since 2021-01-22
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        myThread1.setName("线程一");
        myThread1.setPriority(Thread.MAX_PRIORITY);
        myThread1.start();// 1.启动该线程；2.调用该线程的run方法
        
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(
                    Thread.currentThread().getName() + "：" + "线程优先级：" + Thread.currentThread().getPriority() + "当前数字："
                        + i);
            }

            // if (i == 19) {
            //     try {
            //         myThread1.join();
            //     } catch (InterruptedException e) {
            //         e.printStackTrace();
            //     }
            // }
        }
        // System.out.println(myThread1.isAlive());

    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(getName() + "：" + "线程优先级：" + getPriority() + "当前数字：" + i);
            }

            // if (i % 20 == 0) {
            //     Thread.yield();
            // }
            // try {
            //     sleep(100);
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
        }
    }
}
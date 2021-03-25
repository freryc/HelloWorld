/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer19;

/**
 * 死锁：
 * 不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃自己需要的同步资源，就形成了线程的死锁。
 * 出现死锁后，不会出现异常，不会出现提示，只是所有的线程都处于阻塞状态，无法继续。
 * <p>
 * 解决办法：
 * 1.专门的算法、原则
 * 2.尽量减少同步资源的定义
 * 3.尽量避免同步嵌套定义
 *
 * @author z00440867
 * @since 2021-01-23
 */
public class DeadLockTest {
    public static void main(String[] args) {
        StringBuffer stringBuffer1 = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();

        new Thread(new Runnable() {

            @Override
            public void run() {

                synchronized (stringBuffer1) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    stringBuffer1.append("a");
                    stringBuffer2.append("1");

                    synchronized (stringBuffer2) {
                        stringBuffer1.append("b");
                        stringBuffer2.append("2");

                        System.out.println(stringBuffer1);
                        System.out.println(stringBuffer2);
                    }
                }
            }
        }).start();

        new Thread() {
            @Override
            public void run() {

                synchronized (stringBuffer2) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    stringBuffer1.append("c");
                    stringBuffer2.append("3");

                    synchronized (stringBuffer1) {
                        stringBuffer1.append("d");
                        stringBuffer2.append("4");

                        System.out.println(stringBuffer1);
                        System.out.println(stringBuffer2);
                    }
                }
            }
        }.start();
    }
}

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer19;

/**
 * 线程间通信
 * 例子：使用两个线程打印1-100，线程1，线程2，交替打印
 * <p>
 * 涉及到三个方法：
 * wait()：一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
 * notify()：一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就唤醒优先级高的。
 * notifyAll()：一旦执行此方法，就会唤醒被wait的所有线程
 * <p>
 * 说明：
 * 1.wait()、notify()、notifyAll()：三个方法必须使用在同步代码块或同步方法中；
 * 2.wait()、notify()、notifyAll()：三个方法必须使用同一个同步监视器（锁），否则会出现IllegalMonitorStateException异常；
 * 3.wait()、notify()、notifyAll()：三个方法是定义在java.lang.Object类中。
 * <p>
 * 面试题：
 * wait()和sleep()异同点：
 * 相同点：都可以使线程进入阻塞状态。
 * 不同点：①声明位置不同，wait()声明在Object类中，调用者是任意对象；sleep()声明在Thread类中的静态方法，调用者只能是Thread类的对象。
 * ②使用位置不同，wait()只能使用在同步代码块或同步方法中，sleep()可以使用在任意地方。
 * ③释放锁不同：线程wait()后自动释放同步监视器，sleep()后并未释放同步监视器。
 *
 * @author z00440867
 * @since 2021-01-23
 */
public class ThreadCommunicationTest {
    public static void main(String[] args) {
        ThreadCommunication threadCommunication = new ThreadCommunication();
        Thread thread1 = new Thread(threadCommunication);
        Thread thread2 = new Thread(threadCommunication);

        thread1.setName("线程1");
        thread2.setName("线程2");

        thread1.start();
        thread2.start();
    }
}

class ThreadCommunication implements Runnable {
    private static int number = 1;

    Object object = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (object) {
                object.notify();

                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + "：" + number);
                    number++;
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
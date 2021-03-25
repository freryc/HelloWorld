/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer17;

/**
 * 通过runnable的方式创建线程
 * 1.创建一个实现了Runnable接口的类
 * 2.实现类去重写Runnable接口的抽象方法run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数传入Thread类的构造器中，创建线程对象
 * 5.通过Thread类对象调用start方法
 * <p>
 * 比较创建线程的两种方式：
 * 开发中优先选择：实现Runnable接口的方式
 * 原因：1.实现的方式没有类的单继承的局限性
 * 2.实现的方式更适合来处理多个线程有共享数据的情况
 * <p>
 * 联系：Thread类也是通过实现Runnable接口的方式创建的
 * 相同点：都需要去重写run()方法，将要执行的逻辑放在run()方法中
 *
 * @author z00440867
 * @since 2021-01-22
 */
public class RunnableThreadTest {
    public static void main(String[] args) {
        // 3.创建实现类的对象
        ThreadDemo threadDemo = new ThreadDemo();
        // 4.将此对象作为参数传入Thread类的构造器中，创建线程对象
        Thread thread = new Thread(threadDemo);
        thread.setName("线程一");
        // 5.通过Thread类对象调用start方法:①启动线程；②调用当前线程的run()-->调用了Runnable类型target的run()
        thread.start();

        // 如果想重新启动一个相同功能的线程，不需要重新new实现类的对象，只需要重新new Thread类的对象
        Thread thread1 = new Thread(threadDemo);
        thread1.setName("线程二");
        thread1.start();
    }
}

/**
 * 1.创建一个实现了Runnable接口的类
 *
 * @author z00440867
 * @since 2021/1/22
 */
class ThreadDemo implements Runnable {

    /**
     * 2.实现类去重写Runnable接口的抽象方法run()
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println("线程名：" + Thread.currentThread().getName() + "：" + i);
            }
        }
    }
}
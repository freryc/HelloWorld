/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer19;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable接口创建线程
 * 使用这种方式创建线程的好处：
 * 1.线程带返回值，可作为其他线程的输入
 * 2.线程可以抛出异常，被外面的操作捕获，获取异常信息
 * 3.Callable接口是支持泛型的
 *
 * @author z00440867
 * @since 2021-01-25
 */
public class CallableThreadTest {
    public static void main(String[] args) {
        // 3.创建实现了Callable接口的实现类对象
        CallableThread callableThread = new CallableThread();
        // 4.将此Callable接口的实现类对象传入FutureTask的构造器中，创建FutureTask类的对象，
        FutureTask futureTask = new FutureTask(callableThread);
        // 5.将FutureTask类的对象作为参数传入Thread的构造器中，创建Thread类对象，并调用start()
        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            // 6.获取Callable中call方法的返回值
            Integer sum = (Integer) futureTask.get();// get()返回值即为FutureTask构造器参数Callable接口的实现类重写的call()的返回值
            System.out.println(sum);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 1.创建一个实现了Callable接口的实现类
 *
 * @author z00440867
 * @since 2021/1/25
 */
class CallableThread implements Callable {
    /**
     * 2.实现call方法，将线程中要执行的操作声明在call方法中
     *
     * @return
     * @throws Exception
     */
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "：" + i);
                sum += i;
            }
        }
        return sum;
    }
}
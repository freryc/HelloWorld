/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer19;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 使用线程池的方式创建多线程
 * 背景：频繁创建线程和销毁，消耗特别大的资源，比如并发情况下的线程，对性能影响很大
 * 思路：提前创建好多个线程，放入线程池中。使用时直接获取，使用完放回池中。可以避免频繁创建销毁，实现重复利用。
 * 好处：1.提高相应速度（减少了创建线程的时间）
 * 2.降低资源消耗（重复利用线程池中的线程，不需要每次都创建）
 * 3.便于线程管理：corePoolSize(核心池大小)、maximumPoolSize(最大线程数)、keepAliveTime(线程没有任务时最多保持多长时间后终止)
 *
 * @author z00440867
 * @since 2021-01-25
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        // 1.创建指定数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 设置线程池的属性
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
        threadPoolExecutor.setCorePoolSize(10);

        // 2.执行指定线程的操作。需要提供实现了Runnable接口或Callable接口的实现类对象
        MyThread myThread = new MyThread();
        executorService.execute(myThread);// 适用于Runnable
        // executorService.submit(Callable callable);// 适用于Callable

        // 3.关闭连接池
        executorService.shutdown();
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }
        }
    }
}
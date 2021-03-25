/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer19;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 练习题：银行有一个账户，现有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 *
 * @author z00440867
 * @since 2021-01-23
 */
public class StoreMoneyTest {
    public static void main(String[] args) {
        StoreMoney storeMoney = new StoreMoney();
        Thread usr1 = new Thread(storeMoney);
        Thread usr2 = new Thread(storeMoney);

        usr1.setName("用户1");
        usr2.setName("用户2");

        usr1.start();
        usr2.start();
    }
}

class StoreMoney implements Runnable {
    static int count = 0;

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                lock.lock();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                count += 1000;
                System.out.println(Thread.currentThread().getName() + "存钱，" + "余额：" + count);
            } finally {
                lock.unlock();
            }
        }
    }
}
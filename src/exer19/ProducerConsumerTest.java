/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer19;

/**
 * 多线程经典问题：生产者和消费者问题
 *
 * @author z00440867
 * @since 2021-01-23
 */
public class ProducerConsumerTest {
    public static void main(String[] args) {
        Product product = new Product();

        Producer producer = new Producer(product);
        Consumer consumer = new Consumer(product);
        Consumer consumer2 = new Consumer(product);

        producer.setName("生产者");
        consumer.setName("消费者");
        consumer2.setName("消费者2");

        producer.start();
        consumer.start();
        consumer2.start();
    }
}

class Product {
    private int productNum;

    /**
     * 生产产品
     */
    public synchronized void product() {
        if (productNum < 20) {
            productNum++;
            System.out.println(Thread.currentThread().getName() + "生产第" + productNum + "个产品");
            notify();
        } else {
            // 等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 消费产品
     */
    public synchronized void consume() {
        if (productNum > 0) {
            System.out.println(Thread.currentThread().getName() + "消费第" + productNum + "个产品");
            productNum--;
            notify();
        } else {
            // 等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread {
    private Product product;

    public Producer(Product product) {
        this.product = product;
    }

    /**
     * 生产者生产产品
     */
    @Override
    public void run() {
        while (true) {
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            product.product();
        }
    }
}

class Consumer extends Thread {
    private Product product;

    public Consumer(Product product) {
        this.product = product;
    }

    /**
     * 消费者消费产品
     */
    @Override
    public void run() {
        while (true) {
            try {
                Thread.currentThread().sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            product.consume();
        }
    }
}
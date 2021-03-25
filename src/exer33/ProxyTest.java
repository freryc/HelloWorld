/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer33;

import org.junit.Test;

/**
 * 静态代理模式
 * 特点：代理类和被代理类在编译期就确定下来了
 * 要素：
 * 1.代理类和被代理类都实现了同一个接口
 * 2.代理类有一个接收抽象方法作为参数的构造器，实际new代理类时传入的参数为被代理类
 * 3.调用代理类的抽象方法，实际也调用了被代理类的抽象方法
 *
 * @author z00440867
 * @since 2021-02-27
 */
interface ClothFactory {
    void produceCloth();
}

/**
 * 代理类
 *
 * @author z00440867
 * @since 2021/2/27
 */
class proxyClothFactory implements ClothFactory {
    ClothFactory clothFactory;

    public proxyClothFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理类生产衣服前的准备工作");

        clothFactory.produceCloth();

        System.out.println("代理类生产完衣服后的清理工作");
    }
}

/**
 * 被代理类
 *
 * @author z00440867
 * @since 2021/2/27
 */
class NikeClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂开始生产衣服");
    }
}

public class ProxyTest {
    @Test
    public void test1() {
        NikeClothFactory nikeClothFactory = new NikeClothFactory();

        proxyClothFactory proxyClothFactory = new proxyClothFactory(nikeClothFactory);
        // 调用代理类的抽象方法，实际执行了被代理类的抽象方法
        proxyClothFactory.produceCloth();
    }
}

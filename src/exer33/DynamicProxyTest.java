/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer33;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 反射应用举例：动态代理
 *
 * @author z00440867
 * @since 2021-02-27
 */

/**
 * 共同实现的接口
 *
 * @author z00440867
 * @since 2021/2/27
 */
interface Human {
    String getBelief();

    void eat(String food);
}

/**
 * SuperMan:被代理类
 *
 * @author z00440867
 * @since 2021/2/27
 */
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "I Believe I Can Fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

/**
 * ProxyFactory
 * 功能：根据被代理类动态生产代理实例
 */
class ProxyFactory {
    /**
     * 根据被代理类动态生产代理类实例
     *
     * @param o:被代理类
     * @return:代理类
     */
    public static Object getProxyInstance(Object o) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(o);
        return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), myInvocationHandler);
    }
}

class MyInvocationHandler implements InvocationHandler {
    Object obj;

    public MyInvocationHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(obj, args);
    }
}

public class DynamicProxyTest {
    @Test
    public void test1() {
        SuperMan superMan = new SuperMan();
        // 通过代理类工厂动态的创建代理类
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("酸菜鱼");

        // 体现动态性，动态的根据被代理类创建代理类
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyInstance1 = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyInstance1.produceCloth();
    }
}

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer15;

/**
 * 抽象类和接口的应用
 * 类和接口是同级的概念，用的时候大多利用的是多态性
 *
 * @author z00440867
 * @since 2021-01-21
 */
public class AbstractClassInterfaceTest {
    public static void main(String[] args) {
        AbstractClassInterface abstractClassInterface = new AbstractClassInterface();
        Dog dog = new Dog();
        // 传入的是实现了抽象类和接口的抽象方法的子类，利用的是多态性
        abstractClassInterface.method1(dog);
        abstractClassInterface.method2(dog);

        // 接口的匿名实现类的匿名对象
        abstractClassInterface.method1(new Walkable() {
            @Override
            public void walk() {
                System.out.println("cat can walk");
            }
        });

        // 抽象类的匿名子类的匿名对象
        abstractClassInterface.method2(new Animal() {
            @Override
            public void eat() {
                System.out.println("cat eat");
            }
        });
    }
}

class AbstractClassInterface {
    // 形参是接口类型
    public void method1(Walkable walkable) {
        walkable.walk();
    }

    // 形参是抽象类类型
    public void method2(Animal animal) {
        animal.eat();
    }
}

interface Walkable {
    public abstract void walk();
}

abstract class Animal {
    public abstract void eat();
}

class Dog extends Animal implements Walkable {

    @Override
    public void eat() {
        System.out.println("dog eat.");
    }

    @Override
    public void walk() {
        System.out.println("dog can walk");
    }
}
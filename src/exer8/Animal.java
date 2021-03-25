/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer8;

/**
 * @author z00440867
 * @since 2021-01-16
 */
public class Animal {
    int id = 100;

    public void eat() {
        System.out.println("动物：吃");
    }

    public void walk() {
        System.out.println("动物：行走");
    }

    public int getId() {
        return id;
    }

    public void showAge(int age) {
        System.out.println(age);
    }
}

class Dog extends Animal {
    int id = 101;

    @Override
    public void eat() {
        System.out.println("狗：吃");
    }

    @Override
    public void walk() {
        System.out.println("狗：行走");
    }

    @Override
    public int getId() {
        return id;
    }

    public void showAge(int age, double length) {
        System.out.println(age);
        System.out.println(length);
    }
}

class Cat extends Animal {
    int id = 102;

    @Override
    public void eat() {
        System.out.println("猫：吃");
    }

    @Override
    public void walk() {
        System.out.println("猫：行走");
    }

    @Override
    public int getId() {
        return id;
    }
}
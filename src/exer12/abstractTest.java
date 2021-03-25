/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer12;

/**
 * 抽象类的匿名子类的使用
 *
 * @author z00440867
 * @since 2021-01-20
 */
public class abstractTest {
    public static void main(String[] args) {
        method1(new Creature() {

            @Override
            public void walk() {
                System.out.println("抽象类的匿名子类的行走");
            }
        });
    }

    public static void method1(Creature creature) {
        creature.walk();
    }
}

abstract class Creature {
    public abstract void walk();
}
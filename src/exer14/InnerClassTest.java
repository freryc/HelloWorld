/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer14;

/**
 * 成员内部类的实例化
 *
 * @author z00440867
 * @since 2021-01-20
 */
public class InnerClassTest {
    public static void main(String[] args) {
        //静态成员内部类的实例化
        InnerClass.Bird bird = new InnerClass.Bird();
        bird.BirdMethod();

        //非静态成员内部类的实例化
        InnerClass innerClass = new InnerClass();
        InnerClass.Dog dog = innerClass.new Dog();
        dog.dogMethod();

        dog.show("秋田犬");
    }
}

class InnerClass {
    int age;

    String name = "内部类";

    class Dog {
        int age;

        String name = "二哈";

        public void dogMethod() {
            System.out.println("狗叫");
        }

        public void show(String name) {
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(InnerClass.this.name);
        }
    }

    static class Bird {
        int age;

        public void BirdMethod() {
            System.out.println("鸟叫");
        }
    }

    public void show() {
        int num = 0;// num为final类型

        class AA {
            public void method() {
                // num = 20; 在局部内部类的方法（method）中如果调用局部内部类所声明的方法（比如：show）中的局部变量，
                // 则要求此局部变量声明为final
                System.out.println(num);
            }
        }
    }
}
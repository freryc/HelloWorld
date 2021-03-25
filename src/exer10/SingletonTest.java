/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer10;

/**
 * 设计模式-单利模式的实现
 * what：采取一定的方法保证在整个软件系统中，对某个类只能存在一个对象实例
 * how：饿汉式和懒汉式
 * compare:饿汉式 vs 懒汉式
 * 饿汉式：坏处：对象加载时间过长，内存消耗；好处：线程安全
 * 懒汉式：坏处：线程不安全；好处：延迟对象创建，内存占用低
 *
 * @author z00440867
 * @since 2021-01-18
 */
public class SingletonTest {
    public static void main(String[] args) {
        Bank b1 = Bank.getInstance();

        Bank b2 = Bank.getInstance();
        System.out.println(b1 == b2);

        Student student1 = Student.getInstance();
        Student student2 = Student.getInstance();
        System.out.println(student1 == student2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                
            }
        });
    }

}

/**
 * 饿汉式实现单例模式
 *
 * @author z00440867
 * @since 2021/1/18
 */
class Bank {
    // 1.创建类的私有化空参构造器
    private Bank() {

    }

    // 2.内部创建类的对象
    // 4.要求此属性也必须声明为静态的
    private static Bank instance = new Bank();

    // 3.提供公共的方法，返回类的对象
    public static Bank getInstance() {
        return instance;
    }
}

/**
 * 懒汉式实现单例方法
 *
 * @author z00440867
 * @since 2021/1/18
 */
class Student {
    // 1.创建类的私有化空参构造器
    private Student() {

    }

    // 2.内部声明类的对象
    private static Student student = null;

    // 3.提供公共的方法，返回类的对象
    public static Student getInstance() {
        if (student == null) {
            student = new Student();
        }
        return student;
    }
}
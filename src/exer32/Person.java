/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer32;

import java.io.Serial;

/**
 * description
 *
 * @author z00440867
 * @since 2021-02-25
 */

@MyAnnotation(value = "class Person")
public class Person extends Creature<String> implements Comparable, MyInterface {
    @Serial
    private static final long serialVersionUID = 5830322373047584121L;

    private int age;

    private String name;

    int id;

    public String describle;

    @MyAnnotation(value = "class Person Constructor")
    public Person() {
        System.out.println("Hello World!");
    }

    private Person(String name) {
        this.name = name;
    }

    Person(String describle, int id) {
        this.describle = describle;
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @MyAnnotation
    private String showNation(String nation) {
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    private static String sing(String name) {
        System.out.println("我会唱的歌曲名称为：" + name);
        return name;
    }

    void shout() throws NullPointerException, ClassCastException {
        System.out.println("人会叫");
    }

    @Override
    public String toString() {
        return "Person{" + "age=" + age + ", name='" + name + '\'' + '}';
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

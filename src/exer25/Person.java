/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description
 *
 * @author z00440867
 * @since 2021-02-07
 */
public class Person<T> {
    private String name;

    private int age;

    private T t;

    public Person() {
    }

    public Person(String name, int age, T t) {
        this.name = name;
        this.age = age;
        this.t = t;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(arr));
        return arrayList;
    }
}

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer25;

/**
 * description
 *
 * @author z00440867
 * @since 2021-02-07
 */
public class SubPerson1<T, E> extends Person<T> {
    E e;

    public SubPerson1() {
    }

    public SubPerson1(String name, int age, T t, E e) {
        super(name, age, t);
        this.e = e;
    }// SubPerson1仍然是一个泛型类

    @Override
    public String toString() {
        return "SubPerson1{" + "name='" + getName() + '\'' + ", age=" + getAge() + ", t=" + getT() + ", e=" + e + '}';
    }
}

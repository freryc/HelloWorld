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
public class SubPerson extends Person<String> implements Comparable {// SubPerson不再是一个泛型类

    public SubPerson() {
    }

    public SubPerson(String name, int age, String des) {
        super(name, age, des);
    }

    @Override
    public String toString() {
        return "SubPerson{" + "name='" + getName() + '\'' + ", age=" + getAge() + ", t=" + getT() + '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof SubPerson) {
            SubPerson s = (SubPerson) o;
            return getT().compareTo(s.getT());
        }
        throw new RuntimeException("输入参数不合法");
    }
}

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer35;

import java.io.Serial;
import java.io.Serializable;

/**
 * Person类需要满足如下的要求，方可序列化：
 * 1.需要实现接口：Serializable
 * 2.需要提供唯一的serialVersionUID
 *
 * @author z00440867
 * @since 2021-03-03
 */
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 421234L;

    private String name;

    private double age;

    public Person(String name, double age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}

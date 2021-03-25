/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer24;

import java.util.Objects;

/**
 * description
 *
 * @author z00440867
 * @since 2021-03-05
 */
public class Person implements Comparable {
    private int age;

    private String name;

    private int id;

    private double salary;

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

    public Person() {
    }

    public Person(int age, String name, int id, double salary) {
        this.age = age;
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" + "age=" + age + ", name='" + name + '\'' + ", id=" + id + ", salary=" + salary + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;

        if (age != person.age) {
            return false;
        }
        if (id != person.id) {
            return false;
        }
        if (Double.compare(person.salary, salary) != 0) {
            return false;
        }
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + id;
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Person) {
            Person p = (Person) o;
            int i = getName().compareTo(p.getName());
            if (i != 0) {
                return i;
            } else {
                return Integer.compare(getAge(), p.getAge());
            }
        }
        throw new RuntimeException("输入数据类型不匹配");
    }
}

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer30;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用
 *
 * @author z00440867
 * @since 2021-02-24
 */
public class MethodRefTest {
    // 对象::实例方法
    // Consumer<T> void accept(T t)
    // PrintStream中的void println(T t)
    @Test
    public void test1() {
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("Hello World!");

        Consumer<String> con2 = System.out::println;
        con2.accept("Hello World!");
    }

    // Suplier中的T get()
    // Employee中的String getName()
    @Test
    public void test2() {
        Employee employee = new Employee(1, "Tom", 23, 5600);
        // lambda表达式
        Supplier<String> stringSupplier1 = () -> employee.getName();
        System.out.println(stringSupplier1.get());
        // 方法引用
        Supplier<String> stringSupplier2 = employee::getName;
        System.out.println(stringSupplier2.get());
    }

    // 类::静态方法
    // Comparator中的int compare(T t1, T t2);
    // Integer中的int compare(T t1, T t2);
    @Test
    public void test3() {
        Comparator<Integer> comparator1 = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(comparator1.compare(9, 10));

        Comparator<Integer> comparator2 = Integer::compare;
        System.out.println(comparator2.compare(10, 11));
    }

    // Function中的R apply(T t);
    // Math中的long round(Double d);
    @Test
    public void test4() {
        Function<Double, Long> function1 = d -> Math.round(d);
        System.out.println(function1.apply(4.5));

        Function<Double, Long> function2 = Math::round;
        System.out.println(function2.apply(4.4));
    }

    // 类::实例方法
    // Comparator中的int compare(T t1, T t2)
    // String中的int s1.compareTo(s2)
    @Test
    public void test5() {
        Comparator<String> comparator1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(comparator1.compare("abc", "abd"));

        Comparator<String> comparator2 = String::compareTo;// 参数一刚好作为方法的调用者
        System.out.println(comparator2.compare("abc", "abd"));
    }

    // Function中的R apply(T t)
    // Employee中的String getName()
    @Test
    public void test6() {
        Employee employee = new Employee(1, "zhou", 12, 100);
        Function<Employee, String> function1 = e -> e.getName();
        System.out.println(function1.apply(employee));

        Function<Employee, String> function2 = Employee::getName;
        System.out.println(function2.apply(employee));
    }
}

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer30;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 构造器引用
 *
 * @author z00440867
 * @since 2021-02-24
 */
public class ConstructorTest {
    // Supplier中的T get()
    @Test
    public void test1() {
        Supplier<Employee> supplier1 = () -> new Employee();
        System.out.println(supplier1.get());

        Supplier<Employee> supplier2 = Employee::new;
        System.out.println(supplier2.get());
    }

    // Function中的R apply(T t)
    @Test
    public void test2() {
        Function<Integer, Employee> employeeFunction1 = id -> new Employee(id);
        System.out.println(employeeFunction1.apply(10));

        Function<Integer, Employee> employeeFunction2 = Employee::new;
        System.out.println(employeeFunction2.apply(12));
    }

    // Function中的R apply(T t)
    @Test
    public void test3() {
        Function<Integer, String[]> function1 = length -> new String[length];
        System.out.println(Arrays.toString(function1.apply(5)));

        Function<Integer, String[]> function2 = String[]::new;// 这时候把String[]看做是一个具体的类
        System.out.println(Arrays.toString(function2.apply(10)));
    }
}

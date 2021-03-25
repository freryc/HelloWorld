/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer31;

import exer30.Employee;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional类的使用
 *
 * @author z00440867
 * @since 2021-02-25
 */
public class OptionalTest {
    @Test
    public void test1() {
        Employee employee = new Employee();
        method1(employee);
    }

    public void method1(Employee employee) {
        // 常规写法：使用if判空来保护
        if (employee != null) {
            System.out.println("employee not null");
        }

        // 推荐写法：使用Optional简化if判空
        Optional.ofNullable(employee).ifPresent(System.out::println);
    }
}

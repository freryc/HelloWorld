/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer30;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author z00440867
 * @since 2021-02-24
 */
public class EmployeeData {
    public static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "马云", 23, 1000));
        employees.add(new Employee(2, "刘强东", 33, 900));
        employees.add(new Employee(3, "马化腾", 35, 9000));
        employees.add(new Employee(4, "张一鸣", 13, 7000));
        employees.add(new Employee(5, "李彦宏", 37, 3000));
        employees.add(new Employee(6, "村上春树", 50, 3000));
        return employees;
    }
}

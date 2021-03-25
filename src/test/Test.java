/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package test;

import java.io.PrintStream;
import java.io.Serial;

/**
 * @ClassName test.Test
 * @Description TODO
 * @Author z00440867
 * @Date 2021/1/11 17:23
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        String s1 = "1.1.1.1";
        String replace = s1.replace(".", "[.]");
        System.out.println(replace);
    }

    /**
     * @param a
     * @param b
     */
    public static void myMethod1(int a, int b) {
        a = 100;
        b = 200;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        //        System.exit(0);
    }

    /**
     * @param a
     * @param b
     */
    public static void myMethod2(int a, int b) {
        PrintStream ps = new PrintStream(System.out) {
            @Override
            public void println(String x) {
                if ("a = 10".equals(x)) {
                    x = "a = 100";
                } else if ("b = 10".equals(x)) {
                    x = "b = 200";
                }
                super.println(x);
            }
        };
        System.setOut(ps);
    }
}

class Person {
    private int num = 1;
}

class Student extends exer32.Person {
    @Serial
    private static final long serialVersionUID = 4468646573243707667L;

    private int num;

    private double score;

    Test test = new Test();

    Student(int num, double score) {
        this.num = num;
        this.score = score;
    }

    public Student() {

    }
}

class StudentTest {
    public static void main(String[] args) {
        exer32.Person person = new Student();
        Student student = (Student) person;
    }

}

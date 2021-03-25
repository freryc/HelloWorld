/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package test;

import java.util.Scanner;

/**
 * description
 *
 * @author z00440867
 * @since 2021/1/14
 */
public class InputTest {
    private static int number = 100;

    private int age = 0;

    /**
     * main方法
     *
     * @param args args参数列表
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // get first name
        System.out.print("What is your name?");
        String name = in.nextLine();

        // get second input
        System.out.print("How old are you?");
        int age = in.nextInt();

        // display out on console
        System.out.println("Hello, " + name + ". Next year, you'll be " + (age + 1));
    }
    
}

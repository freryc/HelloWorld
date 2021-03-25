/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer16;

import org.junit.Test;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 异常
 *
 * @author z00440867
 * @since 2021-01-21
 */
public class ThrowableTest {
    @Test
    /**
     * NullPointerException
     */ public void test1() {
        try {
            String str = "abc";
            str = null;
            System.out.println(str.charAt(0));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    /**
     * ArrayIndexOutOfBoundsException
     */ public void test2() {
        try {
            int[] num = new int[3];
            System.out.println(num[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    /**
     * ClassCastException
     */ public void test3() {
        try {
            Object obj = new String("abc");
            Integer integer = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    /**
     * NumberFormatException
     */ public void test4() {
        try {
            String str = "abc";
            int n = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    /**
     * InputMismatchException
     */ public void test5() {
        try {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            System.out.println(n);

        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    /**
     * ArithmeticException
     */ public void test6() {
        try {
            System.out.println(9 / 0);

        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

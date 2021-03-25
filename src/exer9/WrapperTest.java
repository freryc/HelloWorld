/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer9;

import org.junit.Test;

/**
 * 包装类的基础知识
 * 1.Java有8种基础数据类型，对应的就有8中包装类
 * byte-Byte、short-Short、int-Integer、long-Long、float-Float、double-Double、boolean-Boolean、char-Character
 * 2.基本数据类型与包装类、String的转换
 *
 * @author z00440867
 * @since 2021-01-18
 */
public class WrapperTest {
    @Test
    public void test1() {
        // 基本数据类型---->包装类
        // jdk5以前
        Integer in1 = new Integer(10);
        System.out.println(in1.toString());

        Integer inStr = new Integer("123");
        System.out.println(inStr);

        Boolean b1 = new Boolean(true);
        System.out.println(b1);
        // jdk5以后---新增自动装箱特性
        Integer in3 = 10;
        System.out.println(in3);
        Boolean b2 = false;
        System.out.println(b2);
    }

    @Test
    public void test2() {
        Integer in4 = new Integer(12);
        // 包装类---->基本数据类型:调用包装类的xxxValue()函数
        // jdk5以前
        int in5 = in4.intValue();
        System.out.println(in5);

        // jdk5以后---新增自动拆箱特性
        int in6 = in4;
        System.out.println(in6);
    }

    @Test
    public void test3() {
        // 基本数据类型、包装类--->String之间的转换
        // 方式1：连接运算
        String str1 = 10 + "";
        System.out.println(str1);
        // 方式2：调用String重载的静态方法valueof(XXX xxx)方法
        Integer in1 = 11;
        String str2 = String.valueOf(in1);
        System.out.println(str2);

        String str3 = String.valueOf(12);
        System.out.println(str3);
    }

    @Test
    public void test4() {
        // String--->基本数据类型、包装类之间的转换
        // 调用包装类的xxxPrase()方法；
        String str1 = "123";
        int a = Integer.parseInt(str1);
        System.out.println(a);

        String str2 = "11.5f";
        float b = Float.parseFloat(str2);
        System.out.println(b);

        String str3 = "17.53";
        double c = Double.parseDouble(str3);
        System.out.println(c);

        Person p1 = new Person();
        Person p2 = new Person();
        System.out.println(p1 == p2);

    }
}

class Person {

}

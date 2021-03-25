/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer20;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 常用类：字符串
 * String:字符串，使用一对""括起来表示
 * 1.String声明为final的，不可被继承
 * 2.String实现了Serializable接口：表示字符串是支持序列化的
 * 实现了Comparable接口：表示字符串是可以比较大小的
 * 3.String内部定义了final char[] value用于存储字符串数据
 * 4.String：代表不可变的字符序列。简称不可变性。
 * 体现：1.当对字符串对象重新赋值时，需要重新指定内存区域赋值，不能使用原有的value进行赋值；
 * 2.当对现有字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值；
 * 3.当调用String的replace()方法修改指定字符或字符串时，也需要重新指定内存区域赋值。
 * 5.通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串声明在字符串常量池中，
 * 6.字符串常量池中是不会存储相同内容的字符串的
 * <p>
 * String实例化方式：
 * 方式一：通过字面量定义的方式
 * 方式二：通过new+构造器的方式
 * <p>
 * 面试题：String s = new String("abc");方式创建对象，在内存中创建了几个对象
 * 两个：一个是对空间中new的String结构，另一个是char[]对应的字符串常量池中的数据："abc"
 *
 * @author z00440867
 * @since 2021-01-25
 */
public class StringTest<test1> {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        // s1、s2都声明在字符串常量池中，两个的地址一样
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println("****************");

        s1 = "bcd";
        // String不可变性：当对字符串对象重新赋值时，此时s1重新指定一块新的内存区域，并没有改变原有内存区域的值
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println("****************");

        // String不可变性：当对现有字符串进行连接操作时，此时s3重新指定一块新的内存区域，并没有改变原有内存区域的值
        String s3 = "abc";
        System.out.println(s3.hashCode());
        s3 += "bcd";
        System.out.println(s3.hashCode());
        System.out.println("****************");

        // String不可变性：当调用String的replace()方法修改指定字符或字符串时，此时replace重新指定一块新的内存区域，并没有改变原有内存区域的值
        String s4 = "abc";
        String replace = s4.replace("a", "b");
        System.out.println(s4.hashCode());
        System.out.println(replace.hashCode());
        System.out.println("****************");
    }

    /**
     * String不同拼接操作的对比：
     * 1.常量与常量的拼接结果在常量池，切常量池中不会存在相同内容的常量；
     * 2.只要其中有一个变量，结果就在堆中；
     * 3.如果拼接的结果调用intern()方法，返回值就在常量池中。
     */
    @Test
    public void test1() {
        String s1 = "Hello";
        String s2 = "World";
        String s3 = s1 + s2;
        String s4 = "HelloWorld";
        String s5 = "Hello" + "World";
        String s6 = s3.intern();
        String s7 = s1 + "World";
        String s8 = "Hello" + s2;

        System.out.println(s7 == s4);// false
        System.out.println(s8 == s4);// false
        System.out.println(s3 == s4);// false
        System.out.println(s5 == s4);// true
        System.out.println(s6 == s4);// true
    }

    /**
     * String与char[]之间的转换
     * String --> char[]:调用String的toCharArray()
     * char[] --> String:调用String的构造器
     */
    @Test
    public void test2() {
        String str1 = "HelloWorld";
        // String --> char[]
        char[] charArray = str1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
        }

        // char[] --> String
        char[] a = new char[] {'l', 'o', 'v', 'e'};
        String s = new String(a);
        System.out.println(s);
    }

    /**
     * String与byte[]之间的转换
     * 编码：String --> byte[]:调用String的getBytes()
     * 解码：byte[] --> String:调用String的构造器
     * 解码时，要求与编码时使用的字符集一致
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        // String --> byte[]
        byte[] byteArray1 = str1.getBytes(StandardCharsets.UTF_8);
        byte[] byteArray2 = str1.getBytes("gbk");
        System.out.println(Arrays.toString(byteArray1));
        System.out.println(Arrays.toString(byteArray2));

        String s1 = new String(byteArray1);
        System.out.println(s1);

        String s2 = new String(byteArray2);
        System.out.println(s2);

        String s3 = new String(byteArray2, "gbk");
        System.out.println(s3);
    }
}

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer20;

/**
 * String、StringBuffer、StringBuilder
 * String:不可变的字符序列，底层使用char[]存储
 * StringBuffer：可变的字符序列，线程安全的，效率低；底层使用char[]存储；
 * StringBuilder：可变的字符序列，线程不安全，效率高；底层使用char[]存储
 * <p>
 * 源码分析：
 * String s1 = new String();//char[] value = new char[0];
 * StringBuffer sb1 = new StringBuffer();// char[] value = new char[16];底层创建了一个长度是16的字符数组
 * StringBuffer sb2 = new StringBuffer("abc");// char[] value = new char["abc".length() + 16]
 * <p>
 * 问题一：System.out.println(sb2.length());//实际长度，3
 * 问题二：扩容问题：如果要添加的数据底层数组装不下，那就需要扩容底层的数组。
 * 默认情况下，扩容为原来容量的2倍+2，同时将原有数组中的元素复制到新的数组中。
 * <p>
 * 实际开发中建议使用构造器StringBuffer(int capacity)或StringBuilder(int capacity)避免扩容复制，降低了效率。
 *
 * @author z00440867
 * @since 2021-01-26
 */
public class StringBufferBuilderTest {
    public static void main(String[] args) {
        System.out.println();
    }
}

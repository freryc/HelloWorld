/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer23;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Collection集和常用框架
 *
 * @author z00440867
 * @since 2021-02-03
 */
public class CollectionTest {
    @Test
    public void test1() {
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add("abc");
        collection.add(new String("def"));
        collection.add(false);

        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            if ("abc".equals(iterator.next())) {
                iterator.remove();
            }
        }

        Iterator iterator1 = collection.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        System.out.println(collection);

        Collection collection1 = Arrays.asList(123, 456, 789);
        System.out.println(collection.retainAll(collection1));
        System.out.println(collection);
        System.out.println(collection1);
    }

    @Test
    public void test2() {
        String[] str = new String[] {"AA", "BB", "CC"};
        for (int i = 0; i < str.length; i++) {
            str[i] = "DD";
        }

        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);// DD, DD, DD
        }
    }

    @Test
    public void test3() {
        String[] str = new String[] {"AA", "BB", "CC"};
        for (String s : str) {
            s = "DD";// 只是局部变量s改变了，数组并未改变
        }

        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);// AA, BB, CC
        }
    }
}

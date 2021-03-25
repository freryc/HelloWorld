/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer25;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * description
 *
 * @author z00440867
 * @since 2021-02-07
 */
public class GenericCollectionTest {
    @Test
    public void test1() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(123);
        arrayList.add(15);
        arrayList.add(78);

        for (Integer i : arrayList) {
            System.out.println(i);
        }

        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Tom", 12);
        hashMap.put("Bob", 2);
        hashMap.put("Jerry", 10);

        Set<Map.Entry<String, Integer>> entrySet = hashMap.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "------" + value);
        }
    }

    @Test
    public void test3() {
        Person<String> person = new Person<>("TOM", 10, "Hello");
        System.out.println(person.getT());
        person.setT("Hi");
        System.out.println(person.getT());
    }

    @Test
    public void test4() {
        SubPerson subPerson = new SubPerson("fre", 13, "世界");
        System.out.println(subPerson);

        SubPerson1<Integer, String> subPerson1 = new SubPerson1<>("jim", 2, 23, "boy");
        System.out.println(subPerson1);
    }

    @Test
    public void test7() {
        List<Object> list1 = null;
        List<String> list2 = null;
        List<?> list3 = null;
        // List<?>可以作为List<Object>和List<String>的公共父类
        list3 = list1;

        list2 = new ArrayList<>();
        list2.add("hello");
        list2.add("world");
        print(list2);

        // 对于List<?>就不能向其内部添加数据，除了添加null之外
        list3 = list2;
        // list3.add("abc"); 编译报错
        list3.add(null);

        // 对于List<?>可以读取其中数据
        Object o = list3.get(0);
        System.out.println(o);
    }

    public void print(List<?> list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    public void test5() {
        List<? extends Person<String>> list1 = null;// <= Person
        List<? super Person<String>> list2 = null;// >= Person

        ArrayList<SubPerson> list3 = new ArrayList<>();
        ArrayList<Person<String>> list4 = new ArrayList<>();
        ArrayList<Object> list5 = new ArrayList<>();

        // list2 = list3;
        list2 = list4;
        list2 = list5;
    }

    @Test
    public void test6() {
        Integer[] arr1 = new Integer[] {1, 2, 3, 4, 5};
        System.out.println(Person.copyFromArrayToList(arr1));
    }

    @Test
    public void test8() {
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<SubPerson> list3 = null;
        List<Person> list4 = null;
        List<Object> list5 = null;

        // 只允许泛型为Person及Person子类的引用调用
        list1 = list3;
        list1 = list4;
        // list1 = list5;编译报错

        // 只允许泛型为Person及Person父类的引用调用
        // list2 = list3;编译报错
        list2 = list4;
        list2 = list5;
    }
}

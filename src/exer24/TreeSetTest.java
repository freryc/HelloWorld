/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer24;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet
 *
 * @author z00440867
 * @since 2021-02-04
 */
public class TreeSetTest {
    @Test
    public void test1() {
        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(123);
        set.add(23);
        set.add(1);

        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        TreeSet<Person> people = new TreeSet<>();
        people.add(new Person(10, "Tom", 1, 1000));
        people.add(new Person(11, "Jerry", 2, 1500));
        people.add(new Person(12, "Bob", 3, 2000));
        people.add(new Person(13, "Bob", 4, 2100));

        Iterator<Person> iterator = people.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3() {
        Comparator<Person> comparator = new Comparator<>() {
            @Override
            public int compare(Person p1, Person p2) {
                return Integer.compare(p1.getAge(), p2.getAge());
            }
        };

        TreeSet<Person> people = new TreeSet<>(comparator);
        people.add(new Person(10, "Tom", 1, 1000));
        people.add(new Person(11, "Jerry", 2, 1500));
        people.add(new Person(12, "Bob", 3, 2000));
        people.add(new Person(13, "Bob", 4, 2100));

        Iterator<Person> iterator = people.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

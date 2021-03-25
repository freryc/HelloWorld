/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer28;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * description
 *
 * @author z00440867
 * @since 2021-02-23
 */
public class LambdaTest {
    // 无参无返回值
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("未使用lambda表达式前");
            }
        };
        r1.run();

        Runnable r2 = () -> System.out.println("使用lambda表达式后");
        r2.run();
    }

    // 一个参数无返回值
    @Test
    public void test2() {
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con1.accept("lambda表达式接收一个参数，无返回值");

        Consumer<String> con2 = (String s) -> System.out.println(s);
        con2.accept("使用lambda表达式后");
    }

    // 数据类型可省略
    @Test
    public void test3() {
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con1.accept("lambda表达式接收一个参数，无返回值");

        Consumer<String> con2 = (s) -> System.out.println(s);
        con2.accept("使用lambda表达式后");
    }

    // 参数的小括号可以省略
    @Test
    public void test4() {
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con1.accept("lambda表达式接收一个参数，无返回值");

        Consumer<String> con2 = s -> System.out.println(s);
        con2.accept("使用lambda表达式后");
    }

    // Lambda需要两个或以上的参数时，多条执行语句，并且可以有返回值
    @Test
    public void test5() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(com1.compare(12, 9));

        Comparator<Integer> com2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(12, 23));
    }

    // 当Lambda体只有一条语句时，return与大括号若有，则都可以省略
    @Test
    public void test6() {
        Comparator<Integer> com1 = (o1, o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(com1.compare(12, 23));

        Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(12, 9));
    }
}

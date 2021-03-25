/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer29;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java四大核心函数式接口的应用举例
 *
 * @author z00440867
 * @since 2021-02-24
 */
public class FunctionalInterfaceTest {
    // public interface Consumer<T> void accept(T t);
    @Test
    public void test1() {
        Consumer<Double> consumer = s -> System.out.println(s);
        happyTime(12.3, consumer);
    }

    public void happyTime(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    // public interface Predicate<T> boolean test(T t);
    @Test
    public void test2() {
        List<String> strings = Arrays.asList("北京", "东京", "南京", "西京", "天津");
        List<String> stringList = filterString(strings, s -> s.contains("京"));
        System.out.println(stringList);
    }

    // 根据给定的规则，过滤集和中的字符串。此规则由Predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> predicate) {
        ArrayList<String> strings = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)) {
                strings.add(s);
            }
        }
        return strings;
    }

    // public interface Supplier<T> T get();
    @Test
    public void test3() {
        String s = method1(() -> "Hello World!");
        System.out.println(s);
    }

    public String method1(Supplier<String> stringSupplier) {
        return stringSupplier.get();
    }

    // public interface Function<T, R> R apply(T t);
    @Test
    public void test4() {
        String s1 = method2("hello world!", s -> s.toUpperCase());
        System.out.println(s1);
    }

    public String method2(String s, Function<String, String> function) {
        return function.apply(s);
    }
}

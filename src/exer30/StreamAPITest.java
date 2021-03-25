/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer30;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream API
 *
 * @author z00440867
 * @since 2021-02-24
 */
public class StreamAPITest {
    //Stream的创建方式一：通过集和
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        // default Stream<E> stream()：返回一个顺序流
        Stream<Employee> stream = employees.stream();
        // default Stream<E> parallelStream()：返回一个并行流
        Stream<Employee> employeeStream = employees.parallelStream();
    }

    //Stream的创建方式二：通过数组
    @Test
    public void test2() {
        int[] arr1 = new int[] {1, 2, 3, 4, 5};
        // 调用Arrays类的public static <T> Stream<T> stream(T[] array)
        IntStream stream = Arrays.stream(arr1);

        Employee employee1 = new Employee(1);
        Employee employee2 = new Employee(3);
        Employee[] employees = new Employee[] {employee1, employee2};
        Stream<Employee> employeeStream = Arrays.stream(employees);
    }

    //Stream的创建方式三：通过Stream的of()
    @Test
    public void test3() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
    }

    //Stream的创建方式四：创建无限流
    @Test
    public void test4() {
        // public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        Stream.iterate(0, i -> i + 2).limit(10).forEach(System.out::println);
        // public static<T> Stream<T> generate(Supplier<? extends T> s)
        Stream.generate(Math::random).limit(5).forEach(System.out::println);
    }

    // Stream的中间操作：筛选与切片
    @Test
    public void test5() {
        List<Employee> employees = EmployeeData.getEmployees();
        // filter(Predicate p)——接收lambda，从流中删除某些元素
        employees.stream().filter(employee -> employee.getSalary() > 1000).forEach(System.out::println);
        System.out.println();
        // limit(n)——截断流，使其元素不超过给定数量
        employees.stream().limit(3).forEach(System.out::println);
        System.out.println();
        // skip(n)——跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n)互补
        employees.stream().skip(3).forEach(System.out::println);
        System.out.println();
        // distinct()——筛选，通过流所生成元素的hashCode()和equals()去除重复元素
        employees.add(new Employee(6));
        employees.add(new Employee(6));
        employees.add(new Employee(6));
        employees.add(new Employee(6));
        System.out.println(employees);
        System.out.println();
        employees.stream().distinct().forEach(System.out::println);
        System.out.println();
    }

    // Stream的中间操作：映射
    // <R> Stream<R> map(Function<? super T, ? extends R> mapper);
    @Test
    public void test6() {
        List<String> strings = Arrays.asList("aa", "bb", "cc");
        strings.stream().map(String::toUpperCase).forEach(System.out::println);

        // 练习：获取员工名字长度大于3的员工姓名
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().map(Employee::getName).filter(s -> s.length() > 3).forEach(System.out::println);
    }

    // flatMap(Function mapper)——接收一个函数作为参数，将流中的每个值都换成另一个流，然后所有流连接成一个流
    // map()和flatMap()类似于ArrayList中的add()和addAll()
    @Test
    public void test7() {
        List<String> strings = Arrays.asList("aa", "bb", "cc");
        strings.stream().flatMap(StreamAPITest::stringToStream).forEach(System.out::println);
    }

    public static Stream<Character> stringToStream(String str) {
        ArrayList<Character> characters = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            characters.add(c);
        }
        return characters.stream();
    }

    // Stream的中间操作：排序
    @Test
    public void test8() {
        // sorted() 自然排序
        List<Integer> integers = Arrays.asList(3, 1, 5, 2, 10);
        integers.stream().sorted().forEach(System.out::println);

        // sorted(Comparator com)
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream()
            .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
            .forEach(System.out::println);
    }

    // Stream的终止操作：匹配与查找
    @Test
    public void test9() {
        List<Employee> employees = EmployeeData.getEmployees();
        // allMatch()
        System.out.println(employees.stream().allMatch(e -> e.getSalary() > 1000));
        // anyMatch()
        System.out.println(employees.stream().anyMatch(e -> e.getSalary() < 1000));
        // noneMatch()
        System.out.println(employees.stream().noneMatch(e -> e.getSalary() < 1000));
        // findFirst()
        System.out.println(employees.stream().findFirst());
        // findAny()
        System.out.println(employees.stream().findAny());
        // count()
        System.out.println(employees.stream().count());
        // max(Comparator c)
        System.out.println(employees.stream().max((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())));
        // min(Comparator c)
        System.out.println(employees.stream().min((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())));
        // forEach(Consumer c)
        employees.stream().forEach(System.out::println);
    }

    // Stream的终止操作：规约
    @Test
    public void test10() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(integers.stream().reduce(0, Integer::sum));

        System.out.println(integers.stream().reduce(Integer::sum));
    }

    // Stream的终止操作：收集
    @Test
    public void test11() {
        List<Employee> employees = EmployeeData.getEmployees();
        System.out.println(employees.stream().filter(e -> e.getSalary() > 3000).collect(Collectors.toList()));
    }
}

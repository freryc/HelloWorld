/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer22;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * java比较器
 * 两种方式：
 * 一：自然排序，实现public interface Comparable<T>接口中的public int compareTo(T o)方法；
 * 二：定制排序，实现public interface Comparator<T>接口中的int compare(T o1, T o2)方法；
 * <p>
 * 使用场景：
 * 自然排序：由具体的类去实现接口的抽象方法，对象调用比较方法，属于永久性的；
 * 定制排序：当我们无法修改实体类代码时，直接在调用时创建，属于临时性的
 *
 * @author z00440867
 * @since 2021-01-28
 */
public class CompareTest {
    /**
     * 自定义类如何使用自然排序实现比较器
     */
    @Test
    public void test1() {
        Goods[] goods = new Goods[5];
        goods[0] = new Goods("xiaomi", 10);
        goods[1] = new Goods("zhongxing", 5);
        goods[2] = new Goods("huawei", 20);
        goods[3] = new Goods("lenovo", 8);
        goods[4] = new Goods("apple", 100);

        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }

    /**
     * 自定义类如何使用定制排序实现比较器
     */
    @Test
    public void test2() {
        Goods[] goods = new Goods[5];
        goods[0] = new Goods("xiaomi", 10);
        goods[1] = new Goods("zhongxing", 5);
        goods[2] = new Goods("huawei", 20);
        goods[3] = new Goods("lenovo", 8);
        goods[4] = new Goods("apple", 100);

        Arrays.sort(goods, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods) {
                    Goods good1 = (Goods) o1;
                    Goods good2 = (Goods) o2;
                    return Double.compare(good1.getPrice(), good2.getPrice());
                }
                throw new RuntimeException("输入数据类型不匹配");
            }
        });
        System.out.println(Arrays.toString(goods));
    }
}

class Goods implements Comparable {
    private String name;

    private double price;

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Goods() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            return Double.compare(price, goods.price);
        }
        throw new RuntimeException("输入数据类型不匹配");
    }

    @Override
    public String toString() {
        return "Goods{" + "name='" + name + '\'' + ", price=" + price + '}';
    }
}
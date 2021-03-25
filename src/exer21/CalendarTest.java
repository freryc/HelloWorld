/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer21;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Calendar类的应用
 * 1.public abstract class Calendar：是一个抽象类，通常使用子类GregorianCalendar来实例化；
 * 2.通过静态方法getInstance()来实例化抽象类Calendar；
 * 3.Calendar对象的常用方法：
 *
 * @author z00440867
 * @since 2021-01-26
 */
public class CalendarTest {
    @Test
    public void test1() {
        // 获取的是当前日期的Calendar对象，Calendar类为可变类
        Calendar instance = Calendar.getInstance();
        // get(int field)获取当前Calendar对象在一年、一个月、一周里的第几天
        int i = instance.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);

        // void set(int field, int offset)，以Calendar.DAY_OF_MONTH为例，Calendar对象设置为当月的第offset天
        instance.set(Calendar.DAY_OF_MONTH, 28);
        int j = instance.get(Calendar.DAY_OF_MONTH);
        System.out.println(j);

        // void add()
        instance.add(Calendar.DAY_OF_MONTH, -2);
        int k = instance.get(Calendar.DAY_OF_MONTH);
        System.out.println(k);

        // Date getTime() Calendar---> Date
        Date time = instance.getTime();
        System.out.println(time);

        // Date ---> Calendar void setTime(Date date)
        instance.setTime(time);
        System.out.println(instance.get(Calendar.DAY_OF_MONTH));

    }
}

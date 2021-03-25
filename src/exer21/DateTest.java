/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer21;

import org.junit.Test;

import java.util.Date;

/**
 * java中两个常用Date类的使用
 * java.util.Date类
 * |-----java.sql.Date类
 * <p>
 * 1.两个构造器的使用
 * 空参构造器Date():创建一个对应当前时间的Date对象
 * Date(long date)：创建指定毫秒数的Date对象（距离January 1, 1970, 00:00:00 GMT）
 * 2.两个方法的使用
 * toString():显示当前的年、月、日、时、分、秒
 * getTime():获取当前Date对象对应的毫秒数。（时间戳）
 *
 * @author z00440867
 * @since 2021-01-26
 */
public class DateTest {
    @Test
    public void test1() {
        // 空参构造器：创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());//Tue Jan 26 11:32:51 CST 2021
        // 获取当前Date对象对应的毫秒数。（时间戳）
        long time = date1.getTime();
        System.out.println(time);// 1611632233863

        // 带参构造器:创建指定毫秒数的Date对象
        Date date2 = new Date(time);
        System.out.println(date2);

        // 创建java.sql.Date对象，推荐的只有带参构造器，其他的都过时注解了，只到年月日
        java.sql.Date date3 = new java.sql.Date(time);
        System.out.println(date3);

        // java.util.Date转化为java.sql.Date，使用毫秒数构造器
        Date date4 = new Date();
        java.sql.Date date5 = new java.sql.Date(date4.getTime());
        System.out.println(date5);

        // System类静态方法currentTimeMillis()计算出距离1970.1.1 0分0秒的时间戳（毫秒数）
        long l = System.currentTimeMillis();// 距离1970.1.1 0分0秒的时间戳（毫秒数）
        System.out.println(l);
    }
}

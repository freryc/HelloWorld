/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer21;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * description
 *
 * @author z00440867
 * @since 2021-01-27
 */
public class JDK8LocalDateTimeTest {
    @Test
    public void test1() {
        // now() 获取当前时间的对象
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localTime);
        System.out.println(localDate);
        System.out.println(localDateTime);

        // getXxx()
        Month month = localDateTime.getMonth();
        System.out.println(month);

        // of() 设置为指定时间的对象
        LocalDateTime localDateTime1 = LocalDateTime.of(2050, 12, 1, 10, 28, 23);
        System.out.println(localDateTime1);

        // with() 设置为指定一个月的第几天、一年的第几天等
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(13);
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = localDateTime.withDayOfYear(333);
        System.out.println(localDateTime3);

        // minusXxx/plusXxx 在当前日期时间上加减操作
        LocalDateTime localDateTime4 = localDateTime.plusHours(1);
        System.out.println(localDateTime4);
    }
}

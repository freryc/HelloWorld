/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer21;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat的使用：
 * 1.对日期Date类的格式化 日期--->字符串
 * 2.解析 字符串--->日期
 *
 * @author z00440867
 * @since 2021-01-26
 */
public class SimpleDateFormateTest {
    @Test
    public void test1() throws ParseException {
        // 使用空参构造器时，在字符串解析为日期时，不知道字符串填写的格式
        // 格式化 日期--->字符串
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Date date = new Date();
        System.out.println(date);
        String s = simpleDateFormat.format(date);
        System.out.println(s);

        // 解析 字符串--->日期
        Date date1 = simpleDateFormat.parse("2021/1/26 下午5:04");
        System.out.println(date1);

        System.out.println("******************");
        // 调用带参数的构造器实际是我们希望date呈现的形式，也能帮助我在解析字符串为date时，写入正确的格式，否则会抛异常
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        System.out.println(simpleDateFormat1.format(date));

        Date date2 = simpleDateFormat1.parse("2021-01-26 05:10:04 下午");
        System.out.println(date2);
    }
}

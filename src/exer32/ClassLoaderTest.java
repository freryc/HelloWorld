/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer32;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 通过Classloader加载配置文件
 *
 * @author z00440867
 * @since 2021-02-25
 */
public class ClassLoaderTest {
    @Test
    public void test1() throws IOException {
        Properties properties = new Properties();

        // 读取配置文件的方式一：通过FileInputStream，此时配置文件的默认位置为当前module下
        // FileInputStream fileInputStream = new FileInputStream("src\\jdbc1.properties");
        // properties.load(fileInputStream);

        // 读取配置文件的方式二：通过ClassLoader的getResourceAsStream，此时配置文件的默认位置为当前module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream stream = classLoader.getResourceAsStream("jdbc.properties");
        properties.load(stream);

        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println(("user = " + username + " password = " + password));

    }
}

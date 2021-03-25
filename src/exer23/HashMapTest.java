/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer23;

import org.junit.Test;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * description
 *
 * @author z00440867
 * @since 2021-03-08
 */
public class HashMapTest {
    @Test
    public void test1() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", "Bob");
        hashMap.put("age", 10);
        hashMap.put("salary", 1000);

        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + "--------->" + value);
        }
    }

    @Test
    public void test2() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\z00440867\\IdeaProjects\\HelloWorld\\src\\jdbc.properties"));
        String username = properties.getProperty("username");
        System.out.println(username);

        properties.setProperty("username", "Bob");
        String username1 = properties.getProperty("username");
        System.out.println(username1);
    }
}

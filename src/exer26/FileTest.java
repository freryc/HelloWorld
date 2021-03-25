/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer26;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * description
 *
 * @author z00440867
 * @since 2021-02-08
 */
public class FileTest {
    /**
     * read()：返回读入的一个字符，如果达到文件末尾，返回-1
     * 异常的处理：为了保证资源一定可以执行关闭操作，需要使用try-catch-finally处理
     */
    @Test
    public void test1() {
        FileReader fileReader = null;
        try {
            // 1.实例化文件对象
            File file = new File("hello.txt");
            // 2.实例化流对象
            fileReader = new FileReader(file);

            int data;
            // 3.读入操作
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭流
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 1.输出操作对应的文件可以不存在
     * 如果不存在，在输出的过程中，会自动创建此文件；
     * 如果存在：
     * 如果write(xxx, true)，追加填写
     * 如果write(xxx, false)，覆盖填写
     */
    @Test
    public void test2() throws IOException {
        // 1.实例化文件对象
        File file = new File("hello.txt");
        // 2.实例化流对象
        FileWriter fileWriter = new FileWriter(file, true);
        // 3.写入操作
        fileWriter.write("Hello World!");
        // 4.关闭流
        fileWriter.close();
    }
}

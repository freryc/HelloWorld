/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer26;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 缓冲流的使用
 * 1.分类：BufferedInputStream/BufferedOutputStream、BufferedFileReader/BufferedFileWriter
 * 2.作用：提高流的读取、写入速度
 *
 * @author z00440867
 * @since 2021-03-01
 */
public class BufferedStreamTest {
    /**
     * BufferedInputStream/BufferedOutputStream
     */
    @Test
    public void test1() {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File file1 = new File("abc.jpg");
            File file2 = new File("abc2.jpg");

            FileInputStream fileInputStream = new FileInputStream(file1);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);

            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bufferedInputStream != null;
                // 关闭外层流时，内层流也会自动的进行关闭
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert bufferedOutputStream != null;
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * BufferedReader/BufferedWriter
     */
    @Test
    public void test2() {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("hello.txt")));
            bufferedWriter = new BufferedWriter(new FileWriter(new File("hi.txt")));

            char[] buffer = new char[5];
            int len;

            while ((len = bufferedReader.read(buffer)) != -1) {
                bufferedWriter.write(buffer, 0, len);
            }

            // 另外一种写法
            // String sBuffer;
            // while ((sBuffer = bufferedReader.readLine()) != null) {
            //     bufferedWriter.write(sBuffer);
            //     bufferedWriter.newLine();// 换行操作
            // }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bufferedReader != null;
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert bufferedWriter != null;
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

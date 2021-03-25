/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer35;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * 转换流
 * 1.转换流：属于字符流
 * InputStreamReader：将一个字节的输入流转换为字符的输入流
 * OutputSteamWriter：将一个字符的输出流转换为字节的输出流
 * <p>
 * 2.作用：提供字节流和字符流之间的转换
 * <p>
 * 3.解码：字节、字节数组 --->字符数组、字符串
 * 编码：字符数组、字符串 ---> 字节、字节数组
 *
 * @author z00440867
 * @since 2021-03-03
 */
public class TransStreamTest {
    @Test
    public void test1() {
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        try {
            inputStreamReader = new InputStreamReader(
                new FileInputStream(new File("C:\\Users\\z00440867\\IdeaProjects\\HelloWorld\\src\\exer35\\hello.txt")),
                StandardCharsets.UTF_8);
            outputStreamWriter = new OutputStreamWriter(
                new FileOutputStream(new File("C:\\Users\\z00440867\\IdeaProjects\\HelloWorld\\src\\exer35\\hi.txt")),
                "gbk");

            int len;
            char[] buffer = new char[1024];
            while ((len = inputStreamReader.read(buffer)) != -1) {
                outputStreamWriter.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

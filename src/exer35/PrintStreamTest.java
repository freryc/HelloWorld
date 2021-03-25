/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer35;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * 标准输入输出流
 * 练习：
 * 从键盘输入字符串，要求将读取到的整行字符串转成大写输出，然后继续进行输入操作，直至当输入“e”或“exit”时，退出程序
 * 方式一：使用Scanner类
 * 方式二：使用System.in
 *
 * @author z00440867
 * @since 2021-03-03
 */
public class PrintStreamTest {
    public static void main(String[] args) {
        // System.in的类型是InputStream（字节流），我们通过转换流将字节流转换为字符流进行处理
        BufferedReader bufferedReader = null;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                System.out.println("请输入字符：");
                String s = bufferedReader.readLine();
                if (("e".equalsIgnoreCase(s)) || ("exit".equalsIgnoreCase(s))) {
                    System.out.println("程序结束");
                    break;
                }
                System.out.println(s.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test1() {
        PrintStream printStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("char.txt");
            printStream = new PrintStream(fileOutputStream, true);
            System.setOut(printStream);// 重定向，不再向控制台输出，而是向文件输出

            for (int i = 0; i <= 255; i++) {
                System.out.print((char) i);
                if ((i % 50 == 0)) {
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (printStream != null) {
                printStream.close();
            }
        }
    }

    /**
     * 将基本类型的数据持久化到文件中
     *
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("dataStream.txt"));
        dataOutputStream.writeUTF("hello");
        dataOutputStream.flush();
        dataOutputStream.writeInt(12);
        dataOutputStream.flush();
        dataOutputStream.writeBoolean(true);
        dataOutputStream.flush();

        dataOutputStream.close();
    }

    /**
     * 将文件中存储的基本数据类型变量和字符串读取到内存中，保存在变量中
     * 注意：读取不同类型的数据的顺序要与当初写入文件时保存的数据顺序一致
     *
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("dataStream.txt"));
        String name = dataInputStream.readUTF();
        int age = dataInputStream.readInt();
        boolean isMale = dataInputStream.readBoolean();

        System.out.println("name:" + name + " age:" + age + " isMale" + isMale);

        dataInputStream.close();
    }
}

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer27;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP网络编程
 *
 * @author z00440867
 * @since 2021-03-04
 */
public class TCPTest {
    /**
     * 客户端
     */
    @Test
    public void test1() {
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            // 1. 创建Socket
            socket = new Socket(InetAddress.getLocalHost(), 8801);
            // 2.获取输出流
            outputStream = socket.getOutputStream();
            // 3.写出数据
            fileInputStream = new FileInputStream(
                new File("C:\\Users\\z00440867\\IdeaProjects\\HelloWorld\\src\\exer27\\abc.jpg"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            socket.shutdownOutput();// 提示服务端图片传输已完成

            inputStream = socket.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] serverMessage = new byte[1024];
            int messageLen;
            while ((messageLen = inputStream.read(serverMessage)) != -1) {
                byteArrayOutputStream.write(serverMessage, 0, messageLen);
            }
            System.out.println(byteArrayOutputStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭资源
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 服务端
     */
    @Test
    public void test2() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        OutputStream outputStream = null;
        try {
            // 1.创建serverSocket
            serverSocket = new ServerSocket(8801);
            // 2.调用accept()接收客户端的socket
            socket = serverSocket.accept();
            // 3.获取输入流，读取输入数据
            inputStream = socket.getInputStream();
            fileOutputStream = new FileOutputStream(
                new File("C:\\Users\\z00440867\\IdeaProjects\\HelloWorld\\src\\exer27\\abc2.jpg"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }
            outputStream = socket.getOutputStream();
            outputStream.write("文件传输已完成".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5.关闭资源
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

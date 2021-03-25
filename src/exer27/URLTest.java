/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer27;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL编程
 *
 * @author z00440867
 * @since 2021-03-04
 */
public class URLTest {
    @Test
    public void test1() throws MalformedURLException {
        URL url = new URL("http://192.168.1.100:8080/helloworld/index.jsp?username=tom&password=123");
        // public String getProtocol() 获取该URL的协议名
        System.out.println(url.getProtocol());
        // public String getHost() 获取主机名
        System.out.println(url.getHost());
        // public int getPort()获取端口号
        System.out.println(url.getPort());
        // public String getPath()获取文件路径
        System.out.println(url.getPath());
        // public String getFile()获取文件名
        System.out.println(url.getFile());
        // public String getQuery()获取查询名
        System.out.println(url.getQuery());
    }

    @Test
    public void test2() {
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            // 链接URL对应的服务器
            URL url = new URL("http://localhost:8080/helloworld/abc.jpg");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            // 从URL对应资源地址获取输入流
            inputStream = urlConnection.getInputStream();
            fileOutputStream = new FileOutputStream(
                new File("C:\\Users\\z00440867\\IdeaProjects\\HelloWorld\\src\\exer27\\abc2.jpg"));
            byte[] buffer = new byte[1024];
            int len;
            // 从输入流写入到本地文件中
            while ((len = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }
}

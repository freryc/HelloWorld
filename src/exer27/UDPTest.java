/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer27;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP网络编程
 *
 * @author z00440867
 * @since 2021-03-04
 */
public class UDPTest {
    /**
     * 发送端
     */
    @Test
    public void sender() {
        DatagramSocket datagramSocket = null;
        try {
            // 1.创建DatagramSocket
            datagramSocket = new DatagramSocket();
            byte[] buffer = "UDP网络编程".getBytes();
            // 2.封装DatagramPacket
            DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length, InetAddress.getLocalHost(),
                8801);
            // 3.发送数据
            datagramSocket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) {
                // 4.关闭资源
                datagramSocket.close();
            }
        }
    }

    /**
     * 接收端
     */
    @Test
    public void receiver() {
        DatagramSocket datagramSocket = null;
        try {
            // 1.创建DatagramSocket
            datagramSocket = new DatagramSocket(8801);
            byte[] buffer = new byte[100];
            // 2.创建用于接收数据的datagramPacket
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
            // 3.接收数据
            datagramSocket.receive(datagramPacket);
            String s = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭资源
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }
    }
}

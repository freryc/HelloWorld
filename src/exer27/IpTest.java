/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package exer27;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress
 *
 * @author z00440867
 * @since 2021-02-18
 */
public class IpTest {
    @Test
    public void test1() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost);
            System.out.println(localHost.getHostName());
            System.out.println(localHost.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}

/*
 * Copyright (c) 2018 by Alibaba.inc All rights reserved
 */
package com.fitt.gbt.qbank.socket;

import java.io.IOException;
import java.net.InetAddress;

/**
 * @author : <a href="mailto:congchun.zcc@alibaba-inc.com">congchun.zcc</a>
 * @version : 1.0.0
 * @description : java.net socket
 * @since : 2018/11/30
 */
public class SocketTest {
    public static void main(String[] args) {
        testInetAddress();
    }

    public static void testInetAddress() {
        try {
            InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress.isReachable(20000));
            System.out.println(inetAddress.getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

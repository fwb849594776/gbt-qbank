/*
 * Copyright (c) 2018 by Alibaba.inc All rights reserved
 */
package com.fitt.gbt.qbank.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : <a href="mailto:congchun.zcc@alibaba-inc.com">congchun.zcc</a>
 * @version : 1.0.0
 * @description : TODO
 * @since : 2018/11/30
 */
public class SocketTcpServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        int port = 10000;
        try {
            serverSocket = new ServerSocket(port);

            System.out.println("-----------------Socket Server is ready----------------");
            while (true) {
                socket = serverSocket.accept();

                new LogicThread(socket);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                inputStream.close();
                socket.close();
                serverSocket.close();
            } catch (IOException e) {

            }
        }
    }
}

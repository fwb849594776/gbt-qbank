/*
 * Copyright (c) 2018 by Fitt.inc All rights reserved
 */
package com.fitt.gbt.qbank.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author : <a href="mailto:congchun.zcc@Fitt.inc.com">congchun.zcc</a>
 * @version : 1.0.0
 * @description : TODO
 * @since : 2018/11/30
 */
public class SocketTcpClient {
    public static void main(String[] args) {
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String serverIp = "127.0.0.1";
        int port = 10000;
        String data = "Hello, Socket";
        try {
            socket = new Socket(serverIp, port);

            outputStream = socket.getOutputStream();
            outputStream.write(data.getBytes());

            inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int read = inputStream.read(buffer);

            System.out.println(new String(buffer, 0, read));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
                socket.close();
            } catch (Exception ex) {}
        }
    }
}

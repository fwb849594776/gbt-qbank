/*
 * Copyright (c) 2018 by Alibaba.inc All rights reserved
 */
package com.fitt.gbt.qbank.socket;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author : <a href="mailto:congchun.zcc@alibaba-inc.com">congchun.zcc</a>
 * @version : 1.0.0
 * @description : TODO
 * @since : 2018/11/30
 */
public class LogicThread implements Runnable {
    private Socket socket = null;
    private InputStream inputStream = null;
    private OutputStream outputStream = null;

    public LogicThread(Socket socket) {
        this.socket = socket;
        this.run();
    }
    @Override
    public void run() {
        byte[] buffer = new byte[1024];
        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            while(true) {
                int length = inputStream.read(buffer);
                byte[] response = logic(buffer, 0, length);
                outputStream.write(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    private void close() {
        try {
            outputStream.close();
            inputStream.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private byte[] logic(byte[] buffer, int off, int len) {
        byte[] response = new byte[len];
        System.arraycopy(buffer, 0, response, 0, len);
        return response;
    }
}

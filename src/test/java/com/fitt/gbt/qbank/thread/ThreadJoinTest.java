/*
 * Copyright (c) 2018 by FITT.inc All rights reserved
 */
package com.fitt.gbt.qbank.thread;

/**
 * @author : <a href="mailto:congchun.zheng@gmail.com">sixawn</a>
 * @version : 1.0.0
 * @description : Join
 * @since : 2018-12-07 22:33
 */
public class ThreadJoinTest implements Runnable {
    private int cnt = 0;

    public ThreadJoinTest(int cnt) {
        this.cnt = cnt;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(new ThreadJoinTest(1));
        Thread B = new Thread(new ThreadJoinTest(2));
        Thread C = new Thread(new ThreadJoinTest(3));
        A.start();
        A.join();
        B.start();
        B.join();
        C.start();
    }

    @Override
    public void run() {
        System.out.println(cnt);
    }
}

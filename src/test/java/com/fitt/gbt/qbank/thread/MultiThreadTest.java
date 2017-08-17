package com.fitt.gbt.qbank.thread;

/**
 * <p>@Description: com.fitt.gbt.qbank.thread</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-16</p>
 * <p>@version: 1.0</p>
 */
public class MultiThreadTest {

	public static void main(String[] args) {
		MultiThread mt = new MultiThread();

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("ThreadA 线程执行");
				MultiThread.testA();
			}
		}, "ThreadA").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("ThreadB 线程执行");
				mt.testC();
			}
		}, "ThreadC").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("ThreadB 线程执行");
				mt.testB();
			}
		}, "ThreadB").start();
	}
}

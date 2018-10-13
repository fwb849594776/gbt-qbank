package com.fitt.gbt.qbank.thread;

import org.junit.Test;

/**
 * <p>@Description: 线程yield操作： yield不会永久放弃cpu</p>
 * <p>@Copyright: Copyright(C) 2017 by FITT</p>
 * <p>@Author: SixAwn</p>
 * <p>@Created: 2017-08-02</p>
 * <p>@version: 1.0</p>
 */
public class YieldTreadTest {
	private static boolean running = true;

	@Test
	public void testYield() {
		YieldThread yt = new YieldThread();
		yt.start();
		while (running) {
			System.out.println("主线程执行");
		}
	}

	class YieldThread extends Thread {
		public void run() {
			while (running) {
				System.out.println("被放弃线程CPU");
				Thread.currentThread().yield();
			}
		}
	}

	@Test
	public void testBuilder() {
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);

		String str2 = new StringBuilder("Strin").append("lo").toString();
		System.out.println(str2.intern() == str2);
	}
}

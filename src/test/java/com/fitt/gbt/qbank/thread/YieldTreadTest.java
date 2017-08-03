package com.fitt.gbt.qbank.thread;

import org.junit.Test;

/**
 * <p>@Description: 线程yield操作： yield不会永久放弃cpu</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
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
}

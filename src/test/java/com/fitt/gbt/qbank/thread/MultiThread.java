package com.fitt.gbt.qbank.thread;

import java.util.Date;

/**
 * <p>@Description: com.fitt.gbt.qbank.thread</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-16</p>
 * <p>@version: 1.0</p>
 */
public class MultiThread {
	public static synchronized void testA() {
		System.out.println(Thread.currentThread().getName() + " testA获得对象锁执行" + new Date());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " testA执行结束" + new Date());
	}

	public static synchronized void testB() {
		System.out.println(Thread.currentThread().getName() + " testB获得对象锁开始执行 " + new Date());
	}

	public void testC() {
		System.out.println(Thread.currentThread().getName() + " testC开始执行 " + new Date());
	}
}

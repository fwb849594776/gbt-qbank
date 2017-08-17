package com.fitt.gbt.qbank.thread;

/**
 * <p>@Description: com.fitt.gbt.qbank.thread</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-10</p>
 * <p>@version: 1.0</p>
 */
public class DeadLockTest {
	public static void main(String[] args) {
		System.out.println("begin....");
		ResourceA resourceA = new ResourceA();
		ResourceB resourceB = new ResourceB();
		ThreadA threadA = new ThreadA(resourceA, resourceB);
		ThreadB threadB = new ThreadB(resourceA, resourceB);

		Thread thread1 = new Thread(threadA);
		Thread thread2 = new Thread(threadB);
		thread1.start();
		thread2.start();

		System.out.println("end....");
	}
}

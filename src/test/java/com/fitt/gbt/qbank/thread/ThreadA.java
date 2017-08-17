package com.fitt.gbt.qbank.thread;

/**
 * <p>@Description: com.fitt.gbt.qbank.thread</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-10</p>
 * <p>@version: 1.0</p>
 */
public class ThreadA implements Runnable {
	private ResourceA resourceA;
	private ResourceB resourceB;

	public ThreadA(ResourceA resourceA, ResourceB resourceB) {
		this.resourceA = resourceA;
		this.resourceB = resourceB;
	}

	@Override
	public void run() {
		System.out.println("threadA ,wait to get lock from resourceA...");
		synchronized (resourceA) {
			System.out.println("threadA,already get lock from resourceA...");
			resourceA.setCount(resourceA.getCount() - 1);

			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("threadA ,wait to get lock from resourceB...");
			synchronized (resourceB) {
				System.out.println("threadA,already get lock from resourceB...");
				resourceB.setCount(resourceB.getCount() - 1);
			}
			System.out.println("threadA, already release lock from resourceB...");
		}
		System.out.println("threadA, already release lock from resourceA...");
	}
}

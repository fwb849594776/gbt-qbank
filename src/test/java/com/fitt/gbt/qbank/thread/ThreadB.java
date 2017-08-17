package com.fitt.gbt.qbank.thread;

/**
 * <p>@Description: com.fitt.gbt.qbank.thread</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-10</p>
 * <p>@version: 1.0</p>
 */
public class ThreadB implements Runnable {
	private ResourceA resourceA;
	private ResourceB resourceB;

	public ThreadB(ResourceA resourceA, ResourceB resourceB) {
		this.resourceA = resourceA;
		this.resourceB = resourceB;
	}

	@Override
	public void run() {
		System.out.println("threadB ,wait to get lock from resourceB...");
		synchronized (resourceB) {
			System.out.println("threadB,already get lock from resourceB...");
			resourceB.setCount(resourceB.getCount() - 1);

			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("threadB ,wait to get lock from resourceA...");
			synchronized (resourceA) {
				System.out.println("threadB,already get lock from resourceA...");
				resourceA.setCount(resourceA.getCount() - 1);
			}
			System.out.println("threadB, already release lock from resourceA...");
		}
		System.out.println("threadB, already release lock from resourceB...");
	}
}

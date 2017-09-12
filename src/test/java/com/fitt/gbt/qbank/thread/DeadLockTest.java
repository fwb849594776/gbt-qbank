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

	static class ThreadA implements Runnable {
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

	static class ThreadB implements Runnable {
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

	static class ResourceA {
		private int count;

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}
	}
	static class ResourceB {
		private int count;

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}
	}
}

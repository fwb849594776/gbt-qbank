package com.fitt.gbt.qbank.thread;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>@Description: com.fitt.gbt.qbank.thread</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-15</p>
 * <p>@version: 1.0</p>
 */
public class ReentrantLockTest {
	private ArrayList<Integer> arrayList = new ArrayList<Integer>();
	public static void main(String[] args) {
		final ReentrantLockTest test = new ReentrantLockTest();

		new Thread(new Runnable() {
			@Override
			public void run() {

			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				test.insert(Thread.currentThread());
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				test.insert(Thread.currentThread());
			}
		}).start();
	}


	public void insert(Thread thread) {
		Lock lock = new ReentrantLock();
		lock.lock();
		try {
			System.out.println(thread.getName() + " get lock");
			for (int i = 0; i < 5; i ++) {
				arrayList.add(i);
			}
		} catch (Exception e) {

		} finally {
			System.out.println(thread.getName() + " unlock");
			lock.unlock();
		}

	}
}

package com.fitt.gbt.qbank.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>@Description: 分别使用wait-notify 和 Lock交替打印出A\B</p>
 * <p>@Copyright: Copyright(C) 2017 by FITT</p>
 * <p>@Author: SixAwn</p>
 * <p>@Created: 2017-08-23</p>
 * <p>@version: 1.0</p>
 */
public class ThreadOrderExecTest {
	private final static Object OBJ = new Object();

	public static void main(String[] args) {
		////// 使用wait/notify 交替打印A|B
//		Producer producer = new ThreadOrderExecTest.Producer();
//		Consumer consumer = new ThreadOrderExecTest.Consumer();

		////// 使用Lock 交替打印A|B
		Lock lock = new ReentrantLock();
		ProducerLock producer = new ThreadOrderExecTest.ProducerLock(lock);
		ConsumerLock consumer = new ThreadOrderExecTest.ConsumerLock(lock);


		new Thread(producer).start();
		new Thread(consumer).start();
	}

	////////////////////////////////////////////////////
	////// 使用wait/notify 交替打印A|B
	////////////////////////////////////////////////////
	static class Consumer implements Runnable {

		@Override
		public void run() {
			int count = 10;
			while (count > 0) {
				synchronized (ThreadOrderExecTest.OBJ) {
					System.out.println("B");
					count--;

					ThreadOrderExecTest.OBJ.notify();

					try {
						ThreadOrderExecTest.OBJ.wait();
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}
				}
			}
		}
	}

	static class Producer implements Runnable {

		@Override
		public void run() {
			int count = 10;
			while (count > 0) {
				synchronized (ThreadOrderExecTest.OBJ) {
					System.out.println("A");
					count--;

					ThreadOrderExecTest.OBJ.notify();

					try {
						ThreadOrderExecTest.OBJ.wait();
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}
				}
			}
		}
	}

	////////////////////////////////////////////////////
	////// 使用Lock 交替打印A|B
	////////////////////////////////////////////////////
	static class ConsumerLock implements Runnable {
		private Lock lock;

		public ConsumerLock(Lock lock) {
			this.lock = lock;
		}

		@Override
		public void run() {
			int count = 10;
			while (count > 0) {
				try {
					lock.lock();
					count--;
					System.out.println("B");
				} finally {
					lock.unlock();
				}

				try {
					Thread.sleep(91L);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		}
	}

	static class ProducerLock implements Runnable {
		private Lock lock;

		public ProducerLock(Lock lock) {
			this.lock = lock;
		}

		@Override
		public void run() {
			int count = 10;
			while (count > 0) {
				try {
					lock.lock();
					count--;
					System.out.println("A");
				} finally {
					lock.unlock();
				}

				try {
					Thread.sleep(90L);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		}
	}
}

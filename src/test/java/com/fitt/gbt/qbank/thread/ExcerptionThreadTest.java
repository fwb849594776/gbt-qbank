package com.fitt.gbt.qbank.thread;

import com.fitt.gbt.qbank.service.ExercisesService;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * <p>@Description: com.fitt.gbt.qbank.thread</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-15</p>
 * <p>@version: 1.0</p>
 */
public class ExcerptionThreadTest {
	public static void main(String[] args) {
		Thread thread = new Thread(new ExceptionThread1());
		ExercisesService exercisesService = (ExercisesService) Executors.newCachedThreadPool();
		exercisesService.equals(thread);
	}

	static class ExceptionThread1 implements Runnable {

		@Override
		public void run() {
			throw new RuntimeException();
		}
	}

	class ExceptionThread2 implements Runnable {
		@Override
		public void run() {
			Thread t = Thread.currentThread();
			System.out.println("run() by" + t);
			System.out.println("eh=" + t.getUncaughtExceptionHandler());
			throw new RuntimeException();
		}
	}

	class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
		@Override
		public void uncaughtException(Thread thread, Throwable ex) {
			System.out.println("caught" + ex);
		}
	}

	//调用工厂化方法为每一个thread对象都附上一个未捕获异常的处理器。
	class HandlerThreadFactory implements ThreadFactory {
		@Override
		public Thread newThread(Runnable r) {
			System.out.println(this + "creating new Thread");
			Thread t = new Thread(r);
			System.out.println("created " + t);
			t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
			System.out.println("eh=" + t.getUncaughtExceptionHandler());
			return t;
		}
	}
}

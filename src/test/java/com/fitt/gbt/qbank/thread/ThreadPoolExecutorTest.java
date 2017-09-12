package com.fitt.gbt.qbank.thread;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <p>@Description: com.fitt.gbt.qbank.thread</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-25</p>
 * <p>@version: 1.0</p>
 */
public class ThreadPoolExecutorTest {
	public static void main(String[] args) throws IOException {
		String cmd = "cmd " + "/c " + "iconfig/all";
		Process process = Runtime.getRuntime().exec(cmd);
		Scanner scanner = new Scanner(process.getInputStream());
		while (scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		scanner.close();

		/*
		ThreadPoolExecutor executor =
				new ThreadPoolExecutor(
						5,
						10,
						200,
						TimeUnit.MILLISECONDS,
						new ArrayBlockingQueue<Runnable>(5)
				);

		for (int i = 0; i < 15; i ++) {
			MyTask task = new MyTask(i);
			executor.execute(task);
			System.out.println("线程池中数目：" + executor.getPoolSize()
					+ ", 队列中等待执行的任务数目" + executor.getQueue().size()
					+ ", 已执行完别的任务数目：" + executor.getCompletedTaskCount());
		}
		executor.shutdown();*/
	}

	static class MyTask implements Runnable {
		private int taskNum;

		public MyTask(int taskNum) {
			this.taskNum = taskNum;
		}

		@Override
		public void run() {
			System.out.println("正在执行task "+taskNum);
			try {
				Thread.currentThread().sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("task "+taskNum+"执行完毕");
		}

	}
}

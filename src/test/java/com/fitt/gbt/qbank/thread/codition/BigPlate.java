package com.fitt.gbt.qbank.thread.codition;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * <p>@Description: com.fitt.gbt.qbank.thread.codition</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-21</p>
 * <p>@version: 1.0</p>
 */
public class BigPlate {
	private BlockingQueue<Object> eggs = new ArrayBlockingQueue<Object>(5);

	public void putEgg(Object egg) {
		try {
			eggs.put(egg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("放入鸡蛋");
	}

	public Object getEgg() {
		Object egg = null;
		try {
			egg = eggs.take();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("取出鸡蛋");
		return egg;
	}

	static class AddThread extends Thread {
		private BigPlate plate;
		private Object egg = new Object();

		public AddThread(BigPlate plate) {
			this.plate = plate;
		}

		@Override
		public void run() {
			plate.putEgg(egg);
		}
	}

	static class GetThread extends Thread {
		private BigPlate plate;

		public GetThread(BigPlate plate) {
			this.plate = plate;
		}

		@Override
		public void run() {
			plate.getEgg();
		}
	}

	public static void main(String[] args) {
		/*BigPlate plate = new BigPlate();
		// 先启动10个放鸡蛋线程
		for(int i = 0; i < 10; i++) {
			new Thread(new AddThread(plate)).start();
		}
		// 再启动10个取鸡蛋线程
		for(int i = 0; i < 10; i++) {
			new Thread(new GetThread(plate)).start();
		}*/
		String str = " abc d ef ";
		int firt = str.indexOf(" ");

		str = str.substring(firt+1, str.length());
		int last = str.lastIndexOf(" ");
		str = str.substring(0, last);
		System.out.println(str);

		NumberFormat currency = NumberFormat.getCurrencyInstance();
		NumberFormat percent = NumberFormat.getPercentInstance();
		percent.setMaximumFractionDigits(3);

		BigDecimal loanAmount = new BigDecimal("15000.46");
		BigDecimal interestRate = new BigDecimal("0.0008");
		BigDecimal interest = loanAmount.multiply(interestRate);

		System.out.println("贷款金额:\t" + currency.format(loanAmount));
		System.out.println("利率:\t" + percent.format(interestRate));
		System.out.println("利息:\t" + currency.format(interest));

	}

}

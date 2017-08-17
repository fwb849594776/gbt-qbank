package com.fitt.gbt.qbank;

/**
 * <p>@Description: com.fitt.gbt.qbank</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-10</p>
 * <p>@version: 1.0</p>
 */
public class InitializeDemo {
	private static int k = 1;
	private static InitializeDemo t1 = new InitializeDemo("t1");
	private static InitializeDemo t2 = new InitializeDemo("t2");
	private static int i = print("i");
	private static int n = 99;
	static {
		print("静态块");
	}
	// 非静态属性
	private int j = print("j");
	// 匿名构造方法
	{
		print("构造块");
	}
	// 构造方法
	public InitializeDemo(String str) {
		System.out.println((k++) + ":" + str + "   i=" + i + "    n=" + n);
		++i;
		++n;
	}
	public static int print(String str) {
		System.out.println((k++) + ":" + str + "   i=" + i + "    n=" + n);
		++n;
		return ++i;
	}
	public static void main(String args[]) {
		new InitializeDemo("init");
		// 静态块
		// 2:init	i=
		// 3:i	i=
	}
}

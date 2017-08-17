package com.fitt.gbt.qbank.rpc;

/**
 * <p>@Description: com.fitt.gbt.qbank.rpc</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-09</p>
 * <p>@version: 1.0</p>
 */
public class RpcConsumer {
	public static void main(String[] args) throws Exception {
		HelloService service = RpcFramework.refer(HelloService.class, "127.0.0.1", 1234);
		for (int i = 0; i < Integer.MAX_VALUE; i ++) {
			String hello = service.hello("World" + i);
			System.out.println(hello);
			Thread.sleep(1000);
		}
	}
}

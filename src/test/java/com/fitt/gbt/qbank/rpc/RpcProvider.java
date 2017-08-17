package com.fitt.gbt.qbank.rpc;

/**
 * <p>@Description: com.fitt.gbt.qbank.rpc</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-09</p>
 * <p>@version: 1.0</p>
 */
public class RpcProvider {
	public static void main(String[] args) throws Exception {
		HelloService service = new HelloServiceImpl();
		RpcFramework.export(service, 1234);
	}
}

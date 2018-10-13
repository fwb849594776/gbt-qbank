package com.fitt.gbt.qbank.rpc;

/**
 * <p>@Description: com.fitt.gbt.qbank.rpc</p>
 * <p>@Copyright: Copyright(C) 2017 by FITT</p>
 * <p>@Author: SixAwn</p>
 * <p>@Created: 2017-08-09</p>
 * <p>@version: 1.0</p>
 */
public class HelloServiceImpl implements HelloService {
	@Override
	public String hello(String name) {
		return "Hello " + name;
	}
}
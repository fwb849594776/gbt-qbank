package com.fitt.gbt.qbank;

import com.fitt.gbt.qbank.common.model.Result;
import com.fitt.gbt.qbank.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>@Description: 用户服务测试</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-03</p>
 * <p>@version: 1.0</p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	private static Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

	@Autowired
	private UserService userService;

	@Test
	public void testQuery() {
		Result result = userService.findByParameter(null,null, null, null, 0, 10);
		logger.info("......testQuery() result={}", result);
	}
}

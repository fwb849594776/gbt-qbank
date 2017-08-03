package com.fitt.gbt.qbank.common.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import org.apache.catalina.LifecycleState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>@Description: MongoDB副本集多host配置</p>
 * <p>@Copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@Author: Chuck[ZhengCongChun]</p>
 * <p>@Created: 2017-08-03</p>
 * <p>@version: 1.0</p>
 */
//@Component
public class MongoConfig {
	private static final Logger logger = LoggerFactory.getLogger(MongoConfig.class);

	/**
	 * @ConditionalOnMissingBean(MongoClient.class)
	 * 这个非常重要,这个是告诉系统，下面的bean是要替换系统默认的那个bean的（mongodb）
	 * @return
	 */
//	@Bean
//	@ConditionalOnMissingBean(MongoClient.class)
	public MongoClient getMongoClient(){
		MongoClient client = null;
		try {
			logger.info("/******************************************************/");
			logger.info("/*================== 初始化MongoClient =================*/");

			// 设置Mongo副本集主机配置
			List<ServerAddress> addresses = new ArrayList<>();
			ServerAddress address28004 = new ServerAddress("192.168.20.155", 28004);
			ServerAddress address28005 = new ServerAddress("192.168.20.155", 28005);
			ServerAddress address28006 = new ServerAddress("192.168.20.155", 28006);
			addresses.add(address28004);
			addresses.add(address28005);
			addresses.add(address28006);
			// 设置Mongo副本集认证信息
			MongoCredential credential =
					MongoCredential.createMongoCRCredential("gbt", "gbt", "gbt123".toCharArray());

			// 设置Mongo副本集连接选项
			MongoClientOptions options =
					MongoClientOptions
							.builder()
							.readPreference(ReadPreference.secondaryPreferred())
							.build();

			client = new MongoClient(addresses, Arrays.asList(credential), options);
			logger.info("/*================= 初始化MongoClient =================*/");
			logger.info("/******************************************************/");
		} catch (RuntimeException e) {
			logger.error(".......getMongoClient() initial MongoClient occurred error!", e);
		}
		return client;
	}
}

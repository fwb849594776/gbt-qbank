package com.fitt.gbt.qbank.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.annotation.PostConstruct;

/**
 * <p>@description: Freemarker配置 </p>
 * <p>@copyright: Copyright(C) 2017 by AIRAG</p>
 * <p>@author: Miles[ZhengCongChun]</p>
 * <p>@created: 2017-12-07</p>
 * <p>@version: 1.0</p>
 */
@Configuration
public class FreemarkerConfig {
	@Autowired
	protected freemarker.template.Configuration configuration;

	@Autowired
	protected FreeMarkerViewResolver resolver;

	@Autowired
	protected InternalResourceViewResolver springResolver;

	@PostConstruct
	public void setSharedVariable() {
		resolver.setSuffix(".ftl");
		resolver.setCache(false);
		resolver.setRequestContextAttribute("request"); //为模板调用时，调用request对象的变量名</span>
		resolver.setOrder(0);
		resolver.setExposeRequestAttributes(true);
		resolver.setExposeSessionAttributes(true);
	}
}

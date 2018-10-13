package com.fitt.gbt.qbank;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.sql.DataSourceDefinition;

@SpringBootApplication
@MapperScan("com.fitt.gbt.qbank.mapper")
//@EnableScheduling
public class QBankApp {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(QBankApp.class, args);
		String[] profiles = context.getEnvironment().getActiveProfiles();
		if (null != profiles) {
			for (String profile : profiles) {
				System.out.println("----------start with profile: " + profile);
			}
		}
	}
}

package com.fitt.gbt.qbank;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.fitt.gbt.qbank.mapper*")
@SpringBootApplication
@EnableScheduling // 启用定时任务
public class QuestionBankApplication {
	public static void main(String[] args) {
		SpringApplication.run(QuestionBankApplication.class, args);
	}
}

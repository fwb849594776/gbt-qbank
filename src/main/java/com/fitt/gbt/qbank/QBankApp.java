package com.fitt.gbt.qbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class QBankApp {
	public static void main(String[] args) {
		SpringApplication.run(QBankApp.class, args);
	}
}

package com.fitt.gbt.qbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 这里，启用定时任务
public class QBankApplication {
    public static void main(String[] args) {
        SpringApplication.run(QBankApplication.class, args);
    }
}

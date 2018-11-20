/*
 * Copyright (c) 2018 by Alibaba.inc All rights reserved
 */
package com.fitt.gbt.qbank.pattern.responsibility;

import java.math.BigDecimal;

/**
 * @author : <a href="mailto:congchun.zcc@gmail.com">congchun.zcc</a>
 * @version : 1.0.0
 * @description : 客户端演示
 * @since : 2018/11/19
 */
public class Client {
    public static void main(String[] args) {
        Approver wukong = new Staff("孙悟空");
        wukong.setNextApprover(new Manager("唐僧")).setNextApprover(new CEO("如来佛祖"));

        System.out.println("************悟空申请500元活动经费************\n");
        wukong.approve(new BigDecimal(500));

        System.out.println("************悟空申请1500元活动经费************\n");
        wukong.approve(new BigDecimal(1500));

        System.out.println("************悟空申请5500元活动经费************\n");
        wukong.approve(new BigDecimal(5500));

        System.out.println("************悟空申请15500元活动经费************\n");
        wukong.approve(new BigDecimal(15500));
    }
}

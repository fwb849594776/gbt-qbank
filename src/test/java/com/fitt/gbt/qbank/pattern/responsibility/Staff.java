/*
 * Copyright (c) 2018 by fitt.inc All rights reserved
 */
package com.fitt.gbt.qbank.pattern.responsibility;

import java.math.BigDecimal;

/**
 * @author : <a href="mailto:congchun.zcc@gmail.com">congchun.zcc</a>
 * @version : 1.0.0
 * @description : 申请人: 1000-员工, 5000-经理, 10000-CEO
 * @since : 2018/11/19
 */
public class Staff extends Approver {
    public Staff(String name) {
        super(name);
    }

    @Override
    public void approve(BigDecimal amount) {
        if (amount.intValue() <= 1000) {
            System.out.println("审批通过。 员工【" + this.name + "】, 申请金额【" + amount + "】元");
        } else {
            System.out.println("无权审批, 升级处理。 员工【" + this.name + "】, 申请金额【" + amount + "】元");
            this.nextApprover.approve(amount);
        }
    }
}

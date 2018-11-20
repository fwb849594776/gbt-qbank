/*
 * Copyright (c) 2018 by Alibaba.inc All rights reserved
 */
package com.fitt.gbt.qbank.pattern.responsibility;

import java.math.BigDecimal;

/**
 * @author : <a href="mailto:congchun.zcc@gmail.com">congchun.zcc</a>
 * @version : 1.0.0
 * @description : 申请人: 1000-员工, 5000-经理, 10000-CEO
 * @since : 2018/11/19
 */
public abstract class Approver {
    protected String name;

    protected Approver nextApprover;

    public Approver(String name) {
        this.name = name;
    }

    protected Approver setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
        return this.nextApprover;
    }

    /**
     * 申请金额
     * @param amount
     */
    public abstract void approve(BigDecimal amount);
}

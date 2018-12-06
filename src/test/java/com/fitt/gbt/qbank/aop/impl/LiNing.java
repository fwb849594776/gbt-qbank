/*
 * Copyright (c) 2018 by Fitt.inc All rights reserved
 */
package com.fitt.gbt.qbank.aop.impl;

import com.fitt.gbt.qbank.aop.Runner;

/**
 * @author : <a href="mailto:congchun.zheng@gmail.com">congchun.zheng</a>
 * @version : 1.0.0
 * @description : 李宁
 * @since : 2018/12/06
 */
public class LiNing implements Runner {
    @Override
    public void run() {
        before();
        System.out.println("跑步者: " + this.getClass().getName());
        after();
    }

    private void before() {
        System.out.println("开始时间: " + System.currentTimeMillis());
    }

    private void after() {
        System.out.println("结束时间: " + System.currentTimeMillis());
    }
}

/*
 * Copyright (c) 2018 by Fitt.inc All rights reserved
 */
package com.fitt.gbt.qbank.aop;

import com.fitt.gbt.qbank.aop.impl.LiuXiang;

/**
 * @author : <a href="mailto:congchun.zheng@gmail.com">congchun.zheng</a>
 * @version : 1.0.0
 * @description : 静态代理
 * @since : 2018/12/06
 */
public class RunnerStaticProxy implements Runner {
    private LiuXiang runner;

    public RunnerStaticProxy(LiuXiang runner) {
        this.runner = runner;
    }

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

/*
 * Copyright (c) 2018 by Fitt.inc All rights reserved
 */
package com.fitt.gbt.qbank.aop.impl;

import com.fitt.gbt.qbank.aop.Runner;

/**
 * @author : <a href="mailto:congchun.zheng@gmail.com">congchun.zheng</a>
 * @version : 1.0.0
 * @description : 刘翔
 * @since : 2018/12/06
 */
public class LiuXiang implements Runner {
    @Override
    public void run() {
        System.out.println("跑步者: " + this.getClass().getName());
    }
}

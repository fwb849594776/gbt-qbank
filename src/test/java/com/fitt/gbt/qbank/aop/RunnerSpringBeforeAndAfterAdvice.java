/*
 * Copyright (c) 2018 by Fitt.inc All rights reserved
 */
package com.fitt.gbt.qbank.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author : <a href="mailto:congchun.zheng@gmail.com">congchun.zheng</a>
 * @version : 1.0.0
 * @description : Spring AOP 前后增强
 * @since : 2018/12/06
 */
public class RunnerSpringBeforeAndAfterAdvice implements MethodBeforeAdvice, AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("结束时间: " + System.currentTimeMillis());
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("开始时间: " + System.currentTimeMillis());
    }
}

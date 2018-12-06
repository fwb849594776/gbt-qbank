/*
 * Copyright (c) 2018 by Fitt.inc All rights reserved
 */
package com.fitt.gbt.qbank.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author : <a href="mailto:congchun.zheng@gmail.com">congchun.zheng</a>
 * @version : 1.0.0
 * @description : Spring AOP 环绕增强
 * @since : 2018/12/06
 */
public class RunnerSpringAroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        before();
        Object result = methodInvocation.proceed();
        after();
        return result;
    }

    private void before() {
        System.out.println("开始时间: " + System.currentTimeMillis());
    }

    private void after() {
        System.out.println("结束时间: " + System.currentTimeMillis());
    }
}

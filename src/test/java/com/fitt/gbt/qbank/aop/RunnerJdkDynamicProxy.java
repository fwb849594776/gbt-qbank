/*
 * Copyright (c) 2018 by Fitt.inc All rights reserved
 */
package com.fitt.gbt.qbank.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : <a href="mailto:congchun.zheng@gmail.com">congchun.zheng</a>
 * @version : 1.0.0
 * @description : JDK动态代理
 * @since : 2018/12/06
 */
public class RunnerJdkDynamicProxy implements InvocationHandler {
    private Object target;

    public RunnerJdkDynamicProxy(Object target) {
        this.target = target;
    }

    public <T> T getProxy() {
        return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    private void before() {
        System.out.println("开始时间: " + System.currentTimeMillis());
    }

    private void after() {
        System.out.println("结束时间: " + System.currentTimeMillis());
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }
}

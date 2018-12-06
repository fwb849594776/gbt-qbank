/*
 * Copyright (c) 2018 by Fitt.inc All rights reserved
 */
package com.fitt.gbt.qbank.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author : <a href="mailto:congchun.zheng@gmail.com">congchun.zheng</a>
 * @version : 1.0.0
 * @description : CGLIB代理
 * @since : 2018/12/06
 */
public class RunnerCglibProxy implements MethodInterceptor {
    private static RunnerCglibProxy instance = new RunnerCglibProxy();

    private RunnerCglibProxy() {}

    public static RunnerCglibProxy getInstance() {
        return instance;
    }

    public <T> T getProxy(Class<T> clazz) {
        return (T)Enhancer.create(clazz, this);
    }


    private void before() {
        System.out.println("开始时间: " + System.currentTimeMillis());
    }

    private void after() {
        System.out.println("结束时间: " + System.currentTimeMillis());
    }

    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(target, args);
        after();
        return result;
    }
}

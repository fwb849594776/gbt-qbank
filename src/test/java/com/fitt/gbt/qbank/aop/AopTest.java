/*
 * Copyright (c) 2018 by Fitt.inc All rights reserved
 */
package com.fitt.gbt.qbank.aop;

import com.fitt.gbt.qbank.aop.impl.LiNing;
import com.fitt.gbt.qbank.aop.impl.LiuXiang;
import org.springframework.aop.framework.AdvisorChainFactory;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author : <a href="mailto:congchun.zheng@gmail.com">congchun.zheng</a>
 * @version : 1.0.0
 * @description : 测试
 * @since : 2018/12/06
 */
public class AopTest {
    public static void main(String[] args) {
        System.out.println("----------------------HardCode-----------------------");
        testHardCode();
        System.out.println("----------------------StaticProxy-----------------------");
        testStaticProxy();
        System.out.println("----------------------JdkDynamicProxy-----------------------");
        testJdkDynamicProxy();
        System.out.println("----------------------CglibProxy-----------------------");
        testCglibProxy();
        System.out.println("----------------------SpringAopProxy-----------------------");
        testSpringAopProxy();
        System.out.println("----------------------SpringAopBeforeAndAfterProxy-----------------------");
        testSpringAopBeforeAndAfterProxy();
        System.out.println("----------------------SpringAopAroundProxy-----------------------");
        testSpringAopAroundProxy();
    }

    private static void testHardCode() {
        Runner runner = new LiNing();
        runner.run();
    }

    private static void testStaticProxy() {
        Runner runner = new RunnerStaticProxy(new LiuXiang());
        runner.run();
    }

    private static void testJdkDynamicProxy() {
        Runner runner = new RunnerJdkDynamicProxy(new LiuXiang()).getProxy();
        runner.run();
    }

    private static void testCglibProxy() {
        Runner runner = RunnerCglibProxy.getInstance().getProxy(LiuXiang.class);
        runner.run();
    }

    private static void testSpringAopProxy() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new LiuXiang());
        proxyFactory.addAdvice(new RunnerSpringBeforeAdvice());
        proxyFactory.addAdvice(new RunnerSpringAfterAdvice());

        Runner runner = (Runner) proxyFactory.getProxy();
        runner.run();
    }

    private static void testSpringAopBeforeAndAfterProxy() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new LiuXiang());
        proxyFactory.addAdvice(new RunnerSpringBeforeAndAfterAdvice());

        Runner runner = (Runner) proxyFactory.getProxy();
        runner.run();
    }

    private static void testSpringAopAroundProxy() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new LiuXiang());
        proxyFactory.addAdvice(new RunnerSpringAroundAdvice());

        Runner runner = (Runner) proxyFactory.getProxy();
        runner.run();
    }
}

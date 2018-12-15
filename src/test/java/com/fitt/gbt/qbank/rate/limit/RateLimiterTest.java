/*
 * Copyright (c) 2018 by FITT.inc All rights reserved
 */
package com.fitt.gbt.qbank.rate.limit;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * @author : <a href="mailto:congchun.zheng@gmail.com">sixawn</a>
 * @version : 1.0.0
 * @description : RateLimiter-速率限流, Semaphore-线程个数限制
 * @since : 2018-12-15 21:32
 */
public class RateLimiterTest {
    // 限制2秒一次操作，入口速率限制
    private final static RateLimiter rateLimiter = RateLimiter.create(0.5d);

    // 同时允许三个线程
    private final static Semaphore semaphore = new Semaphore(3);

    private static void testSemaphore() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " is doing work.....");
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + " release the semaphore. other can get and do job");
        }
    }

    private static void doSemaphore() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(0, 10).forEach((i) -> {
            executorService.submit(RateLimiterTest::testSemaphore);
        });
    }

    private static void testRateLimiter() {
        System.out.println(Thread.currentThread().getName() + " waiting " + rateLimiter.acquire());

    }

    private static void doRateLimiter() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(0, 10).forEach((i) -> {
            executorService.submit(RateLimiterTest::testRateLimiter);
        });
    }

    public static void main(String[] args) {
        IntStream.range(0,10).forEach((a) -> System.out.println(a));

//        doSemaphore();
//
        doRateLimiter();

    }

    private static final ThreadFactory threadFactory = r -> new Thread(r);

}

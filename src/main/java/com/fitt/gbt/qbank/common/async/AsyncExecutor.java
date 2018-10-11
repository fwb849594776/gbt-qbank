/*
 * Copyright (c) 2004-2018 by UCWeb All rights reserved
 */
package com.fitt.gbt.qbank.common.async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 异步线程池
 *
 * @author <a href="mailto:zhengbodi@163.com">谷粑糖</a>
 * @version 1.0.0
 * @since 2018/04/28
 */
public class AsyncExecutor {
    /**
     * 线程计数器
     */
    private static final AtomicIntegerArray threadNums = new AtomicIntegerArray(10);
    private static final int MAX_THREAD_NUMS = 50;

    /**
     * 线程池
     */
    private static ExecutorService POOL = new ScheduledThreadPoolExecutor(5, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable task) {
            int currIndex = threadNums.getAndIncrement(0);
            if (currIndex > MAX_THREAD_NUMS) {
                threadNums.set(0, 0);
            }
            return new Thread(task, "async-executor-thread-" + currIndex);
        }
    });

    public static void submit(Runnable task) {
        submit(POOL, task);
    }

    public static void submit(ExecutorService pool, Runnable task) {
        pool.submit(task);
    }

    /**
     * 异步查询线程池
     */
    public static final ScheduledExecutorService ASYNC_QUERY_POOL;

    static {
        ASYNC_QUERY_POOL = new ScheduledThreadPoolExecutor(5, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable task) {
                int curIndex = threadNums.getAndIncrement(4);
                if (curIndex > MAX_THREAD_NUMS) {
                    threadNums.set(1, 0);
                }
                return new Thread(task, "common-async-executor-query-thread-" + curIndex);
            }
        });
        ((ScheduledThreadPoolExecutor)ASYNC_QUERY_POOL).setMaximumPoolSize(MAX_THREAD_NUMS);
    }

    /**
     * 异步提交预约线程池
     */
    public static final ScheduledExecutorService ASYNC_APPT_SUBMIT_POOL;

    static {
        ASYNC_APPT_SUBMIT_POOL = new ScheduledThreadPoolExecutor(5, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable task) {
                int curIndex = threadNums.getAndIncrement(4);
                if (curIndex > MAX_THREAD_NUMS) {
                    threadNums.set(2, 0);
                }
                return new Thread(task, "common-async-executor-appt-submit-thread-" + curIndex);
            }
        });
        ((ScheduledThreadPoolExecutor)ASYNC_APPT_SUBMIT_POOL).setMaximumPoolSize(MAX_THREAD_NUMS);
    }
}

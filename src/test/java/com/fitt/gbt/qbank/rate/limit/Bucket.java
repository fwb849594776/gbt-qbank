/*
 * Copyright (c) 2018 by FITT.inc All rights reserved
 */
package com.fitt.gbt.qbank.rate.limit;

import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * @author : <a href="mailto:congchun.zheng@gmail.com">sixawn</a>
 * @version : 1.0.0
 * @description : 漏洞算法限流
 * @since : 2018-12-15 22:12
 */
public class Bucket {
    private final ConcurrentLinkedQueue<Integer> container = new ConcurrentLinkedQueue<>();

    private final static int BUCKET_LIMIT = 1000;

    // 一秒钟允许10次执行
    private final RateLimiter consumerRate = RateLimiter.create(10d);

    private Monitor offerMonitor = new Monitor();

    private Monitor consumerMonitor = new Monitor();

    public void submit(Integer data) {
        Monitor.Guard guard = new Monitor.Guard(offerMonitor) {
            @Override
            public boolean isSatisfied() {
                return container.size() < BUCKET_LIMIT;
            }
        };
        if (offerMonitor.enterIf(guard)) {
            try {
                container.offer(data);
                System.out.println(Thread.currentThread() + " submit.." + data + " container size is :[" + container.size() + "]");
            } finally {
                offerMonitor.leave();
            }
        } else {
            //这里时候采用降级策略了。消费速度跟不上产生速度时，而且桶满了，抛出异常
            //或者存入MQ DB等后续处理
            throw new IllegalStateException(Thread.currentThread().getName() + "The bucket is ful..Pls latter can try...");
        }

    }

    /**
     * 从桶里面消费数据
     *
     * @param consumer
     */
    public void takeThenConsumer(Consumer<Integer> consumer) {
        Monitor.Guard guard = new Monitor.Guard(consumerMonitor) {
            @Override
            public boolean isSatisfied() {
                return container.size() < BUCKET_LIMIT;
            }
        };
        if (consumerMonitor.enterIf(guard)) {
            try {
                //不打印时 写 consumerRate.acquire();
                System.out.println(Thread.currentThread()
                        + "  waiting" + consumerRate.acquire());
                Integer data = container.poll();
                //container.peek() 只是去取出来不会删掉
                consumer.accept(data);
            } finally {
                consumerMonitor.leave();
            }
        } else {
            //当木桶的消费完后，可以消费那些降级存入MQ或者DB里面的数据
            System.out.println("will consumer Data from MQ...");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        final Bucket bucket = new Bucket();
        final AtomicInteger DATA_CREATOR = new AtomicInteger(0);

        // 生产线程 10个线程 每秒提交 50个数据  1/0.2s*10=50个
        IntStream.range(0, 10).forEach(i -> {
            new Thread(() -> {
                for (; ; ) {
                    int data = DATA_CREATOR.incrementAndGet();
                    try {
                        bucket.submit(data);
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (Exception ex) {
                        if (ex instanceof IllegalStateException) {
                            System.out.println(ex.getMessage());
                            try {
                                TimeUnit.SECONDS.sleep(600);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }).start();
        });

        //消费线程  采用RateLimiter每秒处理10个  综合的比率是5:1
        IntStream.range(0, 10).forEach(i -> {
            new Thread(
                    () -> {
                        for (; ; ) {
                            bucket.takeThenConsumer(x -> {
                                System.out.println(Thread.currentThread().getName() + " C.. " + x);
                            });
                        }
                    }).start();
        });
    }

}

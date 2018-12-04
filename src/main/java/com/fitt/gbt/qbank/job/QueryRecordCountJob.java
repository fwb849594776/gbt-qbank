/*
 * Copyright (c) 2004-2018 by Fitt.inc All rights reserved
 */
package com.fitt.gbt.qbank.job;

import com.fitt.gbt.qbank.common.async.AsyncExecutor;
import com.fitt.gbt.qbank.common.model.order.DayInfo;
import com.fitt.gbt.qbank.service.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 查询剩余号任务
 *
 * @author <a href="mailto:zhengbodi@163.com">谷粑糖</a>
 * @version 1.0.0
 * @since 2018/04/27
 */
@Component
public class QueryRecordCountJob {
    private static Logger logger = LoggerFactory.getLogger(QueryRecordCountJob.class);

    private static final AtomicBoolean RUNNING = new AtomicBoolean(false);

    @Autowired
    private RecordService recordService;

    /**
     * 10分钟执行一次查询
     */
    @Scheduled(fixedDelay = 10 * 60 * 1000)
    public void doQuery() {
        if (RUNNING.get()) {
            logger.info("[QueryRecordCountJob.doQuery]前一个定时任务正在执行中...");
        }
        try {
            RUNNING.set(true);

            logger.info("[QueryRecordCountJob.doQuery] Job Start...");

            // 查询工作日信息
            List<DayInfo> dayInfos = recordService.doQueryWorkDayInfo();
            if (!CollectionUtils.isEmpty(dayInfos)) {
                logger.info("[QueryRecordCountJob.doQuery] begin workDayInfo size[{}]", dayInfos.size());
                for (DayInfo dayInfo : dayInfos) {
                    // TODO 加锁
                    AsyncExecutor.ASYNC_QUERY_POOL.submit(new QueryRecordCountTask(dayInfo));
                }
            }
        } catch (Exception e) {
            logger.error("[QueryRecordCountJob.doQuery] execute Job occurred error.", e);
        } finally {
            RUNNING.set(false);
        }

        logger.info("[QueryRecordCountJob.doQuery] Job End...");
    }
}

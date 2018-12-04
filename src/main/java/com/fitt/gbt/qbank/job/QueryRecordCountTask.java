/*
 * Copyright (c) 2004-2018 by Fitt.inc All rights reserved
 */
package com.fitt.gbt.qbank.job;

import com.fitt.gbt.qbank.common.async.AsyncExecutor;
import com.fitt.gbt.qbank.common.enums.ApptServiceItemEnum;
import com.fitt.gbt.qbank.common.model.RecordDTO;
import com.fitt.gbt.qbank.common.model.order.DayInfo;
import com.fitt.gbt.qbank.common.utils.ApplicationContextUtil;
import com.fitt.gbt.qbank.domain.Order;
import com.fitt.gbt.qbank.service.OrderService;
import com.fitt.gbt.qbank.service.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 剩余号查询任务
 *
 * @author <a href="mailto:congchun.zcc@gmail.com">congchun.zcc</a>
 * @version 1.0.0
 * @since 2018/04/28
 */
//@Component
public class QueryRecordCountTask implements Runnable {
    private static Logger logger = LoggerFactory.getLogger(QueryRecordCountTask.class);

    private RecordService recordService;

    private OrderService orderListService;

    private DayInfo dayInfo;

    public QueryRecordCountTask(DayInfo dayInfo) {
        this.dayInfo = dayInfo;
        this.recordService = (RecordService)ApplicationContextUtil.getBean("recordService");
        this.orderListService = (OrderService)ApplicationContextUtil.getBean("orderListService");
    }

    @Override
    public void run() {
        try {
            logger.info("[QueryRecordCountTask.run] Start...");
            // 查询方法并放回结果
            List<RecordDTO> recordDTOList = recordService.getCanOrderRecord(ApptServiceItemEnum.TECHNICIAN.getId(),
                dayInfo.getDate());

            List<Order> orderLists = orderListService.findAppointmentOrderList();

            if (CollectionUtils.isEmpty(orderLists) && !CollectionUtils.isEmpty(recordDTOList)) {
                logger.error("[QueryRecordCountTask.run] 唉···机会白白浪···没有人下单.");
                return;
            }

            // 异步执行提交
            if (!CollectionUtils.isEmpty(recordDTOList) && !CollectionUtils.isEmpty(orderLists)) {
                int index = 0;
                int orderListSize = orderLists.size();
                if (orderListSize > recordDTOList.size()) {
                    orderLists = orderLists.subList(0, recordDTOList.size());
                }
                List<Order> finalOrderLists = orderLists;
                recordDTOList.forEach(recordDTO -> {
                    AsyncExecutor.ASYNC_APPT_SUBMIT_POOL.submit(
                        new SubmitAppointmentTask(recordDTO, finalOrderLists.get(index)));
                });
            }
            logger.info("[QueryRecordCountTask.run] End...");
        } catch (Exception e) {
            logger.error("[QueryRecordCountTask.run] occurred error.", e);
        }

    }
}

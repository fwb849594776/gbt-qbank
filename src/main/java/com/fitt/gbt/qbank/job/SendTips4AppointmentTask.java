/*
 * Copyright (c) 2004-2018 by UCWeb All rights reserved
 */
package com.fitt.gbt.qbank.job;

import com.fitt.gbt.qbank.domain.OrderList;
import com.fitt.gbt.qbank.service.OrderListService;
import com.fitt.gbt.qbank.service.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 提交预约任务
 *
 * @author <a href="mailto:congchun.zcc@gmail.com">congchun.zcc</a>
 * @version 1.0.0
 * @since 2018/04/28
 */
//@Component
public class SendTips4AppointmentTask implements Runnable {
    private static Logger logger = LoggerFactory.getLogger(SendTips4AppointmentTask.class);

    @Autowired
    private OrderListService orderListService;

    @Autowired
    private RecordService recordService;

    @Override
    public void run() {
        try {
            logger.info("[SendTips4AppointmentTask.run] Start...");
            List<OrderList> orderLists = orderListService.findAppointmentOrderList();

            if (CollectionUtils.isEmpty(orderLists)) {
                return;
            }

            orderLists.forEach(orderList -> {
                recordService.doSendTips(orderList);
            });

            logger.info("[SendTips4AppointmentTask.run] End...");
        } catch (Exception ex) {
            logger.error("[SendTips4AppointmentTask.run] 发送已预约信息报错.", ex);
        }
    }
}

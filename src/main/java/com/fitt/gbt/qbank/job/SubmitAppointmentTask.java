/*
 * Copyright (c) 2004-2018 by UCWeb All rights reserved
 */
package com.fitt.gbt.qbank.job;

import com.alibaba.fastjson.JSON;
import com.fitt.gbt.qbank.common.model.RecordDTO;
import com.fitt.gbt.qbank.common.model.order.Appointment;
import com.fitt.gbt.qbank.domain.OrderList;
import com.fitt.gbt.qbank.service.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 提交预约任务
 *
 * @author <a href="mailto:congchun.zcc@gmail.com">congchun.zcc</a>
 * @version 1.0.0
 * @since 2018/04/28
 */
//@Component
public class SubmitAppointmentTask implements Runnable {
    private static Logger logger = LoggerFactory.getLogger(SubmitAppointmentTask.class);

    @Autowired
    private RecordService recordService;

    /**
     * 可预约的日期
     */
    private RecordDTO recordDTO;
    /**
     * 预约人信息
     */
    private OrderList orderList;

    public SubmitAppointmentTask(RecordDTO recordDTO, OrderList orderList) {
        this.recordDTO = recordDTO;
        this.orderList = orderList;
    }

    @Override
    public void run() {
        try {
            logger.info("[SubmitAppointmentTask.run] Start...");
            if (null == this.recordDTO || null == this.orderList) {
                logger.error("[SubmitAppointmentTask.run] 预约信息为空.RecordDTO[{}], OrderList[{}]",
                    JSON.toJSON(recordDTO), JSON.toJSON(orderList));
                return;
            }
            Appointment appointment = new Appointment();

            recordService.doAppointment(appointment);

            logger.info("[SubmitAppointmentTask.run] End...");
        } catch (Exception ex) {
            logger.error("[SubmitAppointmentTask.run] 预约报错.RecordDTO[{}], OrderList[{}]",
                JSON.toJSON(recordDTO), JSON.toJSON(orderList), ex);
        }
    }
}

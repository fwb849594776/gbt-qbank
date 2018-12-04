/*
 * Copyright (c) 2004-2018 by Fitt.inc All rights reserved
 */
package com.fitt.gbt.qbank.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fitt.gbt.qbank.common.constants.OrderConstants;
import com.fitt.gbt.qbank.common.model.RecordDTO;
import com.fitt.gbt.qbank.common.model.order.*;
import com.fitt.gbt.qbank.common.utils.HttpClientUtil;
import com.fitt.gbt.qbank.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 剩余号服务类
 *
 * @author <a href="mailto:zhengbodi@163.com">谷粑糖</a>
 * @version 1.0.0
 * @since 2018/04/27
 */
@Service("recordService")
public class RecordService {
    private static Logger logger = LoggerFactory.getLogger(RecordService.class);

    /**
     * 工作日时间段是否可预约标识列表
     */
    public static List<Map<String, Object>> timeCountList = new ArrayList<>();

    static {
        Map<String, Object> timeCount = new HashMap<>();
        timeCount.put("Count", "3");
        timeCount.put("Time", "08:30");
        timeCountList.add(timeCount);

        timeCount.put("Count", "4");
        timeCount.put("Time", "09:30");
        timeCountList.add(timeCount);

        timeCount.put("Count", "5");
        timeCount.put("Time", "10:30");
        timeCountList.add(timeCount);

        timeCount.put("Count", "3");
        timeCount.put("Time", "14:00");
        timeCountList.add(timeCount);

        timeCount.put("Count", "4");
        timeCount.put("Time", "15:00");
        timeCountList.add(timeCount);

        timeCount.put("Count", "5");
        timeCount.put("Time", "16:00");
        timeCountList.add(timeCount);
    }

    public List<DayInfo> doQueryWorkDayInfo() {
        List<DayInfo> dayInfos = new ArrayList<>();

        String resp = null;
        try {
            resp = HttpClientUtil.http(OrderConstants.QUERY_WORK_DAY_INFO, HttpMethod.GET.name(), null);
            logger.info("[RecordService.doQueryWorkDayInfo] http[{}] response[{}]",
                OrderConstants.QUERY_WORK_DAY_INFO, resp);

            if (!StringUtils.isEmpty(resp)) {
                WorkDayInfo workDayInfo = JSON.parseObject(resp, WorkDayInfo.class);
                if (null != workDayInfo && OrderConstants.SUCCESS.equals(workDayInfo.getSucc())) {
                    dayInfos = workDayInfo.getInfo();
                }
            }
        } catch (Exception e) {
            logger.error("[RecordService.doQueryWorkDayInfo] occurred error.", e);
        }
        return dayInfos;
    }

    public Record doQueryRecord(String bizId, String date) {
        Record record = null;

        String resp = null;
        RecordCount recordCount = null;
        try {
            String url = String.format(OrderConstants.ORDER_QUERY_RECORD_COUNT, bizId, date);
            resp = HttpClientUtil.http(url, HttpMethod.GET.name(), null);
            logger.info("[RecordService.doQueryRecordCount] http[{}] response[{}]", url, resp);

            if (!StringUtils.isEmpty(resp)) {
                recordCount = JSON.parseObject(resp, RecordCount.class);
                if (null != recordCount && recordCount.getSucc().equals(1)) {
                    record = recordCount.getRecord();
                }
            }
        } catch (Exception e) {
            logger.error("[RecordService.doQueryRecordCount] occurred error.", e);
        }

        return record;
    }

    public List<RecordDTO> getCanOrderRecord(String bizId, String date) {
        List<RecordDTO> recordDtoList = new ArrayList<>();
        Record record = null;
        try {
            record = this.doQueryRecord(bizId, date);
            if (null != record && !CollectionUtils.isEmpty(record.getTimeRecord())) {
                record.getTimeRecord().forEach(timeRecord -> {
                    for (int i = 0; i < 6; i++) {
                        if (timeRecord.getTime().equals(timeCountList.get(i).get("Time"))
                            && !timeRecord.getCount().equals(timeCountList.get(i).get("Count"))) {
                            logger.warn("[RecordService.getCanOrderRecord] 查询到可预约时间[{} - {} - {}], 加入可预约队列.",
                                date, timeRecord.getTime(), timeRecord.getCount());
                            RecordDTO dto = new RecordDTO(bizId, date, Integer.valueOf(timeRecord.getCount()),
                                timeRecord.getTime());
                            recordDtoList.add(dto);
                        }
                    }
                });
            }
            logger.info("[RecordService.getCanOrderRecord] bizId[{}] date[{}] record size[{}]", bizId, date,
                recordDtoList.size());
        } catch (Exception e) {
            logger.error("[RecordService.getCanOrderRecord] occurred error.", e);
        }
        return recordDtoList;
    }

    public void doAppointment(Appointment appointment) {
        if (logger.isInfoEnabled()) {
            logger.info("[RecordService.doAppointment] 预约信息:[{}]", JSON.toJSON(appointment));
        }
        String postDataMap = JSON.toJSONString(appointment);
        String resp = HttpClientUtil.http(OrderConstants.ORDER_APPOINTMENT_SERVICE, HttpMethod.POST.name(),
            postDataMap);
        logger.info("[RecordService.doAppointment] http[{}] response[{}]", OrderConstants.ORDER_APPOINTMENT_SERVICE,
            resp);

        if (!StringUtils.isEmpty(resp)) {
            JSONObject result = JSON.parseObject(resp);
            if (null != result && "Y".equalsIgnoreCase(result.getString("is_order"))) {
                logger.info("[RecordService.doAppointment] 预约人[{}], 预号成功!");

                // TODO 预号成功, 更新预约人订单状态
            } else {
                logger.info("[RecordService.doAppointment] 预约人[{}], 预号失败!");

                // TODO 更新预约订单的状态
            }
        }
    }

    public void doSendTips(Order orderList) {

    }
}

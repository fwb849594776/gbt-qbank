/*
 * Copyright (c) 2004-2018 by UCWeb All rights reserved
 */
package com.fitt.gbt.qbank.common.constants;

/**
 * 预约常量
 *
 * @author <a href="mailto:zhengbodi@163.com">谷粑糖</a>
 * @version 1.0.0
 * @since 2018/04/27
 */
public class OrderConstants {
    /**
     * 接口请求是否成功
     */
    public static final Integer SUCCESS = 1;

    /**
     * 剩余号查询接口
     */
    public static final String ORDER_QUERY_RECORD_COUNT = "http://thzwb.thnet.gov.cn/getRecordCount.action?BizId=%s&date=%s";

    /**
     * 预约提交请求接口
     */
    public static final String ORDER_APPOINTMENT_SERVICE = "http://thzwb.thnet.gov.cn/appointment/getOrderServiceItem.action";

    /**
     * 可预约20个工作日日期查询接口
     * 返回:
     * {
     *     "Succ": 1,
     *     "info": [
     *         {
     *             "AM_E": "12:00",
     *             "AM_S": "08:30",
     *             "Date": "2018-04-28",
     *             "PM_E": "17:30",
     *             "PM_S": "13:00",
     *             "Week": 7
     *         },
     *         {
     *             "AM_E": "12:00",
     *             "AM_S": "08:30",
     *             "Date": "2018-05-02",
     *             "PM_E": "17:30",
     *             "PM_S": "13:00",
     *             "Week": 4
     *         },
     *         {
     *             "AM_E": "12:00",
     *             "AM_S": "08:30",
     *             "Date": "2018-05-03",
     *             "PM_E": "17:30",
     *             "PM_S": "13:00",
     *             "Week": 5
     *         },
     *         {
     *             "AM_E": "12:00",
     *             "AM_S": "08:30",
     *             "Date": "2018-05-04",
     *             "PM_E": "17:30",
     *             "PM_S": "13:00",
     *             "Week": 6
     *         },
     *         {
     *             "AM_E": "12:00",
     *             "AM_S": "08:30",
     *             "Date": "2018-05-07",
     *             "PM_E": "17:30",
     *             "PM_S": "13:00",
     *             "Week": 2
     *         },
     *         {
     *             "AM_E": "12:00",
     *             "AM_S": "08:30",
     *             "Date": "2018-05-08",
     *             "PM_E": "17:30",
     *             "PM_S": "13:00",
     *             "Week": 3
     *         },
     *         {
     *             "AM_E": "12:00",
     *             "AM_S": "08:30",
     *             "Date": "2018-05-09",
     *             "PM_E": "17:30",
     *             "PM_S": "13:00",
     *             "Week": 4
     *         },
     *         {
     *             "AM_E": "12:00",
     *             "AM_S": "08:30",
     *             "Date": "2018-05-10",
     *             "PM_E": "17:30",
     *             "PM_S": "13:00",
     *             "Week": 5
     *         },
     *         {
     *             "AM_E": "12:00",
     *             "AM_S": "08:30",
     *             "Date": "2018-05-11",
     *             "PM_E": "17:30",
     *             "PM_S": "13:00",
     *             "Week": 6
     *         },
     *         {
     *             "AM_E": "12:00",
     *             "AM_S": "08:30",
     *             "Date": "2018-05-14",
     *             "PM_E": "17:30",
     *             "PM_S": "13:00",
     *             "Week": 2
     *         },
     *         {
     *             "AM_E": "12:00",
     *             "AM_S": "08:30",
     *             "Date": "2018-05-15",
     *             "PM_E": "17:30",
     *             "PM_S": "13:00",
     *             "Week": 3
     *         },
     *         {
     *             "AM_E": "12:00",
     *             "AM_S": "08:30",
     *             "Date": "2018-05-16",
     *             "PM_E": "17:30",
     *             "PM_S": "13:00",
     *             "Week": 4
     *         },
     *         {
     *             "AM_E": "12:00",
     *             "AM_S": "08:30",
     *             "Date": "2018-05-17",
     *             "PM_E": "17:30",
     *             "PM_S": "13:00",
     *             "Week": 5
     *         },
     *         {
     *             "AM_E": "12:00",
     *             "AM_S": "08:30",
     *             "Date": "2018-05-18",
     *             "PM_E": "17:30",
     *             "PM_S": "13:00",
     *             "Week": 6
     *         },
     *         {
     *             "AM_E": "12:00",
     *             "AM_S": "08:30",
     *             "Date": "2018-05-21",
     *             "PM_E": "17:30",
     *             "PM_S": "13:00",
     *             "Week": 2
     *         },
     *         {
     *             "AM_E": "12:00",
     *             "AM_S": "08:30",
     *             "Date": "2018-05-22",
     *             "PM_E": "17:30",
     *             "PM_S": "13:00",
     *             "Week": 3
     *         },
     *         {
     *             "AM_E": "12:00",
     *             "AM_S": "08:30",
     *             "Date": "2018-05-23",
     *             "PM_E": "17:30",
     *             "PM_S": "13:00",
     *             "Week": 4
     *         },
     *         {
     *             "AM_E": "12:00",
     *             "AM_S": "08:30",
     *             "Date": "2018-05-24",
     *             "PM_E": "17:30",
     *             "PM_S": "13:00",
     *             "Week": 5
     *         },
     *         {
     *             "AM_E": "12:00",
     *             "AM_S": "08:30",
     *             "Date": "2018-05-25",
     *             "PM_E": "17:30",
     *             "PM_S": "13:00",
     *             "Week": 6
     *         },
     *         {
     *             "AM_E": "12:00",
     *             "AM_S": "08:30",
     *             "Date": "2018-05-28",
     *             "PM_E": "17:30",
     *             "PM_S": "13:00",
     *             "Week": 2
     *         }
     *     ]
     * }
     */
    public static final String QUERY_WORK_DAY_INFO = "http://thzwb.thnet.gov.cn/getWorkDayInfo.action?days=20";
}

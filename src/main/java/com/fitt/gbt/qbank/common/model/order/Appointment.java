/*
 * Copyright (c) 2004-2018 by UCWeb All rights reserved
 */
package com.fitt.gbt.qbank.common.model.order;

import lombok.Data;

import java.io.Serializable;

/**
 * 预约申请模型
 *
 * @author <a href="mailto:zhengbodi@163.com">谷粑糖</a>
 * @version 1.0.0
 * @since 2018/04/27
 */
@Data
public class Appointment implements Serializable {
    private static final long serialVersionUID = -6029182389277179394L;
    /**
     * 预约身份证号码
     */
    private String certificate;
    /**
     * 预约手机号
     */
    private String phone;
    /**
     * 服务项目编码
     */
    private String service_item_code;
    /**
     * 预约时间: HH:mm
     */
    private String time;
    /**
     * 预约日期: yyyy-MM-dd
     */
    private String predate;
    /**
     * 服务项目名
     */
    private String service_item_name;
    /**
     * 办公室地址
     */
    private String address;
    /**
     * 办公室地址信息
     */
    private String addressMsg;
    /**
     * 办公室联系电话
     */
    private String addressPhone;
    /**
     * 机构编码
     */
    private String org_code;

    public static Appointment to7008() {
        Appointment appointment = new Appointment();
        appointment.setService_item_code("7008");
        return appointment;
    }

}

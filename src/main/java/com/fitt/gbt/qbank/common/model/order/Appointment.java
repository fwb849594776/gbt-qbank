/*
 * Copyright (c) 2004-2018 by Fitt.inc All rights reserved
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

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getService_item_code() {
        return service_item_code;
    }

    public void setService_item_code(String service_item_code) {
        this.service_item_code = service_item_code;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPredate() {
        return predate;
    }

    public void setPredate(String predate) {
        this.predate = predate;
    }

    public String getService_item_name() {
        return service_item_name;
    }

    public void setService_item_name(String service_item_name) {
        this.service_item_name = service_item_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressMsg() {
        return addressMsg;
    }

    public void setAddressMsg(String addressMsg) {
        this.addressMsg = addressMsg;
    }

    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }

    public String getOrg_code() {
        return org_code;
    }

    public void setOrg_code(String org_code) {
        this.org_code = org_code;
    }
}

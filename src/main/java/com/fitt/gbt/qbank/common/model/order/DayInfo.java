/*
 * Copyright (c) 2004-2018 by Fitt.inc All rights reserved
 */
package com.fitt.gbt.qbank.common.model.order;

import lombok.Data;

import java.io.Serializable;

/**
 * 工作日信息
 *
 * @author <a href="mailto:congchun.zcc@gmail.com">congchun.zcc</a>
 * @version 1.0.0
 * @since 2018/04/28
 */
@Data
public class DayInfo implements Serializable {
    private static final long serialVersionUID = 2665670514220421855L;
    /**
     * 上午工作开始时间
     */
    private String AM_S;
    /**
     * 上午工作结束时间
     */
    private String AM_E;
    /**
     * 下午工作开始时间
     */
    private String PM_S;
    /**
     * 上午工作结束时间
     */
    private String PM_E;
    /**
     * 工作日期
     */
    private String Date;
    /**
     * 星期: 1-星期日, 2-星期一, 3-星期二, 4-星期三, 5-星期四, 6-星期五, 7-星期六,
     */
    private Integer Week;

    public String getAM_S() {
        return AM_S;
    }

    public void setAM_S(String AM_S) {
        this.AM_S = AM_S;
    }

    public String getAM_E() {
        return AM_E;
    }

    public void setAM_E(String AM_E) {
        this.AM_E = AM_E;
    }

    public String getPM_S() {
        return PM_S;
    }

    public void setPM_S(String PM_S) {
        this.PM_S = PM_S;
    }

    public String getPM_E() {
        return PM_E;
    }

    public void setPM_E(String PM_E) {
        this.PM_E = PM_E;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Integer getWeek() {
        return Week;
    }

    public void setWeek(Integer week) {
        Week = week;
    }
}

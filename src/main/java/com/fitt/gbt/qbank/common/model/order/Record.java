/*
 * Copyright (c) 2004-2018 by Fitt.inc All rights reserved
 */
package com.fitt.gbt.qbank.common.model.order;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * qbank
 *
 * @author <a href="mailto:zhengbodi@163.com">谷粑糖</a>
 * @version 1.0.0
 * @since 2018/04/27
 */
@Data
public class Record implements Serializable {
    private static final long serialVersionUID = -4036884208081266881L;

    private String BizID;

    private String YYDate;

    private List<TimeRecord> TimeRecord;

    private Integer count;

    private String time;

    public String getYYDate() {
        return YYDate;
    }

    public void setYYDate(String YYDate) {
        this.YYDate = YYDate;
    }

    public List<com.fitt.gbt.qbank.common.model.order.TimeRecord> getTimeRecord() {
        return TimeRecord;
    }

    public void setTimeRecord(List<com.fitt.gbt.qbank.common.model.order.TimeRecord> timeRecord) {
        TimeRecord = timeRecord;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

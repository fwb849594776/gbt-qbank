/*
 * Copyright (c) 2004-2018 by UCWeb All rights reserved
 */
package com.fitt.gbt.qbank.common.model.order;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 工作日信息
 *
 * @author <a href="mailto:congchun.zcc@gmail.com">congchun.zcc</a>
 * @version 1.0.0
 * @since 2018/04/28
 */
@Data
public class WorkDayInfo implements Serializable {
    private static final long serialVersionUID = -3283712128038640760L;

    /**
     * 请求是否成功
     */
    private Integer Succ;
    /**
     * 工作日信息列表
     */
    private List<DayInfo> info;

    public Integer getSucc() {
        return Succ;
    }

    public void setSucc(Integer succ) {
        Succ = succ;
    }

    public List<DayInfo> getInfo() {
        return info;
    }

    public void setInfo(List<DayInfo> info) {
        this.info = info;
    }
}

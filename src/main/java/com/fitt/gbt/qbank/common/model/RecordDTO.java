/*
 * Copyright (c) 2004-2018 by UCWeb All rights reserved
 */
package com.fitt.gbt.qbank.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 可预约日期数据
 *
 * @author <a href="mailto:zhengbodi@163.com">谷粑糖</a>
 * @version 1.0.0
 * @since 2018/04/27
 */
@Data
public class RecordDTO implements Serializable {
    private static final long serialVersionUID = -2699751348404734819L;

    private String BizID;

    private String YYDate;

    private Integer count;

    private String time;

    public RecordDTO() {
    }

    public RecordDTO(String bizID, String YYDate, Integer count, String time) {
        BizID = bizID;
        this.YYDate = YYDate;
        this.count = count;
        this.time = time;
    }
}

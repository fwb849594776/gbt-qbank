/*
 * Copyright (c) 2004-2018 by UCWeb All rights reserved
 */
package com.fitt.gbt.qbank.common.model.order;

import lombok.Data;

import java.io.Serializable;

/**
 * 工作日信息
 *
 * @author <a href="mailto:congchun.zcc@alibaba-inc.com">congchun.zcc</a>
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

}

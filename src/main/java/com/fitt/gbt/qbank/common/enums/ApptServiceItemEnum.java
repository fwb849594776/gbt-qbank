/*
 * Copyright (c) 2004-2018 by Fitt.inc All rights reserved
 */
package com.fitt.gbt.qbank.common.enums;

/**
 * 预约服务事项
 *
 * @author <a href="mailto:congchun.zcc@gmail.com">congchun.zcc</a>
 * @version 1.0.0
 * @since 2018/04/28
 */
public enum ApptServiceItemEnum {
    /**
     * 未知
     */
    MASTER("7003", "研究生（硕士）或副高以上人才引进绿色通道"),
    /**
     * 未知
     */
    RETURNEES("7004", "海外人才引进绿色通道"),
    /**
     * 未知
     */
    GRADUATE("7006", "应届毕业生接收绿色通道"),
    /**
     * 未知
     */
    UNDERGRADUATE("7007", "本科（含中级职称）人才引进"),
    /**
     * 未知
     */
    TECHNICIAN("7008", "技师（含紧缺工种）人才引进"),
    /**
     * 未知
     */
    UNKNOWN("-1", "未知");

    String id;
    String name;

    ApptServiceItemEnum(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ApptServiceItemEnum getbyId(String id) {
        for (ApptServiceItemEnum item : ApptServiceItemEnum.values()) {
            if (item.id.equals(id)) {
                return item;
            }
        }
        return UNKNOWN;
    }
}

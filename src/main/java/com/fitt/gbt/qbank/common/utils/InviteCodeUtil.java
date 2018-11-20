/*
 * Copyright (c) 2018 by fitt.inc All rights reserved
 */
package com.fitt.gbt.qbank.common.utils;

/**
 * @author : <a href="mailto:congchun.zcc@gmail.com">congchun.zcc</a>
 * @version : 1.0.0
 * @description : 邀请码生成工具类
 * @since : 2018/11/14
 */
public class InviteCodeUtil {

    /**
     * 邀请码最小长度
     */
    public static int MIN_LENGTH = 4;

    /**
     * 邀请码最长长度
     */
    public static int MAX_LENGTH = 10;

    /**
     * 生成固定长度邀请码
     * @param length 邀请码长度
     * @return String
     */
    public static String generate(int length) {
        String inviteCode = null;

        // 判断长度是否合法
        if (MIN_LENGTH > length && length > MAX_LENGTH) {
            return inviteCode;
        }



        return inviteCode;
    }
}

/*
 * Copyright (c) 2018 by fitt.inc All rights reserved
 */
package com.fitt.gbt.qbank;

import com.fitt.gbt.qbank.common.utils.ShareCodeUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : <a href="mailto:congchun.zcc@gmail.com">congchun.zcc</a>
 * @version : 1.0.0
 * @description : RC4 测试
 * @since : 2018/11/14
 */
public class RC4Test {
    public static void main(String[] args) {
        testShareCodeUtil();
    }

    private static void testShareCodeUtil() {
        Set<String> codeSet = new HashSet<String>();
        long start = System.currentTimeMillis();

        // share code size: 10000000 , cost time: 56656
        // share code size: 5000000 , cost time: 14461
        for (long i = 1L; i <= 10000000L; i++) {
            String code = ShareCodeUtil.idToCode(i);
            //System.out.println(ShareCodeUtil.codeToId(code));
            codeSet.add(code);
        }
        long end = System.currentTimeMillis();
        System.out.println("share code size: " + codeSet.size() + " , cost time: " + (end - start));
    }

}

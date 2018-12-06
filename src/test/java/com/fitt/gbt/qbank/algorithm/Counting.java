/*
 * Copyright (c) 2018 by Alibaba.inc All rights reserved
 */
package com.fitt.gbt.qbank.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : <a href="mailto:congchun.zheng@gmail.com">congchun.zcc</a>
 * @version : 1.0.0
 * @description : 数数算法: 25个人数数, 500以内数到以7结尾的数据的人
 * @since : 2018/12/05
 */
public class Counting {
    /**
     * @param maxNumber 最大数
     * @param flyNumber 飞越数
     * @param personSize 人数
     */
    private static void counting(int maxNumber, int flyNumber, int personSize) {
        List<Integer> hitList = new ArrayList<>();

        int count = 0;
        for (int i = flyNumber; i < maxNumber; i += 10) {
            int hitNo = i;
            if (i > personSize) {
                hitNo = i % personSize;
            }
            hitList.add(hitNo);
            System.out.println("数字: " + i + ", 被第 " + hitNo + " 个人命中");
            count++;
        }
        System.out.println("计算次数: " + count + ", 中奖人编号: " + JSON.toJSONString(hitList));

        Map<Integer, Long> result = hitList.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        System.out.println("中奖人命中次数:" + JSON.toJSONString(result));
    }

    public static void main(String[] args) {
        System.out.println(10<<1);
        counting(500, 7,25);
    }
}

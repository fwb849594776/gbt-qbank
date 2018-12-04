/*
 * Copyright (c) 2018 by Fitt.inc All rights reserved
 */
package com.fitt.gbt.qbank.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : <a href="mailto:congchun.zheng@gmail.com">congchun.zheng</a>
 * @version : 1.0.0
 * @description : 短信工具类
 * @since : 2018/12/04
 */
public class SmsUtil {
    private static final Logger logger = LoggerFactory.getLogger(SmsUtil.class);

    private static final String softVersion = "2013-12-26";
    private static final String accountSid = "";
    private static final String authToken = "";
    private static final String appID = "";
    private static String login_url = "https://app.cloopen.com:8883/" + softVersion + "/Accounts/" + accountSid + "/SMS/TemplateSMS?sig=";

    public static void sendSms(String content, String tos) {
        sendSms(content, tos, "11111");
    }

    public static String sendSms(String content, String tos, String templateId) {
        try {
            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            String dateStr = format.format(date);
            String sig = MD5Util.MD5(accountSid + authToken + dateStr).toUpperCase();
            logger.info("send() sig={}", sig);

            String postUrl = login_url + sig;
            logger.info("send() postUrl={}", postUrl);

            String authorization = EncodeUtil.encodeStr(accountSid + ":" + dateStr);
            logger.info("send() authorization={}", authorization);

            String jsonStr = getPostContent(tos, templateId, content);
            logger.info("send() params={}", jsonStr);
            String result = HttpRequest.post(postUrl, jsonStr, authorization);
            logger.info("send() send return result={}", result);

            return result;
        } catch (Exception e) {
            logger.error("send() occurred error!", e);
        }
        return null;
    }

    private static String getPostContent(String tos, String templateId, String content) {
        StringBuilder params = new StringBuilder();
        params.append("{")
            .append("\"to\":\"").append(tos).append("\",")
            .append("\"appId\":\"").append(appID).append("\",")
            .append("\"templateId\":\"").append(templateId).append("\",")
            .append("\"datas\":[\"").append(content).append("\"]")
            .append("}");

        return params.toString();
    }
}

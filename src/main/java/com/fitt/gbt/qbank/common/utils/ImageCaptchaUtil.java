/*
 * Copyright (c) 2018 by Fitt.inc All rights reserved
 */
package com.fitt.gbt.qbank.common.utils;

import com.asprise.ocr.Ocr;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpMethod;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author : <a href="mailto:congchun.zheng@gmail.com.com">congchun.zcc</a>
 * @version : 1.0.0
 * @description : 图片验证码识别工具类
 * @since : 2018/11/29
 */
public class ImageCaptchaUtil {

    public static final String imageDir = "D:\\workspace_self\\gbt-qbank/images/";

    public static String readImage(String requestUrl) {
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection)url.openConnection();

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(HttpMethod.GET.name());

            httpUrlConn.connect();
            File fileDir = new File(imageDir);
            if (!fileDir.exists()) {
                fileDir.mkdir();
            }

            File image = new File(imageDir + System.currentTimeMillis() + ".jpg");
            InputStream inputStream = httpUrlConn.getInputStream();
            OutputStream out = new FileOutputStream(image);
            IOUtils.copy(inputStream, out);

            out.close();

            Ocr.setUp();
            Ocr ocr = new Ocr();
            ocr.startEngine("eng", Ocr.SPEED_FASTEST);

            String result = ocr.recognize(new File[] {image}, Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);
            System.out.println("Result: " + result);
            System.out.println("图片文字为:" + result.replace(",", "").replace("i", "1").replace(" ", "").replace("'",
                "").replace("o", "0").replace("O", "0").replace("g", "6").replace("B", "8").replace("s", "5")
                .replace("z", "2"));
            // ocr more images here ...
            ocr.stopEngine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        readImage(
            "http://www.gdhrss.gov.cn/gdweb/ImageCheck.jpg?d=Thu%20Nov%2029%202018%2009:57:00%20GMT+0800%20"
                + "(%E4%B8%AD%E5%9B%BD%E6%A0%87%E5%87%86%E6%97%B6%E9%97%B4)");
    }
}

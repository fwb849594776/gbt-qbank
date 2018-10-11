package com.fitt.gbt.qbank.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RecordCount {
    private static boolean flag = true;//是否结束查询的标识

    /**
     * @param args
     */
    public static void main(String[] args) {
        RecordCount rc = new RecordCount();
        //		rc.sendMailNotice("测试");
        //		JOptionPane.showMessageDialog(null, "dd", "有号了", JOptionPane.INFORMATION_MESSAGE);
        rc.startQuery(rc);
    }

    /**
     * 开始执行预约信息查询
     *
     * @param rc
     */
    private void startQuery(RecordCount rc) {
        int queryDay = 1;//从当天开始，只查询20天之内的信息
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date currDate = new Date();
        ;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currDate);
        int count = 0;
        String date = sdf.format(currDate);
        String recordResult = "";
        while (flag) {
            calendar.add(calendar.DAY_OF_MONTH, 1);
            if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && calendar.get(Calendar.DAY_OF_WEEK)
                != Calendar.SUNDAY) {
                date = sdf.format(calendar.getTime());
                recordResult = rc.getRecordCount(date);
                rc.isHaveCount(recordResult);
                //				System.out.println("ri qi:" +  sdf.format(calendar.getTime()));
            } else {
                continue;
            }

            if (queryDay == 19) {//从头开始查询
                //				if(queryDay==20){//从头开始查询
                queryDay = 1;
                calendar.setTime(currDate);
                try {
                    Thread.sleep(1000 * 30);
                } catch (Exception e) {
                    System.exit(0);//退出程序
                }
                //				rc.flag = false;
            } else {
                queryDay++;
            }
            System.out.println("查询次数:" + ++count);
        }

    }

    /**
     * 根据查询结果判断是否有号可以预约
     *
     * @param recordResult 系统预约查询结果
     */
    private void isHaveCount(String recordResult) {
        JSONObject jsStr = JSONObject.parseObject(recordResult);
        try {
            JSONArray mapArray = JSONArray.parseArray(jsStr.getString("Record"));
            JSONArray mapArray1 = JSONArray.parseArray(mapArray
                .getJSONObject(0).getString("TimeRecord"));
            //		System.out.println(mapArray1);
            //		System.out.println(mapArray.getJSONObject(0).get("YYDate"));
            for (int i = 0; i < mapArray1.size(); i++) {
                int count = mapArray1.getJSONObject(i).getInteger("Count");
                //				System.out.println("count - "+count);
                if ((i == 0 && count != 3) || (i == 3 && count != 3) || (i == 1 && count != 4) || (i == 4 && count != 4)
                    || (i == 2 && count != 5) || (i == 5 && count != 5)) {
                    String info = "日期:" + mapArray.getJSONObject(0).get("YYDate") + ",时间：" + mapArray1.getJSONObject(i)
                        .getString("Time") + " 有号";
                    JOptionPane.showMessageDialog(null, info, "有号了", JOptionPane.INFORMATION_MESSAGE);//桌面弹出
                    System.out.println(info);
                    // TODO 邮件通知
                    //sendMailNotice(info);
                    flag = false;//结束查询标识符
                }
            }
        } catch (Exception e) {
        }
    }

    /**
     * 获取预约记录
     *
     * @param date
     * @return
     */
    private String getRecordCount(String date) {
        try {
            String uri = "http://thzwb.thnet.gov.cn/getRecordCount.action?BizId=7008&date=" + date;
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("GET"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            br.close();
            connection.disconnect();

            //	            System.out.println(result.toString());
            return result.toString();
        } catch (Exception e) {
            try {
                System.out.println("程序异常，正在尝试重新查询");
                Thread.sleep(1000 * 60);//如果出现异常，一分钟后再次运行
                RecordCount rc = new RecordCount();
                rc.startQuery(rc);
            } catch (Exception e1) {
                System.exit(0);//退出程序
            }
        }
        return "";
    }
}

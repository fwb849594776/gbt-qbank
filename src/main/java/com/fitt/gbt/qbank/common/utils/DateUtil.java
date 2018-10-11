
package com.fitt.gbt.qbank.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 日期相关工具类
 */
public class DateUtil {
    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

    public static final String FULL_SDM_MILL = "yyyy-MM-dd HH:mm:ss.SSS";

    public static final String FULL_SDM = "yyyy-MM-dd HH:mm:ss";

    public static final String YYYYMMDD_MID_LINE = "yyyy-MM-dd";

    public static final String DD = "dd";

    public static final String DD_HH = "dd_HH";

    public static final String HH_MM = "HH:mm";

    public static final String YYYYMMDD_HH_MM = "yyyy-MM-dd HH:mm";

    public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";

    public static final String YYYYMMDD = "yyyyMMdd";

    public static final String POINT_DATE_MODE = "yyyy.MM.dd HH:mm";

    /**
     * 取得表示当天的时间对。
     *
     * @return
     */
    public static Date getCurrentDay() {

        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);
        ca.set(Calendar.MILLISECOND, 0);

        return ca.getTime();
    }

    /**
     * 解析简单格式的日期字符。
     *
     * @param simpleDateStr
     * @return
     */
    public static Date parseStrToDate(String simpleDateStr) {
        return parseStrToDate(simpleDateStr, FULL_SDM);
    }

    /**
     * 获取当前时间字符串
     *
     * @return
     */
    public static String getCurrentDateString() {
        Date now = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FULL_SDM);
        return sdf.format(now);
    }

    /**
     * 获取当前时间字符串
     *
     * @return
     */
    public static String getCurrentDateString(String dateFormat) {
        Date now = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(now);
    }

    /**
     * 解析简单格式的日期字符。
     *
     * @param simpleDateStr
     * @param format
     * @return
     */
    public static Date parseStrToDate(String simpleDateStr, String format) {
        if (StringUtils.isEmpty(simpleDateStr)) {
            return null;
        }
        try {
            return new SimpleDateFormat(format).parse(simpleDateStr);
        } catch (ParseException e) {
            logger.warn("转换异常[{}], 不是[{}]的格式.", simpleDateStr, FULL_SDM);
            return null;
        }
    }

    /**
     * 将Date转化成long的秒。
     *
     * @param date
     * @return
     */

    public static Integer parseDateToInt(Date date) {
        if (date == null) {
            return 0;
        }
        return (int)(date.getTime() / 1000);
    }

    /**
     * 将字符串日期转化成int。
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static Integer parseDateToInt(String dateStr, String format) {
        Date date = parseStrToDate(dateStr, format);
        return parseDateToInt(date);
    }

    /**
     * 返回当前时间的int值。
     *
     * @return
     */
    public static Integer parseNowToInt() {
        return (int)(System.currentTimeMillis() / 1000);
    }

    /**
     * 获取当前时间以小时为单位的int值
     *
     * @return
     */
    public static Integer getCurrentHourToInt() {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int today = getCurrentDayToInt();
        return today + hour * 60 * 60;
    }

    /**
     * 获取当前时间以天为单位的int值
     *
     * @return
     */
    public static Integer getCurrentDayToInt() {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYYMMDD_MID_LINE);
        String date = sdf.format(new Date());
        return DateUtil.parseDateToInt(date, YYYYMMDD_MID_LINE);
    }

    /**
     * 校验日期格式是否符合要求
     *
     * @param date   日期
     * @param format 校验的格。
     * @return
     */
    public static boolean checkFormat(String date, String format) {
        String regex = "";
        if (FULL_SDM.equals(format)) {
            regex = "^(\\d{4})-([0-1]\\d)-([0-3]\\d)\\s([0-5]\\d):([0-5]\\d):([0-5]\\d)$";
        } else if (YYYYMMDD_MID_LINE.equals(format)) {
            regex = "^(\\d{4})-([0-1]\\d)-([0-3]\\d)$";
        } else {
            logger.warn("未知的日期格式");
            return Boolean.TRUE;
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(date);
        while (m.find()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * 以某种格式格式化当前时间
     *
     * @param sdm
     * @return
     */
    public static String parseNow2Str(String sdm) {
        return new SimpleDateFormat(sdm).format(new Date());
    }

    /**
     * 将整数值的时间转换成指定格式的字符串
     *
     * @param sdm
     * @param intTime
     * @return
     */
    public static String parseIntToStr(String sdm, int intTime) {
        Date date = new Date();
        date.setTime(Long.valueOf(intTime) * 1000);
        return new SimpleDateFormat(sdm).format(date);
    }

    /**
     * 将字符串转换为指定的日期格式
     *
     * @param date
     * @param format
     * @return
     */
    public static Date formatStrToDate(String date, String format) {

        try {
            return getFormatter(format).parse(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取日期格式化对
     *
     * @param format
     * @return
     */
    private static SimpleDateFormat getFormatter(String format) {
        return new SimpleDateFormat(format);
    }

    /**
     * 判定当前时间是否在参数的2个时间之</br> 判定是begin<=当前, 当前<=end;</br> 精确到分秒</br>
     *
     * @param beginTime 必须是HH:mm格式
     * @param endTime   必须是HH:mm格式
     * @return
     */
    public static boolean isCurrentInner(String beginTime, String endTime) {
        Date beginDate
            = DateUtil.formatStrToDate(DateUtil.parseNow2Str(YYYYMMDD_MID_LINE) + " " + beginTime, YYYYMMDD_HH_MM);
        Date endDate
            = DateUtil.formatStrToDate(DateUtil.parseNow2Str(YYYYMMDD_MID_LINE) + " " + endTime, YYYYMMDD_HH_MM);
        Date now = new Date();

        // 转换为数�
        if (beginDate.getTime() <= now.getTime() && now.getTime() <= endDate.getTime()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 将时间按格式转换为字符串，日期为空时转换为空字符。
     *
     * @param date
     * @param patten
     * @return
     */
    public static String formatDateToString(Date date, String patten) {
        if (null == date) {
            return "";
        }
        SimpleDateFormat sd = new SimpleDateFormat(patten);
        return sd.format(date);
    }

    /**
     * Date转换成String
     *
     * @param timeMillis 日期
     * @param dateFormat 日期格式
     * @return 字符串
     */
    public static String formatDateToString(Long timeMillis, String dateFormat) {
        if (timeMillis == null) {
            return null;
        }
        Date date = new Date(timeMillis);
        DateFormat df = new SimpleDateFormat(dateFormat);
        return df.format(date);
    }

    /**
     * Date转换成String
     *
     * @param unixTime   日期
     * @param dateFormat 日期格式
     * @return 字符串
     */
    public static String formatUnixTimeToString(Integer unixTime, String dateFormat) {
        if (unixTime == null) {
            return null;
        }
        long milTime = Long.valueOf(unixTime) * 1000;
        Date date = new Date(milTime);
        DateFormat df = new SimpleDateFormat(dateFormat);
        return df.format(date);
    }

    /**
     * 秒开始的时间戳， 转换为某个格式
     *
     * @param date
     * @param format
     * @return
     */
    public static String fromSQL(Integer date, String format) {
        if (null == date || date <= 0) {
            return null;
        }
        long dtl = Long.parseLong(date + "") * 1000;
        return new SimpleDateFormat(format).format(dtl);
    }

    /**
     * 避免精度丢失
     *
     * @param date
     * @param format
     * @return
     */
    public static String fromLong(Long date, String format) {
        if (null == date || date <= 0) {
            return null;
        }
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 将天数转化为秒数，内部统一单位计算
     *
     * @param day 带转化的天数
     * @return 天数转化为的秒数
     */
    public static Integer parseDayToSeconds(Integer day) {
        if (day == null || day <= 0) {
            return 0;
        }
        return day * 86400;
    }

    /**
     * 获取当天开始时间点
     *
     * @return
     */
    public static Date getCurrentDayStart() {
        Calendar currentDate = new GregorianCalendar();
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        return currentDate.getTime();
    }

    /**
     * 获取明天开始时间点
     *
     * @return
     */
    public static Date getTomDayStart() {
        Calendar currentDate = new GregorianCalendar();
        currentDate.add(Calendar.DATE, 1);
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        return currentDate.getTime();
    }

    /**
     * 获取当周的周一
     *
     * @return
     */
    public static Date getCurrentWeekStart() {
        Calendar currentDate = new GregorianCalendar();
        currentDate.set(Calendar.DAY_OF_WEEK, 2);
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        return currentDate.getTime();
    }

    /**
     * 获取当周的周日
     *
     * @return
     */
    public static Date getCurrentWeekEnd() {
        Calendar currentDate = new GregorianCalendar();
        currentDate.set(Calendar.DAY_OF_WEEK, 7);
        currentDate.add(Calendar.DATE, 1);
        currentDate.set(Calendar.HOUR_OF_DAY, 23);
        currentDate.set(Calendar.MINUTE, 59);
        currentDate.set(Calendar.SECOND, 59);
        return currentDate.getTime();
    }

    /**
     * 获取当天结束时间点
     *
     * @return
     */
    public static Date getCurrentDayEnd() {
        Calendar currentDate = new GregorianCalendar();
        currentDate.set(Calendar.HOUR_OF_DAY, 23);
        currentDate.set(Calendar.MINUTE, 59);
        currentDate.set(Calendar.SECOND, 59);
        return currentDate.getTime();
    }

    /**
     * 获取明天结束时间点
     *
     * @return
     */
    public static Date getTomDayEnd() {
        Calendar currentDate = new GregorianCalendar();
        currentDate.add(Calendar.DATE, 1);
        currentDate.set(Calendar.HOUR_OF_DAY, 23);
        currentDate.set(Calendar.MINUTE, 59);
        currentDate.set(Calendar.SECOND, 59);
        return currentDate.getTime();
    }

    /**
     * 增加/减少分钟
     *
     * @param date
     * @param minutes
     * @return
     */
    public static Date addMinute(Date date, int minutes) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, minutes);
        return c.getTime();
    }

    /**
     * 增加/减少天数
     *
     * @param day 整数位加，负数为减
     * @return
     */
    public static Date addDay(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_YEAR, day);
        return c.getTime();
    }

    /**
     * 返回当天前day的unix时间戳，如当天前7天的时间戳戳
     *
     * @param day
     * @return
     */
    public static Integer beforeCurrentDay(int day) {
        Date now = getCurrentDayStart();
        Date newDate = addDay(now, -1 * day);
        return parseDateToInt(newDate);
    }

    public static int getMinute(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MINUTE);
    }

    public static Date setMinute(Date date, int minute) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 获取距离今天结束还有多少秒
     *
     * @return
     */
    public static int getLeftSecondToday() {
        Calendar currentDate = new GregorianCalendar();
        currentDate.set(Calendar.HOUR_OF_DAY, 23);
        currentDate.set(Calendar.MINUTE, 59);
        currentDate.set(Calendar.SECOND, 59);

        int leftSecond = (int)((currentDate.getTimeInMillis() - System.currentTimeMillis()) / 1000);

        return leftSecond;
    }

    /**
     * 获取几秒前的时间点
     *
     * @param seconds
     * @return
     */
    public static Date getDateBeforeSecond(int seconds) {
        Date date = new Date();
        date.setTime(System.currentTimeMillis() - seconds * 1000);
        return date;
    }

    public static Integer toUinxTime(String dateStr) {
        Date date = formatStrToDate(dateStr, "yyyy-MM-dd HH:mm:ss");
        if (date == null) {
            return 0;
        }
        return Long.valueOf(date.getTime() / 1000).intValue();
    }

    public static Integer toUinxTime(String dateStr, String dateFormat) {
        Date date = formatStrToDate(dateStr, dateFormat);
        if (date == null) {
            return 0;
        }
        return Long.valueOf(date.getTime() / 1000).intValue();
    }

    /**
     * 判断日期是否在当天内
     *
     * @param date
     * @return
     */
    public static boolean isToday(Date date) {
        if (date == null) {
            return false;
        }
        long time = date.getTime();
        Date todayEnd = getCurrentDayEnd();
        long todayEndTime = todayEnd.getTime();
        Date todayStart = getCurrentDayStart();
        long todayStartTime = todayStart.getTime();
        if (time >= todayStartTime && time <= todayEndTime) {
            return true;
        }
        return false;
    }

}

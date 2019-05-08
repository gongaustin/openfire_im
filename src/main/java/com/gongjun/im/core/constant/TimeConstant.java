package com.gongjun.im.core.constant;

/**
 * @Description:
 * @Author:GongJun
 * @Date:2019/1/18
 */
public interface TimeConstant {
    //eg:2019-01-18 18:18:18
    final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    //eg:2019-01-18
    final String DATE_FORMAT = "yyyy-MM-dd";
    //eg:18:18:18
    final String TIME_format = "HH:mm:ss";
    //时区
    final String TIME_ZONE = "GMT+8";
    //一天的毫秒数
    final int DAY_MILLIS = 24 * 60 * 60 * 1000;
    //一小时的毫秒数
    final int HOUR_MILLIS = 60 * 60 * 1000;
}

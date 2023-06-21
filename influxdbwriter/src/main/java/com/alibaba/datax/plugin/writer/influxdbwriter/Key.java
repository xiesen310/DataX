package com.alibaba.datax.plugin.writer.influxdbwriter;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author cw
 * @date : 2022/12/7
 * @description: key
 * @email: smallmartial@qq.com
 */
public class Key {

    public static final String ENDPOINT = "endpoint";
    public static final String COLUMN = "column";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String DATABASE = "database";
    public static final String TABLE = "table";
    public static final String QUERY_SQL = "querySql";
    public static final String PRE_SQL = "preSql";
    public static final String POST_SQL = "postSql";
    public static final String CONNECTION = "connection";
    public static final String BATCH_SIZE = "batch_size";
    public static final String NORM_DATE_PATTERN = "yyyy-MM-dd";
    public static final String NORM_TIME_PATTERN = "HH:mm:ss";
    public static final String NORM_DATETIME_MINUTE_PATTERN = "yyyy-MM-dd HH:mm";
    public static final String NORM_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String NORM_DATETIME_MS_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String CHINESE_DATE_PATTERN = "yyyy年MM月dd日";
    public static final String PURE_DATE_PATTERN = "yyyyMMdd";
    public static final String PURE_TIME_PATTERN = "HHmmss";
    public static final String PURE_DATETIME_PATTERN = "yyyyMMddHHmmss";
    public static final String PURE_DATETIME_MS_PATTERN = "yyyyMMddHHmmssSSS";
    public static final String HTTP_DATETIME_PATTERN = "EEE, dd MMM yyyy HH:mm:ss z";
    public static final String JDK_DATETIME_PATTERN = "EEE MMM dd HH:mm:ss zzz yyyy";
    public static final String UTC_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final String UTC_WITH_ZONE_OFFSET_PATTERN = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final String UTC_MS_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String UTC_MS_WITH_ZONE_OFFSET_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

    public static final String[] DatePattern = new String[]{NORM_DATE_PATTERN, NORM_DATETIME_MINUTE_PATTERN,
            NORM_DATETIME_PATTERN, NORM_DATETIME_MS_PATTERN, CHINESE_DATE_PATTERN, PURE_DATE_PATTERN, PURE_DATETIME_PATTERN,
            PURE_DATETIME_MS_PATTERN, HTTP_DATETIME_PATTERN, JDK_DATETIME_PATTERN, UTC_PATTERN, UTC_WITH_ZONE_OFFSET_PATTERN,
            UTC_MS_PATTERN, UTC_MS_WITH_ZONE_OFFSET_PATTERN};
}

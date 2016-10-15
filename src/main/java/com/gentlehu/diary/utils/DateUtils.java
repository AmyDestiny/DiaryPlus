package com.gentlehu.diary.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static SimpleDateFormat sdf = null;
    private static SimpleDateFormat sdf1 = null;

    public static String format(Date date){
        if(sdf == null) sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
    /**
     * 获得日期的月和日
     * @param date
     * @return
     */
    public static String getMD(Date date){
        if(sdf1 == null) sdf1 = new SimpleDateFormat("MM月dd日");
        return sdf1.format(date);
    }
}
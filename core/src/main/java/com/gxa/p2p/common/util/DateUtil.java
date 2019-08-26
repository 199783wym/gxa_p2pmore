package com.gxa.p2p.common.util;

import org.apache.commons.lang.time.DateUtils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    /**
     * 得到一天的最后一秒钟
     *
     * @param date
     * @return
     */
    public static Date endOfDay(Date date) {
        return DateUtils.addSeconds(
                DateUtils.addDays(
                        DateUtils.truncate(date, Calendar.DATE), 1), -1);
    }

    /**
     * 两个时间的间隔秒
     *
     * @return
     */
    public static long secondsBetween(Date d1, Date d2) {

        return Math.abs((d1.getTime() - d2.getTime()) / 1000);
    }

    public static long getBetweenSecond(Date sendTime, Date date) {
        return Math.abs((sendTime.getTime() - date.getTime()) / 1000);

    }
}
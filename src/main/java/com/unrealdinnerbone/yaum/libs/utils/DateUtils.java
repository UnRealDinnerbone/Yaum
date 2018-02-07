package com.unrealdinnerbone.yaum.libs.utils;

import com.unrealdinnerbone.yaum.Yaum;

import java.util.Calendar;

public class DateUtils {

    public static void checkDates() {
        if(isToday(1, 1) || isToday(12, 31)) {
            Yaum.getLogHelper().info("Happy New Year");
        }else if(isToday(4, 1))        {
            Yaum.getLogHelper().info("Happy April Fools Day");
        }else if(isToday(10, 31)) {
            Yaum.getLogHelper().info("Happy Halloween");
        }else if(isToday(12, 24) || isToday(12, 25)) {
            Yaum.getLogHelper().info("Merry Christmas");
        }else {
            Yaum.getLogHelper().info(":( Today is not a Holiday");
        }

    }

    public static boolean isToday(int m, int d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return calendar.get(Calendar.MONTH) == --m && calendar.get(Calendar.DATE) == d;
    }

}

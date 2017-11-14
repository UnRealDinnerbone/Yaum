package com.unrealdinnerbone.yaum.libs.utils;

import com.unrealdinnerbone.yaum.yaum;

import java.util.Calendar;

public class DateUtils {

    public static void checkDates() {

        if(isToday(1, 1) || isToday(12, 31)) {
            yaum.getLogHelper().info("Happy New Year");
        }else if(isToday(4, 1))        {
            yaum.getLogHelper().info("Happy April Fools Day");
        }else if(isToday(10, 31)) {
            yaum.getLogHelper().info("Happy Halloween");
        }else if(isToday(12, 24) || isToday(12, 25)) {
            yaum.getLogHelper().info("Merry Christmas");
        }else {
            yaum.getLogHelper().info(":( Today is not a Holiday");
        }

    }


    public static boolean isToday(int m, int d)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        if(calendar.get(Calendar.MONTH) == --m && calendar.get(Calendar.DATE) == d) {
            return true;
        }else {
            return false;
        }
    }

}

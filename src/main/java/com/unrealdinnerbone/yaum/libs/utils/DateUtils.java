package com.unrealdinnerbone.yaum.libs.utils;

import com.unrealdinnerbone.yaum.yaum;

import java.util.Calendar;

public class HolidayUtils {

    public static Boolean isNewYears = false;
    public static Boolean isAprilFirst = false;
    public static Boolean isHalloween = false;
    public static Boolean isChristmas = false;

    public static void checkDates() {

        dateChecker();
        if (isNewYears) {
            yaum.getLogHelper().info("Happy New Year");
        } else if (isAprilFirst) {
            yaum.getLogHelper().info("Happy April Fools Day");
        } else if (isHalloween) {
            yaum.getLogHelper().info("Happy Halloween");
        } else if (isChristmas) {
            yaum.getLogHelper().info("Merry Christmas");
        } else {
            yaum.getLogHelper().info(":( Today is not a Holiday");
        }

    }


    public static boolean isToday()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        if(calendar.get(2))
    }



    public static void dateChecker() {



        switch (calendar.get(2)) {
            case 0: {
                if (calendar.get(5) == 1) {
                    isNewYears = true;
                }
                break;
            }
            case 3: {
                if (calendar.get(5) == 1) {
                    isAprilFirst = true;
                }
                break;
            }
            case 9: {
                if (calendar.get(5) == 31) {
                    isHalloween = true;
                }
                break;
            }
            case 11: {
                if (calendar.get(5) == 25) {
                    isChristmas = true;
                }
                break;
            }
        }
    }
}

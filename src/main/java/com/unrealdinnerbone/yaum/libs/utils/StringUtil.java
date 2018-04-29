package com.unrealdinnerbone.yaum.libs.utils;

import java.util.List;

public class StringUtil
{
    public static <T> T getNextObjectForList(List<T> list, T currentString) {
        boolean isNext = false;
        for (T entry : list) {
            if (isNext) {
                return entry;
            }
            if (entry.equals(currentString)) {
                isNext = true;
            }
        }
        return list.stream().findFirst().get();
    }

    public static String format(String msg, Object... replacements) {
        if (replacements.length > 0) {
            for (int i = 0; i < replacements.length; i++) {
                msg = msg.contains("{" + i + "}") ? msg.replace("{" + i + "}", replacements[i].toString()) : msg.replace("{" + i + "}", "");
            }
        }
        return msg;
    }

}

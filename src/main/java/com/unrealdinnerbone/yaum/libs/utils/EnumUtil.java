package com.unrealdinnerbone.yaum.libs.utils;

import com.unrealdinnerbone.yaum.libs.helpers.MathHelper;

public class EnumUtil
{
    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = MathHelper.getRandom().nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}

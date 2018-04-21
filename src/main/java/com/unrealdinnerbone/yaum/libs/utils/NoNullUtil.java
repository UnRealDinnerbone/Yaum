package com.unrealdinnerbone.yaum.libs.utils;


import javax.annotation.Nonnull;

public class NoNullUtil
{
    @Nonnull
    public <T> T getObjectOrElseNotNull(T t, @Nonnull T t2) {
        return t != null ? t : t2;
    }

}

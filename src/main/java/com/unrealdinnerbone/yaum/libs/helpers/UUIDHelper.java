package com.unrealdinnerbone.yaum.libs.helpers;

import java.util.UUID;

public class UUIDHelper
{
    public static String makeUUIDSimpleLowercase(UUID uuid) {
        return uuid.toString().toLowerCase().replace("-", "");
    }
}

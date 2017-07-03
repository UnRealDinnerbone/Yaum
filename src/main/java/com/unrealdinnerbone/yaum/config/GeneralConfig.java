package com.unrealdinnerbone.yaum.config;

import net.minecraftforge.common.config.Configuration;

public class GeneralConfig
{
    public static Configuration generalConfig;

    public static void loadGeneralConfig() {
        generalConfig = ConfigManger.getGeneralConfig();
        generalConfig.setCategoryLanguageKey("loggers", "config.loggers");

        if (generalConfig.hasChanged()) {
            generalConfig.save();
        }
    }
}

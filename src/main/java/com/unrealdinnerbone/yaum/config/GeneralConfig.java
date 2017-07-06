package com.unrealdinnerbone.yaum.config;

import net.minecraftforge.common.config.Configuration;

public class GeneralConfig
{
    public static boolean suppoterChat;

    public static Configuration generalConfig;

    public static void loadGeneralConfig() {
        generalConfig = ConfigManger.getGeneralConfig();
        suppoterChat = generalConfig.getBoolean("supporterChat", "perks", true, "Enable Supporter fancy chat", "perks");
        if (generalConfig.hasChanged()) {
            generalConfig.save();
        }
    }
}

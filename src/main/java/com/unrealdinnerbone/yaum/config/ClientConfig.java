package com.unrealdinnerbone.yaum.config;

import net.minecraftforge.common.config.Configuration;

public class ClientConfig
{
    public static boolean capesEnabled;
    public static boolean elytraEnabled;
    public static Configuration clientConfig;

    public static void loadClientConfig() {
        clientConfig = ConfigManger.getClientConfig();
        clientConfig.setCategoryLanguageKey("perks", "config.perks");
        capesEnabled = clientConfig.getBoolean("capesEnabled", "perks", true, "Enable Supporter custom capes", "perks");
        elytraEnabled = clientConfig.getBoolean("elytraEnabled", "perks", true, "Enable Supporter custom elytra", "perks");

        if (clientConfig.hasChanged()) {
            clientConfig.save();
        }
    }

}

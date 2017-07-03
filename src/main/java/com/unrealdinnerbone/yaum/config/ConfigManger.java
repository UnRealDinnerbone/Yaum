package com.unrealdinnerbone.yaum.config;

import com.unrealdinnerbone.yaum.util.Reference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ConfigManger
{
    private static Configuration clientConfig;
    private static Configuration generalConfig;

    public static void init() {
        MinecraftForge.EVENT_BUS.register(new ConfigManger());
    }

    public static Configuration clientConfig(File configFile) {
        if (clientConfig == null) {
            clientConfig = new Configuration(configFile);
            ClientConfig.loadClientConfig();
        }
        return clientConfig;
    }
    public static Configuration generalConfig(File configFile) {
        if (generalConfig == null) {
            generalConfig = new Configuration(configFile);
            GeneralConfig.loadGeneralConfig();
        }
        return generalConfig;
    }


    public static void reloadConfigs() {
        ClientConfig.loadClientConfig();
        GeneralConfig.loadGeneralConfig();
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equalsIgnoreCase(Reference.MOD_ID)) {
            ConfigManager.sync(Reference.MOD_ID, Config.Type.INSTANCE);
            reloadConfigs();
        }
    }

    public static Configuration getClientConfig() {
        return clientConfig;
    }

    public static Configuration getGeneralConfig() {
        return generalConfig;
    }
}

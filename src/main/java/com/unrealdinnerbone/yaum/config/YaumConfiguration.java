package com.unrealdinnerbone.yaum.config;

import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class YaumConfiguration
{
    @Config(modid = Reference.MOD_ID, name = Reference.MOD_ID + "/client", category = "supporters")
    public static class ClientConfig {

        @Config.RequiresWorldRestart
        @Config.Comment("Do supports capes get rendered?")
        public static boolean capesEnabled = true;

        @Config.RequiresWorldRestart
        @Config.Comment("Do supports elytra get changed?")
        public static boolean elytraEnabled = true;

    }

    @Config(modid = Reference.MOD_ID, name = Reference.MOD_ID + "/general", category = "registering")
    public static class GeneralConfig {

        @Config.RequiresMcRestart
        @Config.Comment("Register the test item?")
        public static boolean testBlockEnabled = true;

        @Config.RequiresMcRestart
        @Config.Comment("Register the test block?")
        public static boolean testItemEnabled = true;


        @Config.Comment("Can Supporters use colors in their chat messages")
        public static boolean supporterChat = true;

    }


    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(Reference.MOD_ID)) {
            ConfigManager.sync(Reference.MOD_ID, Config.Type.INSTANCE);
        }
    }


}

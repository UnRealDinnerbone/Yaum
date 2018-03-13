package com.unrealdinnerbone.yaum.config;

import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraftforge.common.config.Config;

@Config(modid = Reference.MOD_ID, category = "client")
@Config.LangKey("yarm.config.client")
public class ConfigClient
{
    @Config.LangKey("yaum.config.client.supporters")
    public static Supporters supporters = new Supporters();

    @Config.LangKey("yaum.config.client.supporters")
    public static class Supporters {

        @Config.RequiresWorldRestart
        @Config.Comment("Do supports capes get rendered?")
        public boolean capesEnabled = true;

        @Config.RequiresWorldRestart
        @Config.Comment("Do supports elytra get changed?")
        public boolean elytraEnabled = true;

    }

}

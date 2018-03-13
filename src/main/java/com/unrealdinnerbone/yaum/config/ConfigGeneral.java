package com.unrealdinnerbone.yaum.config;

import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraftforge.common.config.Config;

@Config(modid = Reference.MOD_ID)
@Config.LangKey("yarm.config.general")
public class ConfigGeneral
{
    @Config.LangKey("yaum.config.client.supporters")
    public static Supporters supporters = new Supporters();

    @Config.LangKey("yaum.config.general.test")
    public static Test test = new Test();

    @Config.LangKey("yaum.config.general.supporters")
    public static class Supporters {

        @Config.Comment("Can Supporters use colors in their chat messages")
        public boolean supporterChat = true;
    }

    @Config.LangKey("yaum.config.general.test")
    public static class Test {

        @Config.Comment("Test Block")
        public boolean testBlock = true;

        @Config.Comment("Test Block")
        public boolean testItem = true;

        @Config.Comment("Test Block")
        public boolean testEnchement = true;


    }


}

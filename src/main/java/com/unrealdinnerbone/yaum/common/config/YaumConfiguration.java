package com.unrealdinnerbone.yaum.common.config;

import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
@Config(modid = Reference.MOD_ID)
public class YaumConfiguration {

   public static ClientConfig clientConfig = new ClientConfig();
   public static GeneralConfig generalConfig = new GeneralConfig();

    public static class ClientConfig {

        public Supports supports = new Supports();
        public Tweaks tweaks = new Tweaks();

        public static class Supports {

            @Config.RequiresWorldRestart
            @Config.Comment("Do supports capes get rendered?")
            public boolean capesEnabled = true;


            @Config.RequiresWorldRestart
            @Config.Comment("Do supports elytra get changed?")
            public boolean elytraEnabled = true;


        }

        public static class Tweaks {

            @Config.Comment("Remove the recipe book")
            public boolean disableRecipeBook = true;

            @Config.RequiresMcRestart
            @Config.Comment("Change the texture of iron nugget")
            public boolean changeIronNuggetTexture = true;

        }

    }
    @Config(modid = Reference.MOD_ID + "/general", name = Reference.MOD_ID + ".registering")
    public static class GeneralConfig {

        public Supports supports = new Supports();

        public static class Supports {

            @Config.Comment("Can Supporters use colors in their chat messages")
            public boolean supporterChat = true;
        }

    }


    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(Reference.MOD_ID)) {
            ConfigManager.sync(Reference.MOD_ID, Config.Type.INSTANCE);
        }
    }

}

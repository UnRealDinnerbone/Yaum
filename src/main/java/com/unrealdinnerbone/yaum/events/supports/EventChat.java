package com.unrealdinnerbone.yaum.events.supports;

import com.unrealdinnerbone.yaum.config.ConfigGeneral;
import com.unrealdinnerbone.yaum.libs.Reference;
import com.unrealdinnerbone.yaum.perks.StatsGetter;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EventChat {

    @SubscribeEvent
    public static void onChat(ServerChatEvent event) {
        if (ConfigGeneral.supporters.supporterChat) {
            if (StatsGetter.isSupporter(event.getPlayer())) {
                if(StatsGetter.getSupporter(event.getPlayer().getUniqueID()).hasFancyChat()) {
                    TextComponentString textComponents = new TextComponentString("<" + event.getPlayer().getDisplayName().getFormattedText() + "> " + ColorUtil.format(event.getMessage()));
                    event.setComponent(textComponents);
                }
            }
        }
    }
}

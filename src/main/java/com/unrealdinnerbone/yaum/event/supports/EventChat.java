package com.unrealdinnerbone.yaum.event.supports;

import com.unrealdinnerbone.yaum.config.YaumConfiguration;
import com.unrealdinnerbone.yaum.libs.Reference;
import com.unrealdinnerbone.yaum.libs.utils.ColorUtil;
import com.unrealdinnerbone.yaum.perks.StatsGetter;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.SERVER)
@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Side.SERVER)
public class EventChat {

    @SubscribeEvent
    public static void onChat(ServerChatEvent event) {
        if (YaumConfiguration.GeneralConfig.General.supporterChat) {
            if (StatsGetter.isSupporter(event.getPlayer())) {
                if (StatsGetter.getSupporter(event.getPlayer()).hasFancyChat()) {
                    event.setComponent(new TextComponentString("<" + event.getUsername() + "> " + ColorUtil.format(event.getMessage())));
                }
            }
        }
    }
}

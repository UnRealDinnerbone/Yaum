package com.unrealdinnerbone.yaum.events.supports;

import com.unrealdinnerbone.yaum.config.GeneralConfig;
import com.unrealdinnerbone.yaum.perks.StatsGetter;
import com.unrealdinnerbone.yaum.util.ColorUtil;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventChat
{
    @SubscribeEvent
    public void onChat(ServerChatEvent event)
        {
            if(GeneralConfig.suppoterChat) {
                String msg = event.getMessage();
                if (StatsGetter.isSupporter(event.getPlayer())) {
                    msg = ColorUtil.format(msg);
                    event.setComponent(new TextComponentString(msg));
                }
            }
        }
    }

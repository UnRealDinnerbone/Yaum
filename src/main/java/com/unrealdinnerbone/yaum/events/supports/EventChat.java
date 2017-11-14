package com.unrealdinnerbone.yaum.events.supports;

import com.unrealdinnerbone.yaum.config.YaumConfiguration;
import com.unrealdinnerbone.yaum.libs.Reference;
import com.unrealdinnerbone.yaum.perks.StatsGetter;
import com.unrealdinnerbone.yaum.libs.utils.ColorUtil;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Side.SERVER)
@SideOnly(Side.SERVER)
public class EventChat
{
    @SubscribeEvent
    public static void onChat(ServerChatEvent event)
        {
            if(YaumConfiguration.GeneralConfig.supporterChat) {
                String msg = event.getMessage();
                if (StatsGetter.isSupporter(event.getPlayer())) {
                    msg = ColorUtil.format(msg);
                    event.setComponent(new TextComponentString("<" + event.getUsername()  + ">" + msg));
                }
            }
        }
    }

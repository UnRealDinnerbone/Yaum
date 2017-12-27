package com.unrealdinnerbone.yaum.client.event.rendering;

import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Side.CLIENT)
@SideOnly(Side.CLIENT)
public class EventPlayerRender
{

    @SubscribeEvent
    public static void onPlayerRenderEvent(RenderPlayerEvent.Specials.Pre event) {
            event.setRenderCape(false);
    }

}

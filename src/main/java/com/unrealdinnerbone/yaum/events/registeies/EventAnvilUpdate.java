package com.unrealdinnerbone.yarm.common.events;

import com.unrealdinnerbone.yarm.util.Reference;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EventAnvilUpdate
{
    @SubscribeEvent
    public static void anvilUpdate(AnvilUpdateEvent event) {

    }

}

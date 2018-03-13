package com.unrealdinnerbone.yaum.events.test;

import com.unrealdinnerbone.yaum.api.events.EventYaumRegister;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EventRegisterTest
{
    @SubscribeEvent
    public void registerBlocks(EventYaumRegister<Block> eventYaumRegister) {
        eventYaumRegister.getRegister().re
    }
}

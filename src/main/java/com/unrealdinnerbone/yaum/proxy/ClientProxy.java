package com.unrealdinnerbone.yaum.proxy;

import com.unrealdinnerbone.yaum.events.supports.EventEntityJoinWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
    @Override
    public void onPreInt(FMLPreInitializationEvent event) {
        super.onPreInt(event);
        MinecraftForge.EVENT_BUS.register(new EventEntityJoinWorld());
    }

    @Override
    public void onInt(FMLInitializationEvent event) {
        super.onInt(event);
    }

    @Override
    public void onPostInt(FMLPostInitializationEvent event) {
        super.onPostInt(event);
    }
}
package com.unrealdinnerbone.yaum.proxy;

import com.unrealdinnerbone.yaum.compact.CompactManager;
import com.unrealdinnerbone.yaum.libs.utils.DateUtils;
import com.unrealdinnerbone.yaum.common.network.PacketHandler;
import com.unrealdinnerbone.yaum.common.perks.StatsGetter;
import com.unrealdinnerbone.yaum.common.refelction.ReflectionHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class CommonProxy implements IProxy
{
    @Override
    public void onPreInt(FMLPreInitializationEvent event) {
        ReflectionHandler.handleLoading(event.getAsmData());
        CompactManager.init();
        DateUtils.checkDates();
        StatsGetter.reload();
        PacketHandler.registerMessages();
    }

    @Override
    public void onServerStart(FMLServerStartingEvent event) {

    }
}

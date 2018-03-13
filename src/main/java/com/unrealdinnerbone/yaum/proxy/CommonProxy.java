package com.unrealdinnerbone.yaum.proxy;

import com.unrealdinnerbone.yaum.api.Registry;
import com.unrealdinnerbone.yaum.api.events.EventYaumRegister;
import com.unrealdinnerbone.yaum.compact.CompactManager;
import com.unrealdinnerbone.yaum.libs.utils.DateUtils;
import com.unrealdinnerbone.yaum.perks.StatsGetter;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy implements IProxy {

    @Override
    public void onPreInt(FMLPreInitializationEvent event) {
        CompactManager.init();
        DateUtils.checkDates();
        StatsGetter.initStats();
        EventYaumRegister j = new EventYaumRegister(Registry.getBlockRegister());
        MinecraftForge.EVENT_BUS.post(j);
    }
}
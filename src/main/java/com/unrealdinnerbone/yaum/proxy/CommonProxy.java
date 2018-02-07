package com.unrealdinnerbone.yaum.proxy;

import com.unrealdinnerbone.yaum.compact.CompactManager;
import com.unrealdinnerbone.yaum.libs.utils.DateUtils;
import com.unrealdinnerbone.yaum.perks.StatsGetter;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy implements IProxy
{
    @Override
    public void onPreInt(FMLPreInitializationEvent event) {
        CompactManager.init();
        DateUtils.checkDates();
        StatsGetter.initStats();
    }
}

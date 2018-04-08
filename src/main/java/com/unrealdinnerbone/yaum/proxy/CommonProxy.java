package com.unrealdinnerbone.yaum.proxy;

import com.unrealdinnerbone.yaum.compact.CompactManager;
import com.unrealdinnerbone.yaum.libs.utils.DateUtils;
import com.unrealdinnerbone.yaum.network.PacketHandler;
import com.unrealdinnerbone.yaum.perks.StatsGetter;
import com.unrealdinnerbone.yaum.refelction.ReflectionHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import sun.reflect.Reflection;

public class CommonProxy implements IProxy
{
    @Override
    public void onPreInt(FMLPreInitializationEvent event) {
        ReflectionHandler.handleLoading(event.getAsmData());
        CompactManager.init();
        DateUtils.checkDates();
        StatsGetter.initStats();
        PacketHandler.registerMessages();

    }
}

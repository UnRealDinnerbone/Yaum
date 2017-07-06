package com.unrealdinnerbone.yaum.proxy;

import com.unrealdinnerbone.yaum.block.YaumTestBlock;
import com.unrealdinnerbone.yaum.config.ConfigManger;
import com.unrealdinnerbone.yaum.events.supports.EventChat;
import com.unrealdinnerbone.yaum.events.supports.EventEntityJoinWorld;
import com.unrealdinnerbone.yaum.item.YaumTestItem;
import com.unrealdinnerbone.yaum.perks.StatsGetter;
import com.unrealdinnerbone.yaum.util.HolidayUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public abstract class CommonProxy implements IProxy
{
    @Override
    public void onPreInt(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new EventChat());
        StatsGetter.ReadPepsData();
        new YaumTestBlock();
        new YaumTestItem();
        HolidayUtils.checkDates();
        final File folder = new File(event.getModConfigurationDirectory(), "yaum");
        if (!folder.exists()) {
            folder.mkdir();
        }
        ConfigManger.init();
        ConfigManger.clientConfig(new File(folder, "client.cfg"));
        ConfigManger.generalConfig(new File(folder, "general.cfg"));
    }

    @Override
    public void onInt(FMLInitializationEvent event) {

    }

    @Override
    public void onPostInt(FMLPostInitializationEvent event) {

    }
}

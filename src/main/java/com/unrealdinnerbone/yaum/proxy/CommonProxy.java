package com.unrealdinnerbone.yaum.proxy;

import com.unrealdinnerbone.yaum.common.network.PacketHandler;
import com.unrealdinnerbone.yaum.common.perks.StatsGetter;
import com.unrealdinnerbone.yaum.common.refelction.ReflectionHandler;
import com.unrealdinnerbone.yaum.compact.CompactManager;
import com.unrealdinnerbone.yaum.libs.Reference;
import com.unrealdinnerbone.yaum.libs.utils.DateUtils;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy implements IProxy
{
    @Override
    public void onPreInt(FMLPreInitializationEvent event) {
        ConfigManager.sync(Reference.MOD_ID, Config.Type.INSTANCE);
        ReflectionHandler.handleLoading(event.getAsmData());
        CompactManager.init();
        DateUtils.checkDates();
        StatsGetter.reload();
        PacketHandler.registerMessages();
    }
}

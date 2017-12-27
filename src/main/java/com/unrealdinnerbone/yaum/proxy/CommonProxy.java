package com.unrealdinnerbone.yaum.proxy;

import com.unrealdinnerbone.yaum.Yaum;
import com.unrealdinnerbone.yaum.api.register.YaumRegistry;
import com.unrealdinnerbone.yaum.compact.CompactManager;
import com.unrealdinnerbone.yaum.libs.Reference;
import com.unrealdinnerbone.yaum.libs.utils.DateUtils;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy implements IProxy
{
    @Override
    public void onPreInt(FMLPreInitializationEvent event) {
        CompactManager.init();
        Yaum.yaumRegistry = new YaumRegistry(Reference.MOD_ID, event);
        DateUtils.checkDates();
//        StatsGetter.ReadPepsData();
    }
}

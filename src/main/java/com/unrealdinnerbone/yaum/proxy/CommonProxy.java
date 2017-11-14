package com.unrealdinnerbone.yaum.proxy;

import com.unrealdinnerbone.yaum.api.YaumRegistry;
import com.unrealdinnerbone.yaum.compact.CompactManager;
import com.unrealdinnerbone.yaum.libs.Reference;
import com.unrealdinnerbone.yaum.libs.helpers.LogHelper;
import com.unrealdinnerbone.yaum.perks.StatsGetter;
import com.unrealdinnerbone.yaum.libs.utils.DateUtils;
import com.unrealdinnerbone.yaum.yaum;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy implements IProxy
{
    @Override
    public void onPreInt(FMLPreInitializationEvent event) {
        CompactManager.init();
        yaum.logHelper = new LogHelper(Reference.MOD_ID);
        yaum.yaumRegistry = new YaumRegistry(Reference.MOD_ID, event);
        DateUtils.checkDates();
        StatsGetter.ReadPepsData();
    }
}

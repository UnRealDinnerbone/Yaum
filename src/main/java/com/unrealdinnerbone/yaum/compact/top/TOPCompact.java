package com.unrealdinnerbone.yaum.compact.top;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInterModComms;

public class TOPCompact
{
    public static void init()
    {
        if (Loader.isModLoaded("theoneprobe")) {
            FMLInterModComms.sendFunctionMessage("theoneprobe", "getTheOneProbe", "com.unrealdinnerbone.Yaum.compact.top.TOPGetter");
        }
    }
}

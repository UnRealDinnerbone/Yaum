package com.unrealdinnerbone.yaum.libs.utils;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;

public class ModUtils
{
    public static ModContainer getModContanier(String modID) {
        return FMLCommonHandler.instance().findContainerFor(modID);
    }

    public static boolean isModLoaded(String modID) {
        return Loader.isModLoaded(modID);
    }
}

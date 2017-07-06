package com.unrealdinnerbone.yaum.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public interface IProxy
{
    default void onPreInt(FMLPreInitializationEvent event) {}
    default void onInt(FMLInitializationEvent event) {}
    default void onPostInt(FMLPostInitializationEvent event) {}
    default void onServerStart() {}


}

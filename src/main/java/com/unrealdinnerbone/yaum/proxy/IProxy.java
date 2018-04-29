package com.unrealdinnerbone.yaum.proxy;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;

public interface IProxy
{
    default void onPreInt(FMLPreInitializationEvent event) {

    }
    default void onInt(FMLInitializationEvent event) {

    }
    default void onPostInt(FMLPostInitializationEvent event) {

    }
    default void onServerStart(FMLServerStartingEvent event) {

    }

    default Side getSide() {
        return FMLCommonHandler.instance().getSide();
    }

    default void displayGUIScreen(GuiScreen guiScreen) {

    }

    default void spawnParticle(int id, boolean shouldIgnoreRange, float x, float y, float z, float xSpeed, float ySpeed, float zSpeed, int dimID) {

    }





    }

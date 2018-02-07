package com.unrealdinnerbone.yaum.libs.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

import java.util.ArrayList;
import java.util.List;

public class ServerUtils {

    public static MinecraftServer getServer() {
        return FMLCommonHandler.instance().getMinecraftServerInstance();
    }

    public static Side getSide()
    {
        return FMLCommonHandler.instance().getSide();
    }

    public static boolean isServer() {
        return getSide() == Side.SERVER;
    }

    public static boolean isClient()
    {
        return getSide() == Side.CLIENT;
    }

    public static List<EntityPlayerMP> getOnlinePlayers() {
        return new ArrayList<>(ServerUtils.getServer().getPlayerList().getPlayers());
    }
}

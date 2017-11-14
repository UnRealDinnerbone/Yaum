package com.unrealdinnerbone.yaum.util;

import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;
import com.unrealdinnerbone.yaum.yaum;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PlayerUtils {
    private static final ExecutorService THREAD_POOL = new ThreadPoolExecutor(0, 2, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue());

    @SideOnly(Side.CLIENT)
    public static void makePlayerFancy(final AbstractClientPlayer player, final ResourceLocation cape, final ResourceLocation elytra) {

        THREAD_POOL.submit(() -> {
            try {
                Thread.sleep(100);
            } catch (final InterruptedException e) {
                yaum.getLogHelper().warn("There was and error with the texture thread pool");
                yaum.getLogHelper().warn(e.getMessage());
                return;
            }
            Minecraft.getMinecraft().addScheduledTask(() -> {
                changePlayerTexture(Type.CAPE, player, cape);
                changePlayerTexture(Type.ELYTRA, player, elytra);
            });
        });
    }

    @SideOnly(Side.CLIENT)
    public static void changePlayerTexture(Type type, EntityPlayer player, ResourceLocation texture) {
        NetworkPlayerInfo networkPlayer = Minecraft.getMinecraft().getConnection().getPlayerInfo(player.getUniqueID());
        if (networkPlayer != null) {
            if (texture != null) {
                try {
                    Map<Type, ResourceLocation> maps;
                    maps = Minecraft.getMinecraft().getConnection().getPlayerInfo(player.getUniqueID()).playerTextures;
                    maps.put(type, texture);
                } catch (Exception e) {
                    yaum.getLogHelper().warn("There was and error while trying change a player texture");
                    yaum.getLogHelper().warn(e.getMessage());
                }
            }
            return;
        }
        return;
    }
}
//    Field field = Minecraft.getMinecraft().getConnection().getPlayerInfo(player.getUniqueID()).getClass().getField("playerTextures");
//                    maps = (Map<Type, ResourceLocation>) field.get(Minecraft.getMinecraft().getConnection().getPlayerInfo(player.getUniqueID()));
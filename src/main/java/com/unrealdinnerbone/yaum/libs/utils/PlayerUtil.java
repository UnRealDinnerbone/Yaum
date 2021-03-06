package com.unrealdinnerbone.yaum.libs.utils;

import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;
import com.unrealdinnerbone.yaum.Yaum;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PlayerUtil {

    private static final ExecutorService THREAD_POOL = new ThreadPoolExecutor(0, 2, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue());

    @SideOnly(Side.CLIENT)
    public static void makePlayerFancy(Type type,  EntityPlayer player, ResourceLocation texture) {
        THREAD_POOL.submit(() -> {
            try {
                Thread.sleep(1000);
                Minecraft.getMinecraft().addScheduledTask(() -> changePlayerTexture(type, player, texture));
            } catch (final InterruptedException e) {
                Yaum.getInstance().getLogHelper().warn("There was and error with the texture thread pool");
                Yaum.getInstance().getLogHelper().warn(e.getMessage());
            }
        });
    }


    @SideOnly(Side.CLIENT)
    private static void changePlayerTexture(Type type, EntityPlayer player, ResourceLocation texture) {
        changePlayerTexture(type, player.getUniqueID(), texture);
    }

    @SideOnly(Side.CLIENT)
    private static void changePlayerTexture(Type type, UUID uuid, ResourceLocation texture) {
        NetworkPlayerInfo networkPlayer = Minecraft.getMinecraft().getConnection().getPlayerInfo(uuid);
        if (texture != null) {
            try {
                networkPlayer.playerTextures.put(type, texture);
            } catch (Exception e) {
                Yaum.getInstance().getLogHelper().warn("There was and error while trying change a player texture");
                Yaum.getInstance().getLogHelper().warn(e.getMessage());
            }
        }
    }

}
package com.unrealdinnerbone.yaum.events;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.unrealdinnerbone.yaum.config.ClientConfig;
import com.unrealdinnerbone.yaum.perks.StatsGetter;
import com.unrealdinnerbone.yaum.perks.Supporter;
import com.unrealdinnerbone.yaum.util.PlayerUtils;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EventEntityJoinWorld
{
    public static void init() {
        MinecraftForge.EVENT_BUS.register(new EventEntityJoinWorld());
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void entityJoinWorld(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof AbstractClientPlayer) {
            final AbstractClientPlayer player = (AbstractClientPlayer) event.getEntity();
            final Supporter data = StatsGetter.getSupporterData(player);
            if (data != null) {
                if (data.getsCape() && data.getElytra() && ClientConfig.elytraEnabled && ClientConfig.capesEnabled) {
                    PlayerUtils.makePlayerFancy(player, data.getCapeTexture(), data.getElytraTexture());
                } else if (data.getsCape() && ClientConfig.capesEnabled) {
                    PlayerUtils.changePlayerTexture(MinecraftProfileTexture.Type.CAPE, player, data.getCapeTexture());
                } else if (data.getElytra() && ClientConfig.elytraEnabled) {
                    PlayerUtils.changePlayerTexture(MinecraftProfileTexture.Type.ELYTRA, player, data.getElytraTexture());
                }
            }
        }
    }
}

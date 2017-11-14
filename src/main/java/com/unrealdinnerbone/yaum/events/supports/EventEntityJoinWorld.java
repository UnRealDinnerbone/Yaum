package com.unrealdinnerbone.yaum.events.supports;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.unrealdinnerbone.yaum.config.YaumConfiguration;
import com.unrealdinnerbone.yaum.libs.Reference;
import com.unrealdinnerbone.yaum.libs.utils.PlayerUtils;
import com.unrealdinnerbone.yaum.perks.StatsGetter;
import com.unrealdinnerbone.yaum.perks.Supporter;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.UUID;

import static com.mojang.authlib.minecraft.MinecraftProfileTexture.Type.CAPE;
import static com.mojang.authlib.minecraft.MinecraftProfileTexture.Type.ELYTRA;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Side.CLIENT)
@SideOnly(Side.CLIENT)
public class EventEntityJoinWorld
{


    @SubscribeEvent
    public static void entityJoinWorld(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof AbstractClientPlayer) {
            final AbstractClientPlayer player = (AbstractClientPlayer) event.getEntity();
            final Supporter supporter = StatsGetter.getSupporter(player);
            if (supporter != null) {
                if (supporter.hasCape() && supporter.hasElytra() && YaumConfiguration.ClientConfig.elytraEnabled && YaumConfiguration.ClientConfig.capesEnabled) {
                    PlayerUtils.makePlayerFancy(player, supporter.getCapeTexture(), supporter.getElytraTexture());
                } else if (supporter.hasCape() && YaumConfiguration.ClientConfig.capesEnabled) {
                    PlayerUtils.changePlayerTexture(MinecraftProfileTexture.Type.CAPE, player, supporter.getCapeTexture());
                } else if (supporter.hasElytra() && YaumConfiguration.ClientConfig.elytraEnabled) {
                    PlayerUtils.changePlayerTexture(MinecraftProfileTexture.Type.ELYTRA, player, supporter.getElytraTexture());
                }
            }
        }
    }
}

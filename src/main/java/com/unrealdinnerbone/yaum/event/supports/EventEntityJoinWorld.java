package com.unrealdinnerbone.yaum.event.supports;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.unrealdinnerbone.yaum.config.YaumConfiguration;
import com.unrealdinnerbone.yaum.libs.Reference;
import com.unrealdinnerbone.yaum.libs.utils.PlayerUtil;
import com.unrealdinnerbone.yaum.perks.StatsGetter;
import com.unrealdinnerbone.yaum.perks.Supporter;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Side.CLIENT)
@SideOnly(Side.CLIENT)
public class EventEntityJoinWorld
{

    @SubscribeEvent
    public static void entityJoinWorld(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof AbstractClientPlayer) {
            final AbstractClientPlayer player = (AbstractClientPlayer) event.getEntity();
            if (StatsGetter.isSupporter(player.getUniqueID())) {
                final Supporter supporter = StatsGetter.getSupporter(player);
                if (supporter.getCapeTexture() != null && YaumConfiguration.ClientConfig.Supports.capesEnabled) {
                    PlayerUtil.makePlayerFancy(MinecraftProfileTexture.Type.CAPE, player, supporter.getCapeTexture());
                }
                if (supporter.getElytraTexture() != null && YaumConfiguration.ClientConfig.Supports.elytraEnabled) {
                    PlayerUtil.makePlayerFancy(MinecraftProfileTexture.Type.ELYTRA, player, supporter.getElytraTexture());
                }
            }
        }
    }
}

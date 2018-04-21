package com.unrealdinnerbone.yaum.libs.helpers;

import com.unrealdinnerbone.yaum.api.firework.EnumExplodeEffect;
import com.unrealdinnerbone.yaum.api.firework.EnumFireworkEffect;
import com.unrealdinnerbone.yaum.api.firework.FireworkBase;
import com.unrealdinnerbone.yaum.libs.utils.EnumUtil;
import com.unrealdinnerbone.yaum.common.network.PacketHandler;
import com.unrealdinnerbone.yaum.common.network.PacketSpawnFirework;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class FireworkHelper
{
    public static void spawnFirework(FireworkBase fireworkBase, BlockPos pos, EnumFacing facing, int dim) {
        PacketHandler.INSTANCE.sendToAllAround(new PacketSpawnFirework(pos, fireworkBase, facing), new NetworkRegistry.TargetPoint(dim, pos.getX(), pos.getY(), pos.getZ(),64));
    }

    public static FireworkBase getRandom(int maxColors, int maxFadeColors) {
        FireworkBase firework = new FireworkBase();
        for (int i1 = 0; i1 < MathHelper.getRandomInt(1, maxColors); i1++) {
            firework.addColor(MathHelper.getRandomHexColor());
        }
        for (int i = 0; i < MathHelper.getRandomInt(1, maxFadeColors); i++) {
            firework.addFadeColor(MathHelper.getRandomHexColor());
        }
        if (MathHelper.getRandomInt(0, 1) == 1) {
            firework.addFireworkEffect(EnumFireworkEffect.TRAIL);
        }
        if (MathHelper.getRandomInt(0, 1) == 1) {
            firework.addFireworkEffect(EnumFireworkEffect.FLICKER);
        }
        firework.setExplodeEffect(EnumUtil.randomEnum(EnumExplodeEffect.class));
        return firework;
    }
}

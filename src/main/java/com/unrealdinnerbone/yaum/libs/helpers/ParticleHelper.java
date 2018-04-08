package com.unrealdinnerbone.yaum.libs.helpers;

import com.unrealdinnerbone.yaum.network.PacketHandler;
import com.unrealdinnerbone.yaum.network.PacketSpawnParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ParticleHelper
{
    public static void spawnParticle(int id, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        Minecraft.getMinecraft().effectRenderer.spawnEffectParticle(id, x, y, z, xSpeed, ySpeed, zSpeed);
    }

    public static void spawnParticle(EnumParticleTypes particleType, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        spawnParticle(particleType.getParticleID(), x, y, z, xSpeed, ySpeed, zSpeed);
    }


    public static void spawnParticleRing(World world, EnumParticleTypes particle, double x, double y, double z, double velocityX, double velocityY, double velocityZ, double step) {

        for (double degree = 0.0d; degree < 2 * Math.PI; degree += step) {
            PacketSpawnParticle spawnParticle = new PacketSpawnParticle(particle, particle.getShouldIgnoreRange(), (float) x + (float) Math.cos(degree), (float) y, (float)z + (float) Math.sin(degree), (float) velocityX, (float) velocityY, (float) velocityZ, 0, 1);
            PacketHandler.INSTANCE.sendToAllAround(spawnParticle, new NetworkRegistry.TargetPoint(world.provider.getDimension(), x , y, z , 16));

        }
    }
}

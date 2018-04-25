package com.unrealdinnerbone.yaum.libs.helpers;

import com.unrealdinnerbone.yaum.Yaum;
import com.unrealdinnerbone.yaum.common.network.PacketHandler;
import com.unrealdinnerbone.yaum.common.network.PacketSpawnParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ParticleHelper
{
    //Todo this better
    public static void spawnParticle(int id, boolean shouldIgnoreRange, float x, float y, float z, float xSpeed, float ySpeed, float zSpeed, World world) {
        Yaum.proxy.spawnParticle(id, shouldIgnoreRange, x, y, z, xSpeed, ySpeed, zSpeed, world);
    }

    public static void spawnParticle(EnumParticleTypes particleType, float x, float y, float z, float xSpeed, float ySpeed, float zSpeed, World world) {
        spawnParticle(particleType.getParticleID(), particleType.getShouldIgnoreRange(), x, y, z, xSpeed, ySpeed, zSpeed, world);
    }

    public static void spawnParticleRing(World world, EnumParticleTypes particle, double x, double y, double z, double velocityX, double velocityY, double velocityZ, double step) {
        for (double degree = 0.0d; degree < 2 * Math.PI; degree += step) {
            spawnParticle(particle, (float) x + (float) Math.cos(degree), (float) y, (float)z + (float) Math.sin(degree), (float) velocityX, (float) velocityY, (float) velocityZ, world);
        }
    }
}

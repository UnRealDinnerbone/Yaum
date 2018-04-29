package com.unrealdinnerbone.yaum.libs.helpers;

import com.unrealdinnerbone.yaum.Yaum;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class ParticleHelper
{
    public static void spawnParticle(int id, boolean shouldIgnoreRange, float x, float y, float z, float xSpeed, float ySpeed, float zSpeed, int dimID) {
        Yaum.proxy.spawnParticle(id, shouldIgnoreRange, x, y, z, xSpeed, ySpeed, zSpeed, dimID);
    }

    public static void spawnParticle(EnumParticleTypes particleType, float x, float y, float z, float xSpeed, float ySpeed, float zSpeed, World world) {
        spawnParticle(particleType.getParticleID(), particleType.getShouldIgnoreRange(), x, y, z, xSpeed, ySpeed, zSpeed, world.provider.getDimension());
    }

    public static void spawnParticleRing(World world, EnumParticleTypes particle, double x, double y, double z, double velocityX, double velocityY, double velocityZ, double step) {
        for (double degree = 0.0d; degree < 2 * Math.PI; degree += step) {
            spawnParticle(particle, (float) x + (float) Math.cos(degree), (float) y, (float)z + (float) Math.sin(degree), (float) velocityX, (float) velocityY, (float) velocityZ, world);
        }
    }
}

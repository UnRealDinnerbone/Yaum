package com.unrealdinnerbone.yaum.libs.helpers;

import com.unrealdinnerbone.yaum.Yaum;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class ParticleHelper
{
    public static void spawnParticle(int id, boolean shouldIgnoreRange, float x, float y, float z, float xSpeed, float ySpeed, float zSpeed, int dimID) {
        Yaum.proxy.spawnParticle(id, shouldIgnoreRange, x, y, z, xSpeed, ySpeed, zSpeed, dimID);
    }
}

package com.unrealdinnerbone.yaum.libs.helpers;

import com.unrealdinnerbone.yaum.api.explosion.IYaumExplosion;
import com.unrealdinnerbone.yaum.common.explosion.ExplosionCircle;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.stream.IntStream;

public class ExplosionHelper
{
    public static void createExplosion(IYaumExplosion yaumExplosion, World world, ExplosionType explosionType) {
        switch (explosionType) {
            case MINECRAFT:
                createExplosion(world,  new Explosion(world, null, yaumExplosion.getX(), yaumExplosion.getY(), yaumExplosion.getZ(), yaumExplosion.getStrength(), yaumExplosion.makeFire(), yaumExplosion.damageTerrin()));
                break;
            case SQUARE:
                break;
            case CIRCLE:
                IntStream.range(0, yaumExplosion.getStrength()).forEach(x -> createExplosion(world, new ExplosionCircle(world, null, yaumExplosion.getX(), yaumExplosion.getY(), yaumExplosion.getZ(), x, yaumExplosion.makeFire(), yaumExplosion.damageTerrin())));
                break;
        }
    }

    public enum ExplosionType {
        MINECRAFT,
        SQUARE,
        CIRCLE
    }

    private static void createExplosion(World world, Explosion explosion) {
        explosion.doExplosionA();
        explosion.doExplosionB(true);
    }
}

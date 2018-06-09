package com.unrealdinnerbone.yaum.common.explosion;

import com.unrealdinnerbone.yaum.api.explosion.IYaumExplosion;
import net.minecraft.world.Explosion;

public class YaumExplosion implements IYaumExplosion {

    private double x;
    private double y;
    private double z;
    private int strength;
    private boolean makeFire;
    private boolean damgeTerrin;

    public YaumExplosion(double x, double y, double z, int strength, boolean makeFire, boolean damgeTerrin) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.strength = strength;
        this.makeFire = makeFire;
        this.damgeTerrin = damgeTerrin;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getZ() {
        return z;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public boolean makeFire() {
        return makeFire;
    }

    @Override
    public boolean damageTerrin() {
        return damgeTerrin;
    }

}

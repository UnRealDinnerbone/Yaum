package com.unrealdinnerbone.yaum.api.events;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

@Cancelable
public class EventCropTrample extends Event
{
    private World world;
    private BlockPos pos;
    private Entity entity;
    private float fallDistance;

    public EventCropTrample(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
        this.world = worldIn;
        this.pos = pos;
        this.entity = entityIn;
        this.fallDistance = fallDistance;
    }

    public BlockPos getPos() {
        return pos;
    }

    public Entity getEntity() {
        return entity;
    }

    public float getFallDistance() {
        return fallDistance;
    }

    public World getWorld() {
        return world;
    }
}

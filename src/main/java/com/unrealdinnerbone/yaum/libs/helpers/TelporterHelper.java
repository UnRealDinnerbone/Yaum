package com.unrealdinnerbone.yaum.libs.helpers;

import com.unrealdinnerbone.yaum.libs.DimBlockPos;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.ITeleporter;

public class TelporterHelper
{

    public static void performTeleport(Entity entity, int dimension, double destX, double destY, double destZ) {
        float rotationYaw = entity.rotationYaw;
        float rotationPitch = entity.rotationPitch;
        if (entity.getEntityWorld().provider.getDimension() != dimension) {
            teleportToDimension(entity, dimension, destX, destY, destZ);
        }
        entity.rotationYaw = rotationYaw;
        entity.rotationPitch = rotationPitch;
        entity.setPositionAndUpdate(destX, destY, destZ);
    }

    public static void performTeleport(EntityPlayer entityPlayer, DimBlockPos dimBlockPos) {
        performTeleport(entityPlayer, dimBlockPos.getDimID(), dimBlockPos.getX(), dimBlockPos.getY(), dimBlockPos.getZ());
    }

    public static void teleportToDimension(Entity entity, int dimension, double x, double y, double z) {
        int formDimID = entity.getEntityWorld().provider.getDimension();
        if(entity instanceof EntityPlayerMP) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP) entity;
            MinecraftServer server = entity.getEntityWorld().getMinecraftServer();
            WorldServer worldServer = server.getWorld(dimension);
            entityPlayerMP.addExperienceLevel(0);
            worldServer.getMinecraftServer().getPlayerList().transferPlayerToDimension(entityPlayerMP, dimension, new YatmTeleporter(worldServer, x, y, z));
            entity.setPositionAndUpdate(x, y, z);
            if (formDimID == 1) {
                entity.setPositionAndUpdate(x, y, z);
                worldServer.spawnEntity(entity);
                worldServer.updateEntityWithOptionalForce(entity, false);
            }
        }
    }

    public static class YatmTeleporter extends Teleporter {

        private final WorldServer worldServer;

        private double x;
        private double y;
        private double z;


        public YatmTeleporter(WorldServer world, double x, double y, double z) {
            super(world);
            this.worldServer = world;
            this.x = x;
            this.y = y;
            this.z = z;

        }

        @Override
        public void placeInPortal(Entity pEntity, float rotationYaw) {
            this.worldServer.getBlockState(new BlockPos(this.x, this.y, this.z));
            pEntity.setPosition(this.x, this.y, this.z);
            pEntity.motionX = 0.0f;
            pEntity.motionY = 0.0f;
            pEntity.motionZ = 0.0f;
        }

    }

}

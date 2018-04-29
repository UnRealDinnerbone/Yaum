package com.unrealdinnerbone.yaum.proxy;

import com.unrealdinnerbone.yaum.common.network.PacketHandler;
import com.unrealdinnerbone.yaum.common.network.PacketSpawnParticle;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.SERVER)
public class ServerProxy extends CommonProxy
{
    @Override
    public void spawnParticle(int id, boolean shouldIgnoreRange, float x, float y, float z, float xSpeed, float ySpeed, float zSpeed, int dimID) {
        PacketSpawnParticle spawnParticle = new PacketSpawnParticle(id, shouldIgnoreRange, x, y, z, xSpeed, ySpeed, zSpeed, dimID);
        PacketHandler.INSTANCE.sendToAllAround(spawnParticle, new NetworkRegistry.TargetPoint(dimID, x, y, z, 16));
    }
}

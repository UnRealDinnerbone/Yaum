package com.unrealdinnerbone.yaum.common.network;

import com.unrealdinnerbone.yaum.api.network.ISimplePacket;
import com.unrealdinnerbone.yaum.libs.helpers.ParticleHelper;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class PacketSpawnParticle implements ISimplePacket<PacketSpawnParticle> {

    private int particleID;
    private float xCoord;
    private float yCoord;
    private float zCoord;
    private float xOffset;
    private float yOffset;
    private float zOffset;
    private boolean longDistance;
    private int dimId;

    public PacketSpawnParticle() {

    }

    public PacketSpawnParticle(int particleID, boolean longDistanceIn, float xIn, float yIn, float zIn, float xOffsetIn, float yOffsetIn, float zOffsetIn, int dimID) {
        this.particleID = particleID;
        this.longDistance = longDistanceIn;
        this.xCoord = xIn;
        this.yCoord = yIn;
        this.zCoord = zIn;
        this.xOffset = xOffsetIn;
        this.yOffset = yOffsetIn;
        this.zOffset = zOffsetIn;
        this.dimId = dimID;
    }

    public int getParticleID() {
        return particleID;
    }

    public boolean isLongDistance() {
        return this.longDistance;
    }

    public float getXCoordinate() {
        return this.xCoord;
    }

    public float getYCoordinate() {
        return this.yCoord;
    }

    public float getZCoordinate() {
        return this.zCoord;
    }

    public float getXOffset() {
        return this.xOffset;
    }

    public float getYOffset() {
        return this.yOffset;
    }

    public float getZOffset() {
        return this.zOffset;
    }

    public int getDimId() {
        return dimId;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.particleID = buf.readInt();
        this.longDistance = buf.readBoolean();
        this.xCoord = buf.readFloat();
        this.yCoord = buf.readFloat();
        this.zCoord = buf.readFloat();
        this.xOffset = buf.readFloat();
        this.yOffset = buf.readFloat();
        this.zOffset = buf.readFloat();
        this.dimId = buf.readInt();

    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.particleID);
        buf.writeBoolean(this.longDistance);
        buf.writeFloat(this.xCoord);
        buf.writeFloat(this.yCoord);
        buf.writeFloat(this.zCoord);
        buf.writeFloat(this.xOffset);
        buf.writeFloat(this.yOffset);
        buf.writeFloat(this.zOffset);
        buf.writeInt(this.dimId);
    }

    @Override
    public IMessage onMessage(PacketSpawnParticle message, MessageContext ctx) {
        ParticleHelper.spawnParticle(message.getParticleID(), message.isLongDistance(), message.getXCoordinate(), message.getYCoordinate(), message.getZCoordinate(), message.getXOffset(), message.getYOffset(), message.getZOffset(), message.getDimId());
        return null;
    }
}

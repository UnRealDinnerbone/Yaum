package com.unrealdinnerbone.yaum.api.tile.power;

import com.unrealdinnerbone.yaum.api.power.YaumFEStorage;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public abstract class YaumEnergyTitleEntity extends TileEntity {

    protected final YaumFEStorage forgeEnergyStorage;

    public YaumEnergyTitleEntity(int capacity, int maxReceive, int maxExtract, int energy,  boolean canExtract, boolean canReceive) {
        super();
        forgeEnergyStorage = new YaumFEStorage(capacity, maxReceive, maxExtract, energy, canExtract, canReceive);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        if(capability == CapabilityEnergy.ENERGY) {
            return CapabilityEnergy.ENERGY.cast(forgeEnergyStorage);
        } else {
            return super.getCapability(capability, facing);
        }
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityEnergy.ENERGY || super.hasCapability(capability, facing);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound = super.writeToNBT(compound.copy());
        return forgeEnergyStorage.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        forgeEnergyStorage.readFromNBT(compound);
    }

    public YaumFEStorage getFEStorage() {
        return forgeEnergyStorage;
    }


    @Nullable
    @Override
    public NBTTagCompound getUpdateTag() {
        NBTTagCompound compound = super.writeToNBT(new NBTTagCompound());
        writeToNBT(compound);
        return compound;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void onDataPacket(net.minecraft.network.NetworkManager net, SPacketUpdateTileEntity pkt) {
        super.onDataPacket(net, pkt);
        readFromNBT(pkt.getNbtCompound());
    }
}

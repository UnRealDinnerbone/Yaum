package com.unrealdinnerbone.yaum.api.title;

import com.unrealdinnerbone.yaum.api.YaumFEStorage;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;

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
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        compound = super.writeToNBT(compound);
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
}

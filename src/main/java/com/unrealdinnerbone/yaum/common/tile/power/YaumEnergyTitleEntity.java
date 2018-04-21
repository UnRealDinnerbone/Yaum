package com.unrealdinnerbone.yaum.common.tile.power;

import com.unrealdinnerbone.yaum.common.tile.YaumTileEntity;
import com.unrealdinnerbone.yaum.common.power.YaumFEStorage;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class YaumEnergyTitleEntity extends YaumTileEntity {

    protected final YaumFEStorage forgeEnergyStorage;

    public YaumEnergyTitleEntity(int capacity, int maxReceive, int maxExtract, int energy,  boolean canExtract, boolean canReceive) {
        super();
        forgeEnergyStorage = new YaumFEStorage(capacity, maxReceive, maxExtract, energy, canExtract, canReceive);
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        if(capability == CapabilityEnergy.ENERGY) {
            return CapabilityEnergy.ENERGY.cast(forgeEnergyStorage);
        } else {
            return super.getCapability(capability, facing);
        }
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
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


}

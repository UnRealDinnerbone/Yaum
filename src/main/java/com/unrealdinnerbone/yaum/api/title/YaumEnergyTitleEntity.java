package com.unrealdinnerbone.yaum.api.title;

import com.unrealdinnerbone.yaum.api.YaumFEStorge;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;

import javax.annotation.Nullable;

public class YarmEnergyTitleEnity extends YaumTileEnity {

    protected final YaumFEStorge feStorge;

    public YarmEnergyTitleEnity(String name, int capacity, int maxReceive, int maxExtract, int energy) {
        super(name);
        feStorge = new YaumFEStorge(capacity, maxReceive, maxExtract, energy);
    }

    public YaumFEStorge getFEStorge() {
        return feStorge;
    }


    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        if(capability == CapabilityEnergy.ENERGY) {
            return CapabilityEnergy.ENERGY.cast(feStorge);
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
        return feStorge.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        feStorge.readFromNBT(compound);
    }

    public YaumFEStorge getStorge() {
        return feStorge;
    }
}

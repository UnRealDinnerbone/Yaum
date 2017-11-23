package com.unrealdinnerbone.yaum.api.power;

import net.minecraft.nbt.*;
import net.minecraftforge.energy.EnergyStorage;

public class YaumFEStorage extends EnergyStorage {

    private final boolean canExtract;
    private final boolean canReceive;

    public YaumFEStorage(int capacity, int maxReceive, int maxExtract, int energy, boolean canExtract, boolean canReceive) {
        super(capacity, maxReceive, maxExtract, energy);
        this.canExtract = canExtract;
        this.canReceive = canReceive;
    }

    public void setEnergy(int level) {
        this.energy = level;
    }


    //Called for inside block use ignores energy max input
    public int generateEnergy(int amount) {
         int newEnergy = amount + energy;
         if(newEnergy > capacity) {
             newEnergy = capacity;
             return (capacity - newEnergy);
         }else {
             energy = newEnergy;
             return 0;
         }
    }

    @Override
    public boolean canExtract() {
        return canExtract;
    }

    @Override
    public boolean canReceive() {
        return canReceive;
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setInteger("energy", energy);
        return compound;
    }

    public void readFromNBT(NBTTagCompound compound) {
        energy = compound.getInteger("energy");
    }




    public int getMaxExtract() {
        return maxExtract;
    }
    public int getMaxRecive() {
        return maxReceive;
    }

}

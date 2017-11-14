package com.unrealdinnerbone.yaum.libs.utils;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nullable;

public class EnergyHelper {

    public static int getAmountOfEnergyStorgeLeft(TileEntity tileEntity, EnumFacing side) {
        IEnergyStorage storage = getEnergyCapability(tileEntity, side);
        if (storage == null) {
            return -1;
        } else {
            return storage.getMaxEnergyStored() - storage.getEnergyStored();
        }
    }

    @Nullable
    public static IEnergyStorage getEnergyCapability(TileEntity tileEntity, EnumFacing side) {
        return hasEnergyCapability(tileEntity, side) ? tileEntity.getCapability(CapabilityEnergy.ENERGY, side) : null;
    }

    public static boolean hasEnergyCapability(TileEntity tileEntity, EnumFacing side) {
        return tileEntity != null && tileEntity.hasCapability(CapabilityEnergy.ENERGY, side);
    }

    //Returns power that did not get used
    public static int giveEnergyToTileEntity(IEnergyStorage iESSender, IEnergyStorage iESReciver, int amount)
    {
        if(iESSender.canExtract() && iESReciver.canReceive()) {
            int energy = amount;
            if(iESSender.getEnergyStored() < amount) {
                energy -= iESSender.getEnergyStored();
            }
            int powerLeft = amount - iESSender.getEnergyStored();
            iESSender.extractEnergy(energy, false);
            return powerLeft + iESReciver.receiveEnergy(energy, false);
        }else {
            return -1;
        }
    }



    public static void giveEnergyToAllSides(TileEntity tileEntitySender, int amount) {
        if(tileEntitySender != null)
        {
            for (EnumFacing side : EnumFacing.VALUES) {
                TileEntity tileEntityReciver = tileEntitySender.getWorld().getTileEntity(tileEntitySender.getPos().offset(side));
                if (tileEntityReciver != null) {
                    IEnergyStorage iESSender = getEnergyCapability(tileEntitySender, side);
                    if(iESSender != null) {
                        IEnergyStorage iEReciver = getEnergyCapability(tileEntityReciver, side);
                        if(iEReciver != null) {
                            giveEnergyToTileEntity(iESSender, iEReciver, amount);
                        }
                    }
                }
            }
        }

    }

}

package com.unrealdinnerbone.yaum.libs.helpers;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nullable;

public class EnergyHelper {

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
            int powerLeft = iESSender.getEnergyStored() - amount;
            iESSender.extractEnergy(energy, false);
            return powerLeft - iESReciver.receiveEnergy(energy, false);
        }else {
            return -1;
        }
    }



    public static void giveEnergyOutFormSides(TileEntity tileEntitySender, int amount, EnumFacing... sides) {
        if(tileEntitySender != null)
        {
            for (EnumFacing side : sides) {
                TileEntity tileEntityReciver = tileEntitySender.getWorld().getTileEntity(tileEntitySender.getPos().offset(side));
                if (tileEntityReciver != null) {
                    IEnergyStorage iESSender = getEnergyCapability(tileEntitySender, side);
                    if(iESSender != null) {
                        IEnergyStorage iEReciver = getEnergyCapability(tileEntityReciver, side.getOpposite());
                        if(iEReciver != null) {
                           giveEnergyToTileEntity(iESSender, iEReciver, amount);
                        }
                    }
                }
            }
        }

    }

}

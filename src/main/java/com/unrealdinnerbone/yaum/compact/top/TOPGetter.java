package com.unrealdinnerbone.yaum.compact.top;

import mcjty.theoneprobe.api.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import java.util.function.Function;

public class TOPGetter implements Function<ITheOneProbe, Void> {

    @Override
    public Void apply(ITheOneProbe theOneProbe) {
        theOneProbe.registerProvider(new IProbeInfoProvider() {
            @Override
            public String getID() {
                return "yaum:default";
            }

            @Override
            public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data) {
                if (blockState.getBlock() instanceof ITopInfo) {
                    ITopInfo topInfo = (ITopInfo) blockState.getBlock();
                    topInfo.addProbeInfo(mode, probeInfo, player, world, blockState, data);
                }

            }
        });
        return null;
    }
}

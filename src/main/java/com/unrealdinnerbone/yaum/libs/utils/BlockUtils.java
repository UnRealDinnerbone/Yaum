package com.unrealdinnerbone.yaum.util;

import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.List;

public class BlockUtils
{

    public static List<BlockPos> getBlockPosBetweenTwoPoints(BlockPos blockPos1, BlockPos blockPos2) {
        List<BlockPos> blocks = new ArrayList<>();

        int topBlockX = (blockPos1.getX() < blockPos2.getX() ? blockPos2.getX() : blockPos1.getX());
        int bottomBlockX = (blockPos1.getX() > blockPos2.getX() ? blockPos2.getX() : blockPos1.getX());

        int topBlockY = (blockPos1.getY() < blockPos2.getY() ? blockPos2.getY() : blockPos1.getY());
        int bottomBlockY = (blockPos1.getY() > blockPos2.getY() ? blockPos2.getY() : blockPos1.getY());

        int topBlockZ = (blockPos1.getZ() < blockPos2.getZ() ? blockPos2.getZ() : blockPos1.getZ());
        int bottomBlockZ = (blockPos1.getZ() > blockPos2.getZ() ? blockPos2.getZ() : blockPos1.getZ());

        for (int x = bottomBlockX; x <= topBlockX; x++) {
            for (int z = bottomBlockZ; z <= topBlockZ; z++) {
                for (int y = bottomBlockY; y <= topBlockY; y++) {
                    blocks.add(new BlockPos(x, y, z));
                }
            }
        }

        return blocks;
    }

}

package com.unrealdinnerbone.yaum.libs;

import net.minecraft.util.math.BlockPos;

public class DimBlockPos extends BlockPos {

    int dimID;

    public DimBlockPos(int x, int y, int z, int dimID) {
        super(x, y, z);
        this.dimID = dimID;
    }

    public DimBlockPos(double x, double y, double z, int dimID) {
        super(x, y, z);
        this.dimID = dimID;
    }

    public DimBlockPos(BlockPos blockPos, int dimID) {
        super(blockPos.getX(), blockPos.getY(), blockPos.getZ());
        this.dimID = dimID;
    }

    public int getDimID() {
        return dimID;
    }

    public void setDimID(int dimID) {
        this.dimID = dimID;
    }

    public static DimBlockPos fromStoreString(String s) {
        String[] strings = s.split(";");
        long blockPosLon = Long.valueOf(strings[0]);
        Integer integer = Integer.valueOf(strings[1]);
        BlockPos blockPos = BlockPos.fromLong(blockPosLon);
        return new DimBlockPos(blockPos, integer);
    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof DimBlockPos) {
            DimBlockPos compareBlockPos = (DimBlockPos) object;
            return this.getX() == compareBlockPos.getX() && this.getY() == compareBlockPos.getY() && this.getZ() == compareBlockPos.getZ() && this.dimID == compareBlockPos.getDimID();
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String string = super.toString();
        string += "dimID: " + dimID;
        return string;
    }

    public String toStoreString() {
        return toLong() + ";" + dimID;
    }
}

package com.unrealdinnerbone.yaum.common.impl.block;

import com.unrealdinnerbone.yaum.api.register.impl.IYaumBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public abstract class YaumBlockBase extends Block implements IYaumBlock {

    public YaumBlockBase(Material blockMaterialIn, MapColor blockMapColorIn) {
        super(blockMaterialIn, blockMapColorIn);
    }

    public YaumBlockBase(Material materialIn) {
        super(materialIn);
    }

    @Override
    public Block get() {
        return this;
    }

}

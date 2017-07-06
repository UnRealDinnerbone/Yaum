package com.unrealdinnerbone.yaum.block;

import com.unrealdinnerbone.yaum.api.IYaumBlock;
import com.unrealdinnerbone.yaum.yaum;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class YaumTestBlock extends Block implements IYaumBlock {

    public YaumTestBlock() {
        super(Material.ROCK , MapColor.ADOBE);
        yaum.getYaumRegistry().registerBlock(this);
    }

    @Override
    public Block getBlock() {
        return this;
    }

    @Override
    public String getBlockName() {
        return "TestBlock";
    }
}

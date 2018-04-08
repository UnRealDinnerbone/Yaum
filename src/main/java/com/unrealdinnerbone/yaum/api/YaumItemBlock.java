package com.unrealdinnerbone.yaum.api;

import com.unrealdinnerbone.yaum.api.register.IYaumItem;
import com.unrealdinnerbone.yaum.api.register.IYaumObject;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class YaumItemBlock extends ItemBlock implements IYaumItem {

    private final IYaumObject<Block> yaumBlock;

    public YaumItemBlock(IYaumObject<Block> yaumBlock) {
        super(yaumBlock.get());
        this.yaumBlock = yaumBlock;
    }

    @Override
    public Item get() {
        return this;
    }

    @Override
    public String getName() {
        return yaumBlock.getName();
    }
}

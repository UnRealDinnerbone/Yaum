package com.unrealdinnerbone.yaum.api.base.block;

import com.unrealdinnerbone.yaum.api.IYaumMod;
import com.unrealdinnerbone.yaum.api.base.item.YaumDoorItem;
import com.unrealdinnerbone.yaum.api.register.impl.IYaumBlock;
import com.unrealdinnerbone.yaum.api.register.impl.IYaumItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;

import java.util.Random;

public abstract class YaumBlockDoor extends BlockDoor implements IYaumBlock
{
    private IYaumItem doorItem;
    private Material material;

    public YaumBlockDoor(Material material)
    {
        super(Material.WOOD);
        this.material = material;
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {                                                                               //Item
        return state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER ? Items.AIR : doorItem.get();
    }

    @Override
    public Block get() {
        return this;
    }

    @Override
    public IYaumItem createItemBlock() {
        this.doorItem = new YaumDoorItem(this);
        return doorItem;
    }

    @Override
    public void render(ModelRegistryEvent event, IYaumMod mod) {
        IYaumBlock.super.render(event, mod);
        ModelLoader.setCustomStateMapper(this, (new StateMap.Builder()).ignore(POWERED).build());
    }
}

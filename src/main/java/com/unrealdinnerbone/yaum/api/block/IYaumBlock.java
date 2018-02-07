package com.unrealdinnerbone.yaum.api.block;

import com.unrealdinnerbone.yaum.libs.helpers.TextureHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IYaumBlock {

    Block getBlock();

    String getBlockName();

    default void registerBlock(RegistryEvent.Register<Block> event, ModContainer modContainer) {
        getBlock().setUnlocalizedName(getBlockName().toLowerCase());
        getBlock().setRegistryName(modContainer.getModId(), getBlockName());
        event.getRegistry().register(getBlock());
    }

    default void registerItemBlock(RegistryEvent.Register<Item> event, ModContainer modContainer) {
        event.getRegistry().register(new ItemBlock(getBlock()).setRegistryName(modContainer.getModId(), getBlockName()));
    }

    @SideOnly(Side.CLIENT)
    default void renderBlock(ModelRegistryEvent event) {
        TextureHelper.registerItemTexture(Item.getItemFromBlock(getBlock()), getBlock().getRegistryName());
    }

}

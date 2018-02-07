package com.unrealdinnerbone.yaum.api.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IYaumItem {
    String getItemName();

    Item getItem();

    default void registerItem(RegistryEvent.Register<Item> event, ModContainer modContainer) {
        getItem().setRegistryName(modContainer.getModId(), getItemName());
        getItem().setUnlocalizedName(modContainer.getModId() + "." + getItemName().toLowerCase());
        event.getRegistry().register(getItem());
    }


    @SideOnly(Side.CLIENT)
    default void renderItem(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(getItem(), 0, new ModelResourceLocation(getItem().getRegistryName(), "inventory"));
    }
}

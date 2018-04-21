package com.unrealdinnerbone.yaum.api.register.impl;

import com.unrealdinnerbone.yaum.api.IYaumMod;
import com.unrealdinnerbone.yaum.api.register.IYaumObject;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IYaumItem extends IYaumObject<Item> {


    @Override
    default void register(RegistryEvent.Register<Item> registryEvent, IYaumMod mod) {
        get().setUnlocalizedName(getName().toLowerCase());
        IYaumObject.super.register(registryEvent, mod);
    }

    @SideOnly(Side.CLIENT)
    @Override
    default void render(ModelRegistryEvent event, IYaumMod mod) {
        ModelLoader.setCustomModelResourceLocation(get(), 0, new ModelResourceLocation(get().getRegistryName(), "inventory"));
    }
}

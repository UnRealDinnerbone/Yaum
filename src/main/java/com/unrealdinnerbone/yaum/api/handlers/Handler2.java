package com.unrealdinnerbone.yaum.api.handlers;

import com.unrealdinnerbone.yaum.api.IYaumRegisterObject;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface Handler<T extends IForgeRegistryEntry<T>> {

    default void register(IForgeRegistry<T> registry, IYaumRegisterObject<T> registerObject) {

    }

    @SideOnly(Side.CLIENT)
    default void render(ModelRegistryEvent event, IYaumRegisterObject<T> registerObject) {

    }



}

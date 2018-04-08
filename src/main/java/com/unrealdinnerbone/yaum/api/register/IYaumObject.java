package com.unrealdinnerbone.yaum.api.register;

import com.unrealdinnerbone.yaum.api.IYaumMod;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistryEntry;

public interface IYaumObject<T extends IForgeRegistryEntry<T>> extends IConfgRegister
{
    T get();

    String getName();

    default void register(RegistryEvent.Register<T> registryEvent, IYaumMod mod) {
        get().setRegistryName(new ResourceLocation(mod.getModName(), getName()));
        registryEvent.getRegistry().register(get());
    }


    @SideOnly(Side.CLIENT)
    default void render(ModelRegistryEvent event, IYaumMod mod) {

    }

    @Override
    default boolean doRegistration() {
        return true;
    }
}

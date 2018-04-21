package com.unrealdinnerbone.yaum.api.register;

import com.unrealdinnerbone.yaum.api.IYaumMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;

public interface IYaumEnchantment extends IYaumObject<Enchantment>
{
    @Override
    default void register(RegistryEvent.Register<Enchantment> registryEvent, IYaumMod mod) {
        get().setName(getName());
        IYaumObject.super.register(registryEvent, mod);
    }

}

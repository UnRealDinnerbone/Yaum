package com.unrealdinnerbone.yaum.api.handlers;


import com.unrealdinnerbone.yaum.api.IYaumRegisterObject;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.registries.IForgeRegistry;

public class HandlerEnchantmentRegister implements Handler<Enchantment>
{

    @Override
    public void register(IForgeRegistry<Enchantment> registry, IYaumRegisterObject<Enchantment> registerObject) {
        registerObject.get().setRegistryName(registerObject.getModID(), registerObject.getName().toLowerCase());
        registerObject.get().setName( registerObject.getName());
        registry.register(registerObject.get());
    }

}

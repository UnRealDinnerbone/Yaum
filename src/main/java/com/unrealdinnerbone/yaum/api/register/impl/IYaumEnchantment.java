package com.unrealdinnerbone.yaum.api.register.impl;

import com.unrealdinnerbone.yaum.api.IYaumMod;
import com.unrealdinnerbone.yaum.api.compact.IIntergation;
import com.unrealdinnerbone.yaum.api.compact.IRecipe;
import com.unrealdinnerbone.yaum.api.compact.cofh.thermalexpansion.EnchenterRecipe;
import com.unrealdinnerbone.yaum.api.register.IYaumObject;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public interface IYaumEnchantment extends IYaumObject<Enchantment>, IIntergation
{
    @Override
    default void register(RegistryEvent.Register<Enchantment> registryEvent, IYaumMod mod) {
        get().setName(getName());
        IYaumObject.super.register(registryEvent, mod);
    }

    @Override
    default List<IRecipe> getRecipes() {
        if(getEnchanterRecipe() != null) {
            return Collections.singletonList(getEnchanterRecipe());
        }
        return Collections.emptyList();
    }

    @Nullable
    default EnchenterRecipe getEnchanterRecipe() {
        return null;
    }

}

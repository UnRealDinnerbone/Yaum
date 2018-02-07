package com.unrealdinnerbone.yaum.api.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.common.ModContainer;

public interface IYaumEnchantment
{
    Enchantment getEnchantment();

    String getEnchantmentName();

    default void register(ModContainer modContainer) {
        getEnchantment().setRegistryName(modContainer.getModId(), getEnchantmentName());
        getEnchantment().setName(getEnchantmentName());
    }

}

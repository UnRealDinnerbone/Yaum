package com.unrealdinnerbone.yaum.libs.utils;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;

public class EnchantmentUtil extends EnchantmentHelper
{

    public static boolean isEnchanted(ItemStack itemStack)
    {
        return getEnchantments(itemStack).size() > 0;
    }


    public static boolean isEnchanted(ItemStack stack, Enchantment enchantment) {
        return isEnchanted(stack, enchantment,1);
    }

    public static boolean isEnchanted(ItemStack stack, Enchantment enchantment, int minLevel) {
        return isEnchanted(stack, enchantment, minLevel, Integer.MAX_VALUE);
    }

    public static boolean isEnchanted(ItemStack stack, Enchantment enchantment, int minLevel, int maxLevel) {
        return getEnchantmentLevel(enchantment, stack) >= minLevel && getEnchantmentLevel(enchantment, stack) <= maxLevel;
    }


}

package com.unrealdinnerbone.yaum.api.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nullable;

public interface IYaumAnvilRecipe extends IForgeRegistryEntry<IYaumAnvilRecipe> {

   int getXPCost(ItemStack leftSlot, ItemStack rightSlot, String name);

   int getMaterialCost(ItemStack leftSlot, ItemStack rightSlot, String name);

   ItemStack getOutput(ItemStack leftSlot, ItemStack rightSlot, String name);

}

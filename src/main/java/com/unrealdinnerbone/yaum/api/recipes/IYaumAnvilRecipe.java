package com.unrealdinnerbone.yaum.api.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nullable;

public abstract class IYaumAnvilRecipe extends IForgeRegistryEntry.Impl<IYaumAnvilRecipe> {

   abstract int getXPCost(ItemStack leftSlot, ItemStack rightSlot, String name);

   abstract int getMaterialCost(ItemStack leftSlot, ItemStack rightSlot, String name);

   abstract ItemStack getOutput(ItemStack leftSlot, ItemStack rightSlot, String name);

}

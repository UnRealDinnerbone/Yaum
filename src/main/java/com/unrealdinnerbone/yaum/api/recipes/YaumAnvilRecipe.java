package com.unrealdinnerbone.yaum.api.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.IForgeRegistryEntry;

public abstract class YaumAnvilRecipe extends IForgeRegistryEntry.Impl<YaumAnvilRecipe> {

   public abstract int getXPCost(ItemStack leftSlot, ItemStack rightSlot, String name);

   public abstract int getMaterialCost(ItemStack leftSlot, ItemStack rightSlot, String name);

   public abstract ItemStack getOutput(ItemStack leftSlot, ItemStack rightSlot, String name);

}

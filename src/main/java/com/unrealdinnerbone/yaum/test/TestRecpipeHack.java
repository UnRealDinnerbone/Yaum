package com.unrealdinnerbone.yaum.test;

import com.unrealdinnerbone.yaum.api.register.IYaumObject;
import com.unrealdinnerbone.yaum.api.register.annotation.Register;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.registries.IForgeRegistryEntry;


@Register(Reference.MOD_ID)
public class TestRecpipeHack extends IForgeRegistryEntry.Impl<IRecipe> implements IYaumObject<IRecipe>, IRecipe {

    @Override
    public IRecipe get() {
        return this;
    }

    @Override
    public String getName() {
        return "test";
    }

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        return true;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        return new ItemStack(Blocks.SLIME_BLOCK);
    }

    @Override
    public boolean canFit(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return new ItemStack(Blocks.SLIME_BLOCK);
    }
}

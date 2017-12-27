package com.unrealdinnerbone.yaum.api.block;

import com.unrealdinnerbone.yaum.api.register.YaumRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IYaumBlock {

    Block getBlock();

    String getBlockName();

    default void registerBlock(RegistryEvent.Register<Block> event, YaumRegistry registry) {
        getBlock().setUnlocalizedName(getBlockName().toLowerCase());
        getBlock().setRegistryName(registry.getModID(), getBlockName());
        registry.getLogHelper().debug("Registering Block... " + getBlockName());
        event.getRegistry().register(getBlock());
    }

    default void registerItemBlock(RegistryEvent.Register<Item> event, YaumRegistry registry) {
        registry.getLogHelper().debug("Registering ItemBlock... " + getBlockName());
        event.getRegistry().register(new ItemBlock(getBlock()).setRegistryName(registry.getModID(), getBlockName()));
    }

    @SideOnly(Side.CLIENT)
    default void renderBlock(ModelRegistryEvent event, YaumRegistry registry) {
        registry.getLogHelper().debug("Rendering Block... " + getBlockName());
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(getBlock()), 0, new ModelResourceLocation(getBlock().getRegistryName(), "inventory"));
    }

}

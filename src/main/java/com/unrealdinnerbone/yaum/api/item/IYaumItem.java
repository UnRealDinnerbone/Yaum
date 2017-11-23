package com.unrealdinnerbone.yaum.api.item;

import com.unrealdinnerbone.yaum.api.register.YaumRegistry;
import com.unrealdinnerbone.yaum.yaum;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

public interface IYaumItem {
    String getItemName();

    Item getItem();

    default void registerItem(RegistryEvent.Register<Item> event, YaumRegistry registry) {
        getItem().setRegistryName(registry.getModID(), getItemName());
        getItem().setUnlocalizedName(registry.getModID() + "." + getItemName().toLowerCase());
        registry.getLogHelper().debug("Registering Item... " + getItemName());
        event.getRegistry().register(getItem());
    }

    default void renderItem(ModelRegistryEvent event, YaumRegistry registry) {
        registry.getLogHelper().debug("Rendering Item... " + getItemName());
        ModelLoader.setCustomModelResourceLocation(getItem(), 0, new ModelResourceLocation(getItem().getRegistryName(), "inventory"));
    }
}

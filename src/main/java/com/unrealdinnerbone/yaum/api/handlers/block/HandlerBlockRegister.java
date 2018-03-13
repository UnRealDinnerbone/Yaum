package com.unrealdinnerbone.yaum.api.handlers.block;

import com.unrealdinnerbone.yaum.api.IYaumRegisterObject;
import com.unrealdinnerbone.yaum.api.handlers.Handler;
import com.unrealdinnerbone.yaum.libs.helpers.TextureHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class HandlerBlockRegister implements Handler<Block> {

    @Override
    public <R extends IForgeRegistryEntry<R>> void register(IForgeRegistry<R> registry, IYaumRegisterObject<R> registerObject) {
        registerObject.get().setUnlocalizedName(registerObject.getName().toLowerCase());
        registerObject.get().setRegistryName(registerObject.getModID(), registerObject.getName());
        registry.register(registerObject.get());
    }



    @Override
    public void render(ModelRegistryEvent event, IYaumRegisterObject<Block> registerObject) {
        TextureHelper.registerItemTexture(new ItemBlock(registerObject.get()), registerObject.get().getRegistryName());

    }
}

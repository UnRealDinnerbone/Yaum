package com.unrealdinnerbone.yaum.api.handlers.item;

import com.unrealdinnerbone.yaum.api.IYaumRegisterObject;
import com.unrealdinnerbone.yaum.api.handlers.Handler;
import com.unrealdinnerbone.yaum.libs.helpers.TextureHelper;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class HandlerItemRegister implements Handler<Item> {

    @Override
    public void register(IForgeRegistry<Item> registry, IYaumRegisterObject<Item> registerObject) {
        registerObject.get().setRegistryName(registerObject.getModID(), registerObject.getName());
        registerObject.get().setUnlocalizedName(registerObject.getModID() + "." + registerObject.getName().toLowerCase());
        registry.register(registerObject.get());
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void render(ModelRegistryEvent event, IYaumRegisterObject<Item> registerObject) {
        TextureHelper.registerItemTexture(registerObject.get(), registerObject.get().getRegistryName());
    }



}

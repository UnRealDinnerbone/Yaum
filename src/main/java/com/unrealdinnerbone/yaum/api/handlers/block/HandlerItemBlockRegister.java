package com.unrealdinnerbone.yaum.api.handlers;

import com.unrealdinnerbone.yaum.Yaum;
import com.unrealdinnerbone.yaum.api.IYaumRegisterObject;
import com.unrealdinnerbone.yaum.libs.helpers.TextureHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class HandlerItemBlockRegister implements Handler<Item>
{
    @Override
    public void register(IForgeRegistry<Item> registry, IYaumRegisterObject<Item> registerObject) {
        if(registerObject.get() instanceof ItemBlock) {
            ItemBlock itemBlock = (ItemBlock) registerObject.get();
            registry.register(itemBlock.setRegistryName(registerObject.getModID(), registerObject.getName()));
        }else {
            Yaum.getLogHelper().warn("A Class tried to use the Item Block register");
        }
    }

//    @Override
//        public void render(ModelRegistryEvent event, IYaumRegisterObject<Item> registerObject) {
//            if(registerObject.get() instanceof ItemBlock) {
//                TextureHelper.registerItemTexture(registerObject.get(), registerObject.get().getRegistryName());
//            }else {
//                Yaum.getLogHelper().warn("A Class tried to use the Item Block register");
//            }
//    }
}

package com.unrealdinnerbone.yaum.api.register;

import com.unrealdinnerbone.yaum.api.IYaumMod;
import com.unrealdinnerbone.yaum.api.YaumItemBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;

public interface IYaumBlock extends IYaumObject<Block> {

    @Override
    default void register(RegistryEvent.Register<Block> registryEvent, IYaumMod mod) {
        get().setUnlocalizedName(getName().toLowerCase());
        IYaumObject.super.register(registryEvent, mod);
    }

    default YaumItemBlock createItemBlock() {
        return new YaumItemBlock(this);
    }

}

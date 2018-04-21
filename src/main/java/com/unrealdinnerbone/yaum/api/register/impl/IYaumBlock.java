package com.unrealdinnerbone.yaum.api.register.impl;

import com.unrealdinnerbone.yaum.api.IYaumMod;
import com.unrealdinnerbone.yaum.api.YaumItemBlock;
import com.unrealdinnerbone.yaum.api.register.IYaumObject;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;

public interface IYaumBlock extends IYaumObject<Block> {

    @Override
    default void register(RegistryEvent.Register<Block> registryEvent, IYaumMod mod) {
        get().setUnlocalizedName(getName().toLowerCase());
        IYaumObject.super.register(registryEvent, mod);
    }

    default IYaumItem createItemBlock() {
        return new YaumItemBlock(this);
    }

}

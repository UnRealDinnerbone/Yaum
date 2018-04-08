package com.unrealdinnerbone.yaum.api.register;

import com.unrealdinnerbone.yaum.api.IYaumMod;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;

public interface IYaumBlock extends IYaumObject<Block> {

    @Override
    default void register(RegistryEvent.Register<Block> registryEvent, IYaumMod mod) {
        get().setUnlocalizedName(getName().toLowerCase());
        IYaumObject.super.register(registryEvent, mod);
    }

}

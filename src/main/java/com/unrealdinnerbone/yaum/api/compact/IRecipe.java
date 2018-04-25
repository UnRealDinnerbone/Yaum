package com.unrealdinnerbone.yaum.api.compact;

import net.minecraftforge.fml.common.event.FMLInterModComms;

import javax.annotation.Nonnull;

public interface IRecipe {

    default void sendIMCMessage() {
        FMLInterModComms.sendMessage(getModID(), getKey(), getValue());
    }

    @Nonnull
    String getModID();

    @Nonnull
    String getKey();

    @Nonnull
    String getValue();
}

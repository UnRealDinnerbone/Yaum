package com.unrealdinnerbone.yaum.libs.utils;

import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nullable;

public class RegistryUtils
{
    @Nullable
    public static <T extends IForgeRegistryEntry<T>> T getRegistryObjectFormName(IForgeRegistry<T> registryEntry, String name) {
        return registryEntry.getEntries().stream().filter(o -> o.getValue().getRegistryName().toString().equalsIgnoreCase(name)).findFirst().get().getValue();
    }

    @Nullable
    public static <T extends IForgeRegistryEntry<T>> T getFirstValue(IForgeRegistry<T> registryEntry) {
        return registryEntry.getEntries().stream().findFirst().get().getValue();
    }
}

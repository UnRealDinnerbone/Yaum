package com.unrealdinnerbone.yaum.libs.utils;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import org.apache.commons.lang3.ObjectUtils;

import javax.annotation.Nullable;

public class RegistryUtils
{

    @Nullable
    public static <T extends IForgeRegistryEntry<T>> T getRegistryObjectFormName(IForgeRegistry<T> registryEntry, ResourceLocation location) {
        return registryEntry.containsKey(location) ? registryEntry.getValue(location) : null;
    }


    @Nullable
    public static <T extends IForgeRegistryEntry<T>> T getFirstValue(IForgeRegistry<T> registryEntry) {
        return registryEntry.getEntries().stream().findFirst().get().getValue();
    }

    public static <T extends IForgeRegistryEntry<T>> T getObjectOrElseFirst(IForgeRegistry<T> registry, ResourceLocation name) {
        return ObjectUtils.defaultIfNull(getRegistryObjectFormName(registry, name), getFirstValue(registry));
    }

}

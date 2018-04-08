package com.unrealdinnerbone.yaum.api.register;

import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RegisterHolder<T extends IForgeRegistryEntry<T>> {
    private HashMap<IForgeRegistryEntry<T>, List<IYaumObject<T>>> entryObjectsHashMap;

    public RegisterHolder() {
        entryObjectsHashMap = new HashMap<>();
    }

    public void register(T forgeRegistryEntry, IYaumObject<T> yaumObject) {
        if (!entryObjectsHashMap.containsKey(forgeRegistryEntry)) {
            entryObjectsHashMap.put(forgeRegistryEntry, new ArrayList<>());
        }
        entryObjectsHashMap.get(forgeRegistryEntry).add(yaumObject);
    }

    public HashMap<IForgeRegistryEntry<T>, List<IYaumObject<T>>> getEntryObjectsHashMap() {
        return entryObjectsHashMap;
    }

}
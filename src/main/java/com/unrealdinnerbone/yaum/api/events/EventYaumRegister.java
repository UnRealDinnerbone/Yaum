package com.unrealdinnerbone.yaum.api.events;

import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class EventYaumRegister<T extends IForgeRegistryEntry<T>> extends Event
{
    private T register;

    public EventYaumRegister(T t) {
        this.register = t;
    }

    public T getRegister() {
        return register;
    }
}

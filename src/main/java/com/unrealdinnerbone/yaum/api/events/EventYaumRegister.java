package com.unrealdinnerbone.yaum.api.events;

import com.unrealdinnerbone.yaum.api.register.YaumRegister;
import net.minecraftforge.fml.common.eventhandler.Event;

public class EventYaumBlockRegister<T extends YaumRegister<T>> extends Event
{
    private T register;

    public EventYaumBlockRegister(T t) {
        this.register = t;
    }

    public T getRegister() {
        return register;
    }
}

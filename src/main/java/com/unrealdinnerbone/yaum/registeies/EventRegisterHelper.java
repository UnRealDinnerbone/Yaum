package com.unrealdinnerbone.yaum.registeies;

import com.unrealdinnerbone.yaum.events.registeies.EventBlockRegister;
import com.unrealdinnerbone.yaum.events.registeies.EventItemRegister;
import com.unrealdinnerbone.yaum.events.registeies.EventModelRender;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.HashMap;

public class EventRegisterHelper
{
    private static HashMap<String, EventRegisterHelper> eventRegisterHelpers = new HashMap<>();

    private final String MOD_ID;

    private final EventBlockRegister eventBlockRegister;

    private final EventItemRegister eventItemRegister;

    private final EventModelRender eventModelRender;

    public EventRegisterHelper(String ModID, FMLPreInitializationEvent event)
    {
        this.MOD_ID = ModID;
        eventRegisterHelpers.put(ModID, this);
        eventBlockRegister = new EventBlockRegister(ModID);
        eventItemRegister = new EventItemRegister(ModID);
        if(event.getSide() == Side.CLIENT) {
            eventModelRender = new EventModelRender(ModID);
        } else {
            eventModelRender = null;
        }
    }

    public EventBlockRegister getEventBlockRegister() {
        return eventBlockRegister;
    }

    public EventItemRegister getEventItemRegister() {
        return eventItemRegister;
    }

    public EventModelRender getEventModelRender() throws NullPointerException {
        if(eventModelRender == null) {
            throw  new NullPointerException();
        } else {
            return eventModelRender;
        }
    }

    public static HashMap<String, EventRegisterHelper> getEventRegisterHelpers() {
        return eventRegisterHelpers;
    }
}


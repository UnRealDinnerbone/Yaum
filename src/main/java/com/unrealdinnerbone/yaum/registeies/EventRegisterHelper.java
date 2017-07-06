package com.unrealdinnerbone.yaum.registeies;

import com.unrealdinnerbone.yaum.events.registeies.EventBlockRegister;
import com.unrealdinnerbone.yaum.events.registeies.EventItemRegister;
import com.unrealdinnerbone.yaum.events.registeies.EventModelRender;
import com.unrealdinnerbone.yaum.events.registeies.EventSoundRegister;
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

    private final EventSoundRegister eventSoundRegister;

    public EventRegisterHelper(String ModID, FMLPreInitializationEvent event)
    {
        this.MOD_ID = ModID;
        eventRegisterHelpers.put(ModID, this);
        eventBlockRegister = new EventBlockRegister(ModID);
        eventItemRegister = new EventItemRegister(ModID);
        if(event.getSide() == Side.CLIENT) {
            eventSoundRegister = new EventSoundRegister(ModID);
            eventModelRender = new EventModelRender(ModID);
        } else {
            eventModelRender = null;
            eventSoundRegister = null;
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
            throw new NullPointerException("Model Render Event Registered, Is this a server?");
        } else {
            return eventModelRender;
        }
    }

    public EventSoundRegister getEventSoundRegister() throws NullPointerException {
        if (eventSoundRegister == null) {
            throw new NullPointerException("Sound Event Not Registered, Is this a server?");
        } else {
            return eventSoundRegister;
        }
    }

    public static HashMap<String, EventRegisterHelper> getEventRegisterHelpers() {
        return eventRegisterHelpers;
    }

}


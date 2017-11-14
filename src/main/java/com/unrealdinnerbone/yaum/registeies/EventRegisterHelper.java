package com.unrealdinnerbone.yaum.registeies;

import com.unrealdinnerbone.yaum.events.registeies.EventBlockRegister;
import com.unrealdinnerbone.yaum.events.registeies.EventItemRegister;
import com.unrealdinnerbone.yaum.client.event.registeies.EventModelRender;
import com.unrealdinnerbone.yaum.client.event.registeies.EventSoundRegister;
import com.unrealdinnerbone.yaum.libs.exceptions.InvadedSideException;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;

public class EventRegisterHelper
{
    private static HashMap<String, EventRegisterHelper> eventRegisterHelpers = new HashMap<>();

    private final String MOD_ID;

    private final EventBlockRegister eventBlockRegister;

    private final EventItemRegister eventItemRegister;

    private final EventModelRender eventModelRender;

    private final EventSoundRegister eventSoundRegister;

//    private final

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


    @SideOnly(Side.CLIENT)
    public EventModelRender getEventModelRender() throws InvadedSideException {
        if (FMLCommonHandler.instance().getSide().isServer()) {
            throw new InvadedSideException("Attempted to get the ModelRender form the Server");
        }else {
            return eventModelRender;
        }
    }

    @SideOnly(Side.CLIENT)
    public EventSoundRegister getEventSoundRegister() throws InvadedSideException {
        if (FMLCommonHandler.instance().getSide().isServer()) {
            throw new InvadedSideException("Attempted to get the SoundRegister form the Server");
        } else {
            return eventSoundRegister;
        }
    }

    public static HashMap<String, EventRegisterHelper> getEventRegisterHelpers() {
        return eventRegisterHelpers;
    }

}


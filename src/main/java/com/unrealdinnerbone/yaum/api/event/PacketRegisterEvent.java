package com.unrealdinnerbone.yaum.api.event;

import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketRegisterEvent extends Event
{
    private final SimpleNetworkWrapper simpleNetworkWrapper;
    private int id;

    public PacketRegisterEvent(SimpleNetworkWrapper wrapper) {
        this.simpleNetworkWrapper = wrapper;
        id = 0;
    }

    public <REQ extends IMessage, REPLY extends IMessage> void registerMessage(Class<? extends IMessageHandler<REQ, REPLY>> messageHandler, Class<REQ> requestMessageType, Side side) {
        simpleNetworkWrapper.registerMessage(messageHandler, requestMessageType, id++, side);
    }

    public int getId() {
        return id;
    }
}


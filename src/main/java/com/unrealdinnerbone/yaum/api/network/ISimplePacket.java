package com.unrealdinnerbone.yaum.api.network;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;

public interface ISimplePacket<T extends IMessage> extends IMessage, IMessageHandler<T, IMessage> {

}

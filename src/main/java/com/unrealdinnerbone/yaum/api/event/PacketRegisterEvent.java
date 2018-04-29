package com.unrealdinnerbone.yaum.api.event;

import com.unrealdinnerbone.yaum.Yaum;
import com.unrealdinnerbone.yaum.api.network.ISimplePacket;
import com.unrealdinnerbone.yaum.libs.utils.ReflectionUtils;
import com.unrealdinnerbone.yaum.libs.utils.StringUtil;
import net.minecraftforge.fml.common.eventhandler.Event;
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


    public <T extends ISimplePacket<T>> void registerMessage(Class<T> packetClass, Side side) {
        if (ReflectionUtils.hasEmptyConstructor(packetClass)) {
            simpleNetworkWrapper.registerMessage(packetClass, packetClass, id++, side);
        } else {
            Yaum.getInstance().getLogHelper().error(StringUtil.format("The packet class {0} does not have and empty constructor, it will NOT be registered", packetClass.getName()));
        }
    }


    public int getId() {
        return id;
    }
}


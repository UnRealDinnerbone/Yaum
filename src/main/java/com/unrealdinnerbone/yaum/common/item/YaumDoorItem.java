package com.unrealdinnerbone.yaum.common.item;

import com.unrealdinnerbone.yaum.common.block.YaumBlockDoor;
import com.unrealdinnerbone.yaum.api.register.impl.IYaumItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDoor;


public class YaumDoorItem extends ItemDoor implements IYaumItem {

    private YaumBlockDoor blockDoor;

    public YaumDoorItem(YaumBlockDoor blockDoor) {
        super(blockDoor);
        this.blockDoor = blockDoor;
    }

    @Override
    public Item get() {
        return this;
    }

    @Override
    public String getName() {
        return blockDoor.getName();
    }
}

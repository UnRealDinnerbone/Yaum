package com.unrealdinnerbone.yaum.api.base.item;

import com.unrealdinnerbone.yaum.api.base.block.YaumBlockDoor;
import com.unrealdinnerbone.yaum.api.register.IYaumItem;
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

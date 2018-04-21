package com.unrealdinnerbone.yaum.api.base.item;

import com.unrealdinnerbone.yaum.api.register.impl.IYaumItem;
import net.minecraft.item.Item;

public abstract class YaumItemBase extends Item implements IYaumItem
{
    @Override
    public Item get() {
        return this;
    }
}

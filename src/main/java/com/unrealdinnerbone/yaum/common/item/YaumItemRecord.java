package com.unrealdinnerbone.yaum.common.item;

import com.unrealdinnerbone.yaum.api.register.impl.IYaumItem;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.SoundEvent;

public class YaumItemRecord extends ItemRecord implements IYaumItem {

    private final String name;

    public YaumItemRecord(String name, SoundEvent soundEvent) {
        super(name, soundEvent);
        this.name = name;
    }

    @Override
    public ItemRecord get() {
        return this;
    }

    @Override
    public String getName() {
        return name;
    }
}

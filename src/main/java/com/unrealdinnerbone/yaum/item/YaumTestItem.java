package com.unrealdinnerbone.yaum.item;

import com.unrealdinnerbone.yaum.api.IYaumItem;
import com.unrealdinnerbone.yaum.yaum;
import net.minecraft.item.Item;

public class YaumTestItem extends Item implements IYaumItem {

    public YaumTestItem()
    {
        yaum.getYaumRegistry().registerItem(this);
    }

    @Override
    public String getItemName() {
        return "TestItem";
    }

    @Override
    public Item getItem() {
        return this;
    }
}

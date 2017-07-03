package com.unrealdinnerbone.yaum.item;

import com.unrealdinnerbone.yaum.registeies.YaumRegistry;
import net.minecraft.item.Item;

public class YaumItem extends Item
{

    private final String itemName;

    public YaumItem(String ModID, String itemName) {
        super();
        this.itemName = itemName;
        this.registerItem(ModID);
    }

    public String getItemName() {
        return itemName;
    }

    private void registerItem(String modid) {
        String blockName = this.itemName.toLowerCase();
        this.setUnlocalizedName(modid + "." + blockName);
        YaumRegistry.getBlockRegistries().get(modid).registerItem(this);

    }


}

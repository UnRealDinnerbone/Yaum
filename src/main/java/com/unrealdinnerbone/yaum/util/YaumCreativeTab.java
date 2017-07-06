package com.unrealdinnerbone.yaum.util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class YaumCreativeTab extends CreativeTabs {

    public YaumCreativeTab(String unlocalLisedName) {
        super(LangHelper.TAB.translateMessage("YarmTab"));
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Items.BEETROOT);
    }

    @Override
    public String getTranslatedTabLabel() {
        return LangHelper.TAB.translateMessage("YarmTab");
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }

}

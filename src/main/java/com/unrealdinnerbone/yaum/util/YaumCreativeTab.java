package com.unrealdinnerbone.yaum.util;

import com.unrealdinnerbone.yaum.yaum;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class YaumCreativeTab extends CreativeTabs {

    public YaumCreativeTab(String unlocalLisedName) {
        super(yaum.getYaumRegistry().getLangHelper().translateMessage(LangHelper.Type.TAB, unlocalLisedName));
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Items.BEETROOT);
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }

}

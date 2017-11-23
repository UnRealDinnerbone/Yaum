package com.unrealdinnerbone.yaum.libs;

import com.unrealdinnerbone.yaum.api.util.LangHelper;
import com.unrealdinnerbone.yaum.yaum;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class YaumCreativeTab extends CreativeTabs {

    public YaumCreativeTab(String unlocalLisedName) {
        super(yaum.getRegistry().getLangHelper().translateMessage(LangHelper.Type.TAB, unlocalLisedName));
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

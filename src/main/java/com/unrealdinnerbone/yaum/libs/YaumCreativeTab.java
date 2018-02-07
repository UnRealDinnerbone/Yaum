package com.unrealdinnerbone.yaum.libs;

import com.unrealdinnerbone.yaum.Yaum;
import com.unrealdinnerbone.yaum.api.util.LangHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class YaumCreativeTab extends CreativeTabs {

    public YaumCreativeTab(String unlocalLisedName) {
        super(Yaum.getLangHelper().translateMessage(LangHelper.Type.TAB, unlocalLisedName));
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

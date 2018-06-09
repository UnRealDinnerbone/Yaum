package com.unrealdinnerbone.yaum.libs;

import com.unrealdinnerbone.yaum.api.IYaumMod;
import com.unrealdinnerbone.yaum.api.util.LangHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public abstract class YaumCreativeTab extends CreativeTabs {

    public YaumCreativeTab(IYaumMod yaumMod) {
        super(yaumMod.getLangHelper().translateMessage(LangHelper.Type.TAB, yaumMod.getModName()));
    }

    @Override
    public boolean hasSearchBar() {
        return false;
    }

}

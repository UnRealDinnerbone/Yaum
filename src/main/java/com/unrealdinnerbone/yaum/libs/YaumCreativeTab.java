package com.unrealdinnerbone.yaum.libs;

import com.unrealdinnerbone.yaum.Yaum;
import com.unrealdinnerbone.yaum.api.IYaumMod;
import com.unrealdinnerbone.yaum.api.util.LangHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.ModContainer;

public class YaumCreativeTab extends CreativeTabs {

    public YaumCreativeTab(IYaumMod yaumMod) {
        super(yaumMod.getLangHelper().translateMessage(LangHelper.Type.TAB, yaumMod.getModName()));
    }

//    public YaumCreativeTab()

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Items.BEETROOT);
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }

}

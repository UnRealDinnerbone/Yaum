package com.unrealdinnerbone.yaum.util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;


public class NBTHelper
{

    public static void setString(ItemStack stack, String tag, String value) {
        NBTTagCompound tagCompound = new NBTTagCompound();
        if(stack.getTagCompound() != null) {
            tagCompound = stack.getTagCompound();
        }
        tagCompound.setString(tag, value);
    }

    public static String getString(ItemStack stack, String tag) throws  {
        if (verifyExistance(stack, tag)) {
            return getNBT(stack).getString(tag);
        } else return defaultExpected;
    }

}

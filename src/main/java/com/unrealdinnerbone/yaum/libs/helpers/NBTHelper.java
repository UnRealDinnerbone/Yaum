package com.unrealdinnerbone.yaum.libs.helpers;

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

    public static String getString(ItemStack stack, String tag) throws NullPointerException  {
        if(stack.getTagCompound() == null) {
            throw new NullPointerException();
        }
        return stack.getTagCompound().getString(tag);
    }

}

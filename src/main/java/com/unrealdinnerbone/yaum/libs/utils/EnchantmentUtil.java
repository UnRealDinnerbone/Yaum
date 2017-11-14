package com.unrealdinnerbone.yaum.util.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraft.client.Minecraft;
import net.minecraft.crash.CrashReport;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.fml.common.FMLLog;

import java.util.HashMap;

public class EnchantmentUtil
{

    public static boolean isEnchanted(ItemStack itemStack)
    {
        return EnchantmentHelper.getEnchantments(itemStack).size() > 0;
    }

    public static boolean isEnchanted(ItemStack stack, Enchantment enchantment) {
        return isEnchanted(stack, enchantment,1);
    }

    public static boolean isEnchanted(ItemStack stack, Enchantment enchantment, int minLevel) {
        return isEnchanted(stack, enchantment, minLevel, Integer.MAX_VALUE);
    }

    public static boolean isEnchanted(ItemStack stack, Enchantment enchantment, int minLevel, int maxLevel) {
        return EnchantmentHelper.getEnchantmentLevel(enchantment, stack) >= minLevel && EnchantmentHelper.getEnchantmentLevel(enchantment, stack) <= maxLevel;
    }


    //Dont Use This
    @Deprecated
    public static HashMap<Enchantment, Integer> getEnchantmentsFormItemStack(ItemStack itemStack)
    {
        FMLLog.bigWarning("THIS IS NOT SUPPORTED DON'T USE THIS");
        Minecraft.getMinecraft().crashed(new CrashReport("Mod Used No Wanted Code", new NullPointerException()));
        HashMap<Enchantment, Integer> itemEnchantments = new HashMap<>();
        NBTTagList jsonThing = itemStack.getEnchantmentTagList();
        for(NBTBase nbtTag: jsonThing)
        {
            JsonElement jelement = new JsonParser().parse(nbtTag.toString());
            JsonObject jobject = jelement.getAsJsonObject();
            itemEnchantments.put(Enchantment.getEnchantmentByID((Integer.valueOf(jobject.get("id").toString()))), Integer.valueOf(jobject.get("lvl").toString()));
        }
        return itemEnchantments;
    }

}

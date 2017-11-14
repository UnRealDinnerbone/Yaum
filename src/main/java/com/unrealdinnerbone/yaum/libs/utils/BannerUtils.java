package com.unrealdinnerbone.yaum.libs.utils;

import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemBanner;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.BannerPattern;
import net.minecraftforge.common.util.EnumHelper;

public final class BannerUtils {

    public static ItemStack createBanner(EnumDyeColor baseColor, NBTTagList patterns) {

        return ItemBanner.makeBanner(baseColor, patterns);
    }

    public static NBTTagList createPatternList(BannerLayer... layers) {
        final NBTTagList patterns = new NBTTagList();

        for (final BannerLayer layer : layers) {
            final NBTTagCompound tag = new NBTTagCompound();
            tag.setString("Pattern", layer.pattern.getHashname());
            tag.setInteger("Color", layer.color.getDyeDamage());
            patterns.appendTag(tag);
        }

        return patterns;
    }

    public static BannerPattern addBasicPattern(String name, String id) {

        final Class<?>[] paramTypes = { String.class, String.class };
        final Object[] paramValues = { name, id };
        return EnumHelper.addEnum(BannerPattern.class, name.toUpperCase(), paramTypes, paramValues);
    }

    public static BannerPattern addCraftingPattern(String name, String id, ItemStack craftingStack) {

        final Class<?>[] paramTypes = { String.class, String.class, ItemStack.class };
        final Object[] paramValues = { name, id, craftingStack };
        return EnumHelper.addEnum(BannerPattern.class, name.toUpperCase(), paramTypes, paramValues);
    }

    public static BannerPattern addDyePattern(String name, String id, String craftingTop, String craftingMid, String craftingBot) {

        final Class<?>[] paramTypes = { String.class, String.class, String.class, String.class, String.class };
        final Object[] paramValues = { name, id, craftingTop, craftingMid, craftingBot };
        return EnumHelper.addEnum(BannerPattern.class, name.toUpperCase(), paramTypes, paramValues);
    }

    public static class BannerLayer {

        private final BannerPattern pattern;

        private final EnumDyeColor color;

        public BannerLayer(BannerPattern pattern, EnumDyeColor color) {

            this.pattern = pattern;
            this.color = color;
        }

        public BannerPattern getPattern() {

            return this.pattern;
        }

        public EnumDyeColor getColor() {

            return this.color;
        }
    }
}
package com.unrealdinnerbone.yaum.client.gui;

import com.unrealdinnerbone.yaum.api.IYaumMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Set;

public interface IYaumGUIFactory extends IModGuiFactory {

    @Override
    default void initialize(Minecraft minecraftInstance) {

    }

    @Override
    default boolean hasConfigGui() {
        return true;
    }


    @Override
    default Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return null;
    }


    @Override
    default GuiScreen createConfigGui(GuiScreen guiScreen) {
        return new ModGuiConfig(guiScreen, getModInstance());
    }

    IYaumMod getModInstance();
}

package com.unrealdinnerbone.yaum.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraftforge.fml.common.ModContainer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ModGuiConfig extends GuiConfig {

    public ModGuiConfig(GuiScreen parentScreen, ModContainer container) {
        super(parentScreen, container.getModId(), container.getName());
    }

}

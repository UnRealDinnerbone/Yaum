package com.unrealdinnerbone.yaum.client.gui;

import com.unrealdinnerbone.yaum.api.IYaumMod;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.config.GuiConfig;

public class ModGuiConfig extends GuiConfig {

    public ModGuiConfig(GuiScreen parentScreen, IYaumMod mod) {
        super(parentScreen, mod.getModContainer().getModId(), mod.getModContainer().getName());
    }

}

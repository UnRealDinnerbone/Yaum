package com.unrealdinnerbone.yaum.client.gui;

import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.config.GuiConfig;

public class ModGuiConfig extends GuiConfig {

    public ModGuiConfig(GuiScreen parentScreen) {
        super(parentScreen,Reference.MOD_ID, Reference.MOD_NAME);
    }

}

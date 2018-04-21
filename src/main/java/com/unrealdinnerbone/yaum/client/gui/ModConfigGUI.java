package com.unrealdinnerbone.yaum.client.gui;

import com.unrealdinnerbone.yaum.Yaum;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Set;


public class ModConfigGUI implements IModGuiFactory
{
  @Override
  public void initialize(Minecraft minecraftInstance) {

  }

  @Override
  public boolean hasConfigGui() {
    return true;
  }

  @SideOnly(Side.CLIENT)
  @Override
  public GuiScreen createConfigGui(GuiScreen guiScreen) {
    return new ModGuiConfig(guiScreen, Yaum.getInstance());
  }

  @Override
  public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
    return null;
  }

}

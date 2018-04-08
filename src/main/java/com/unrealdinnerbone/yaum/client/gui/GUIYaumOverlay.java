package com.unrealdinnerbone.yaum.client.gui;

import com.unrealdinnerbone.yaum.libs.utils.ColorUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public abstract class GUIYaumOverlay extends Gui
{

    protected int displaySecs;
    protected Minecraft minecraft;
    protected ScaledResolution scaledResolution;
    protected FontRenderer fontRenderer;
    protected TextureManager renderEngine;
    protected int width;
    protected int height;

    public GUIYaumOverlay(int displaySecs) {
        super();
        this.displaySecs = displaySecs;
        this.minecraft = Minecraft.getMinecraft();
        this.fontRenderer = minecraft.fontRenderer;
        this.renderEngine = minecraft.renderEngine;
        this.scaledResolution = new ScaledResolution(minecraft);
        this.width = scaledResolution.getScaledWidth();
        this.height = scaledResolution.getScaledHeight();
    }

    public int getDisplayTime() {
        return displaySecs * 1000;
    }

    public void drawString(FontRenderer fontRendererIn, String text, int x, int y) {
        super.drawString(fontRendererIn, ColorUtil.format(text), x, y, 1);
    }


    public void drawCenteredString(String text, int x, int y) {
        super.drawCenteredString(fontRenderer, ColorUtil.format(text), x, y, 1);
    }


    public abstract void drawOverlay();

}

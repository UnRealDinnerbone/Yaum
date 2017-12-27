package com.unrealdinnerbone.yaum.client.render;

import com.unrealdinnerbone.yaum.api.render.IYaumRenderLayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class PlayerRenderLayer implements IYaumRenderLayer<EntityPlayer> {

    private ItemStack itemStackToRender;
    public static int renderCount;

    public PlayerRenderLayer(ItemStack itemStackToRender) {
        this.itemStackToRender = itemStackToRender;
        renderCount = renderCount >= 60 ? 0 : renderCount + 1;
    }


    @Override
    public void doRenderLayer(EntityPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        GlStateManager.pushMatrix();
        GlStateManager.rotate(180, 0, 0, 1);
        GlStateManager.scale(0.6, 0.6, 0.6);
        GlStateManager.rotate((ageInTicks + renderCount) / 20.0F * (180F / (float) Math.PI), 0.0F, 1.0F, 0.0F);
        GlStateManager.translate(0, player.height - player.eyeHeight + 0.5, renderCount);
        Minecraft.getMinecraft().getRenderItem().renderItem(itemStackToRender, ItemCameraTransforms.TransformType.FIXED);
        GlStateManager.popMatrix();
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}

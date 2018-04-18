package com.unrealdinnerbone.yaum.client.render;

import com.unrealdinnerbone.yaum.api.render.IYaumRenderLayer;
import com.unrealdinnerbone.yaum.perks.StatsGetter;
import com.unrealdinnerbone.yaum.perks.Supporter;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

@SideOnly(Side.CLIENT)
public class PlayerRenderLayer implements IYaumRenderLayer<EntityPlayer> {

    private static ItemStack itemStack;

    private static ItemStack itemStack2;


    @GameRegistry.ObjectHolder("cutepuppymod:herobrinecoreblock")
    private static final Block block = null;

    static {
        itemStack = new ItemStack(Blocks.BEACON);
        itemStack2 = new ItemStack(Blocks.PLANKS);
    }

    @Override
    public void doRenderLayer(EntityPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if (StatsGetter.isSupporter(player)) {
            Supporter supporter = StatsGetter.getSupporter(player);
            if (supporter.getType().equalsIgnoreCase("Dev")) {
                if (block == null) {
                    render(player, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale, itemStack);
                } else {
                    render(player, limbSwing, limbSwing, partialTicks, ageInTicks, netHeadYaw, headPitch, scale, new ItemStack(block));
                }
            } else if (supporter.getType().equalsIgnoreCase("Friend")) {
                render(player, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale, itemStack2);
            }
        }
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }

    public void render(EntityPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale, ItemStack itemStack) {
        if (!player.isInvisible() || !player.isSpectator()) {
            GlStateManager.pushMatrix();
            GlStateManager.rotate(180, 0, 0, 1);
            GlStateManager.scale(0.6, 0.6, 0.6);
            GlStateManager.rotate((ageInTicks) / (200) * (360F / (float) Math.PI), 0, partialTicks, 0.0F);
            if (player.isSneaking()) {
                GlStateManager.translate(0, -0.25f, 0);
            }
            GlStateManager.translate(-0.5, player.height - player.eyeHeight + 1, -0.5);
            Minecraft.getMinecraft().getRenderItem().renderItem(itemStack, ItemCameraTransforms.TransformType.FIXED);
            GlStateManager.popMatrix();
        }
    }
}

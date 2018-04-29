package com.unrealdinnerbone.yaum.client.render;

import com.unrealdinnerbone.yaum.api.render.IYaumRenderLayer;
import com.unrealdinnerbone.yaum.common.perks.StatsGetter;
import com.unrealdinnerbone.yaum.common.perks.Supporter;
import com.unrealdinnerbone.yaum.libs.utils.RegistryUtils;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class PlayerRenderLayer implements IYaumRenderLayer<EntityPlayer> {

    private static ItemStack itemStack;

    private static ItemStack itemStack2;


    static {
        itemStack = new ItemStack(Blocks.BEACON);
        Block block = RegistryUtils.getRegistryObjectFormName(ForgeRegistries.BLOCKS, new ResourceLocation("cutepuppymod", "herobrinecoreblock"));
        if (block == null) {
            block = Blocks.EMERALD_BLOCK;
        }
        itemStack2 = new ItemStack(block);
    }

    @Override
    public void doRenderLayer(EntityPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if (StatsGetter.isSupporter(player)) {
            Supporter supporter = StatsGetter.getSupporter(player);
            if (supporter.getType().equalsIgnoreCase("Dev")) {
                render(player, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale, itemStack);
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

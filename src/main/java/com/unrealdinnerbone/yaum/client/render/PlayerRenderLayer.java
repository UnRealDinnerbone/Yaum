package com.unrealdinnerbone.yaum.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

@SideOnly(Side.CLIENT)
public class PlayerRenderLayer implements LayerRenderer<EntityPlayer> {

    @Override
    public void doRenderLayer(EntityPlayer player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
//        if(player.getName().equalsIgnoreCase())
        List<List<ItemStack>> listofListItemStacks = new ArrayList<>();
        List<ItemStack> stacks = new ArrayList<>();
        stacks.add(new ItemStack(Blocks.BEACON));
        stacks.add(new ItemStack(Blocks.DIAMOND_BLOCK));
        stacks.add(new ItemStack(Blocks.BOOKSHELF));

        List<ItemStack> stacks2 = new ArrayList<>();
        stacks2.add(new ItemStack(Blocks.BOOKSHELF));
        stacks2.add(new ItemStack(Blocks.DIAMOND_BLOCK));
        stacks2.add(new ItemStack(Blocks.BEACON));

        List<ItemStack> stacks3 = new ArrayList<>();
        stacks2.add(new ItemStack(Blocks.BOOKSHELF));
        stacks2.add(new ItemStack(Blocks.DIAMOND_BLOCK));
        stacks2.add(new ItemStack(Blocks.BEACON));
        stacks3.add(new ItemStack(Blocks.BOOKSHELF));
        stacks3.add(new ItemStack(Blocks.DIAMOND_BLOCK));
        stacks.add(new ItemStack(Blocks.BEACON));
        listofListItemStacks.add(stacks);
        listofListItemStacks.add(stacks2);
        listofListItemStacks.add(stacks3);


        for (int i = 0, listofListItemStacksSize = listofListItemStacks.size(); i < listofListItemStacksSize; i++) {
            List<ItemStack> stackList = listofListItemStacks.get(i);
            for (int i1 = 0, stackListSize = stackList.size(); i1 < stackListSize; i1++) {
                ItemStack itemStack = stackList.get(i1);
                GlStateManager.pushMatrix();
                GlStateManager.rotate(180, i, 0, 1);
                GlStateManager.scale(0.6, 0.6, 0.6);
                GlStateManager.rotate((ageInTicks) / (20.0F) * (180F / (float) Math.PI), 0.0F, 1.0F, 0.0F);
                GlStateManager.translate(0, player.height - player.eyeHeight + 0.5 + i1 - (i1 * 0.5), 1);
                Minecraft.getMinecraft().getRenderItem().renderItem(itemStack, ItemCameraTransforms.TransformType.FIXED);
                GlStateManager.popMatrix();
            }

        }




    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}

package com.unrealdinnerbone.yaum.libs.utils;

import com.google.common.util.concurrent.AtomicDouble;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RenderUtil
{
    public static void renderBlocksInWorld(BlockPos connor1, BlockPos connor2, IBlockState blockState) {
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();
        buffer.setTranslation(-TileEntityRendererDispatcher.staticPlayerX, -TileEntityRendererDispatcher.staticPlayerY, -TileEntityRendererDispatcher.staticPlayerZ);
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.BLOCK);
        BlockPos.getAllInBox(connor1, connor2).forEach(block -> Minecraft.getMinecraft().getBlockRendererDispatcher().renderBlock(blockState, block, Minecraft.getMinecraft().world, buffer));
        buffer.setTranslation(0, 0, 0);
        Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        RenderHelper.disableStandardItemLighting();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.enableBlend();
        GlStateManager.disableCull();
        GlStateManager.shadeModel(Minecraft.isAmbientOcclusionEnabled() ? GL11.GL_SMOOTH : GL11.GL_FLAT);
        buffer.sortVertexData(0, 0, 0);
        tessellator.draw();
        RenderHelper.enableStandardItemLighting();
    }

    public static void renderFluid(BlockPos connor1, BlockPos connor2, BlockRenderLayer layer) {
        AtomicDouble totalHight = new AtomicDouble(0);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder buffer = tessellator.getBuffer();
        buffer.setTranslation(connor1.getX() - TileEntityRendererDispatcher.staticPlayerX, connor1.getY() - TileEntityRendererDispatcher.staticPlayerY, connor1.getZ() - TileEntityRendererDispatcher.staticPlayerZ);
        for(BlockPos p: BlockPos.getAllInBox(new BlockPos(0, 0, 0), connor2)) {
            List<FluidStack> baconIsh = new ArrayList<>();
            baconIsh.add(new FluidStack(FluidRegistry.WATER, 1000));
            baconIsh.add(new FluidStack(FluidRegistry.LAVA, 1000));

            float yMult = 1f / 1;

            Map<FluidStack, Integer> fluids = new HashMap<>();
            for(FluidStack fluidStack: baconIsh) {
                fluids.put(fluidStack, 1000);
            }
            totalHight.set(0);
            fluids.forEach((stack, amt) -> {
                float hight = amt * yMult;
                float yPos = (float) totalHight.getAndAdd(hight);

                if(stack.getFluid().getBlock().canRenderInLayer(stack.getFluid().getBlock().getDefaultState(), layer)) {
                    ResourceLocation texuterePath = stack.getFluid().getStill(stack);
                    TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks().registerSprite(texuterePath);

                    //Top
                    buffer.pos(p.getX(), p.getY() + yPos + hight, p.getZ()).tex(sprite.getMaxU(), sprite.getMinV()).endVertex();
                    buffer.pos(p.getX(), p.getY() + yPos + hight, p.getZ() + 1).tex(sprite.getMaxU(), sprite.getMinV()).endVertex();
                    buffer.pos(p.getX() + 1, p.getY() + yPos + hight, p.getZ() + 1).tex(sprite.getMaxU(), sprite.getMinV()).endVertex();
                    buffer.pos(p.getX() + 1, p.getY() + yPos + hight, p.getZ()).tex(sprite.getMaxU(), sprite.getMinV()).endVertex();

                    if(p.getX() == 0) {
                        buffer.pos(p.getX(), p.getY() + yPos + hight, p.getZ()).tex(sprite.getMaxU(), sprite.getMinV()).endVertex();
                        buffer.pos(p.getX(), p.getY() + yPos + hight, p.getZ() + 1).tex(sprite.getMaxU(), sprite.getMinV()).endVertex();
                    }
                    if(p.getX() == connor2.getX() - 1) {
                        buffer.pos(p.getX() + 1, p.getY() + yPos + hight, p.getZ() + 1).tex(sprite.getMaxU(), sprite.getMinV()).endVertex();
                        buffer.pos(p.getX() + 1, p.getY() + yPos + hight, p.getZ()).tex(sprite.getMaxU(), sprite.getMinV()).endVertex();
                    }
                    if(p.getZ() == 0) {

                    }
                    if(p.getZ() == connor2.getX() - 1) {

                    }
                }
            });
        }
    }
}

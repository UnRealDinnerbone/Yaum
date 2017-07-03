package com.unrealdinnerbone.yaum.block;

import com.unrealdinnerbone.yaum.registeies.YaumRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class YaumBlock extends Block {

  private String blockName = null;

  public YaumBlock(String ModID, Material material, String blockName) {
    super(material);
    this.blockName = blockName;
    this.registerBlock(ModID);
  }

  public String getBlockName() {
    return blockName;
  }

  protected void registerBlock(String modid) {
    String blockName = this.blockName.toLowerCase();
    this.setUnlocalizedName(modid + "." + blockName);
    YaumRegistry.getBlockRegistries().get(modid).registerBlock(this);
  }

}
//    ProgressManager.ProgressBar bakeBar = ProgressManager.push("Yaum : Rendering Blocks", blocks.size());
// bakeBar.step(modid + ":" + block.getItemName());
// ProgressManager.pop(bakeBar);
package com.unrealdinnerbone.yaum.libs.utils;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityRegisterUtil {

  private Object mod;
  private int id;

  public EntityRegisterUtil(Object mod) {
    this.mod = mod;
    this.id = 1;
  }


  public void registerEntity(ResourceLocation resourceLocation, Class<? extends Entity> entityClass,  IRenderFactory renderFactory, String entityName, int eggPrimary, int eggSecondary)
  {
    EntityRegistry.registerModEntity(resourceLocation, entityClass, entityName, id, this.mod, 64, 3, true, eggPrimary, eggSecondary);

    //Todo Move to general only sytem
    if(ServerUtil.isClient())
    RenderingRegistry.registerEntityRenderingHandler(entityClass, renderFactory);
  }



  public Object getMod() {
    return mod;
  }
}

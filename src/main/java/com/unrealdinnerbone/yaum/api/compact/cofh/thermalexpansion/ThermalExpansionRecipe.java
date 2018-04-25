package com.unrealdinnerbone.yaum.api.compact.cofh.thermalexpansion;

import com.unrealdinnerbone.yaum.api.compact.IRecipe;

import javax.annotation.Nonnull;

public abstract class ThermalExpansionRecipe implements IRecipe
{

    @Nonnull
    @Override
    public String getModID() {
        return "thermalexpansion";
    }

}

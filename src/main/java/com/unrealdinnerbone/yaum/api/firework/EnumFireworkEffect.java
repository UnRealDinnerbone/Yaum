package com.unrealdinnerbone.yaum.api.firework;

import javax.annotation.Nullable;
import java.util.Arrays;

public enum EnumFireworkEffect
{
    FLICKER("Flicker", 0),
    TRAIL("Trail", 1);

    private final String effectName;
    private final int explodeID;

    EnumFireworkEffect(String effectName, int id) {
        this.effectName = effectName;
        this.explodeID = id;
    }

    public String getEffectName() {
        return effectName;
    }

    public int getExplodeID() {
        return explodeID;
    }

    @Nullable
    public static EnumFireworkEffect getEffectFormID(int id) {
        return Arrays.stream(values()).filter(enumExplodeEffect -> enumExplodeEffect.explodeID == id).findFirst().orElse(null);
    }
}

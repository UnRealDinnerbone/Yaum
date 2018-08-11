package com.unrealdinnerbone.yaum.api.firework;

import javax.annotation.Nullable;
import java.util.Arrays;

public enum EnumExplodeEffect
{
    SMALL_BALL(0),
    LAVAGE_BALL(2),
    STAR(3),
    CREEPER_FACE(4),
    SPARKLE(5);

    private int explodeID;

    EnumExplodeEffect(int explodeID) {
        this.explodeID = explodeID;
    }

    public int getExplodeID() {
        return explodeID;
    }


    @Nullable
    public static EnumExplodeEffect getEffectFormID(int id) {
        return Arrays.stream(values()).filter(enumExplodeEffect -> enumExplodeEffect.explodeID == id).findFirst().orElse(null);
    }
}

package com.unrealdinnerbone.yaum.test;

import com.unrealdinnerbone.yaum.api.register.IYaumObject;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class PortalSound extends SoundEvent implements IYaumObject<SoundEvent> {

    public PortalSound() {
        super(new ResourceLocation(Reference.MOD_ID, "music.stillalive"));
    }

    @Override
    public SoundEvent get() {
        return this;
    }

    @Override
    public String getName() {
        return "stillAlive";
    }


}

package com.unrealdinnerbone.yaum.test;

import com.unrealdinnerbone.yaum.api.base.block.YaumBlockDoor;
import com.unrealdinnerbone.yaum.api.register.annotation.Register;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraft.block.material.Material;

@Register(Reference.MOD_ID)
public class TestDoor extends YaumBlockDoor {

    public TestDoor() {
        super(Material.WOOD);
    }

    @Override
    public String getName() {
        return "testDoor";
    }
}

package com.unrealdinnerbone.yaum.api.annoations;

import com.unrealdinnerbone.yaum.api.handlers.*;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Register {


    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface Block {
        String modID();

        String name();

        Class<? extends Handler<net.minecraft.block.Block>> registerHandlerBlock() default HandlerBlockRegister.class;

        Class<? extends Handler<net.minecraft.item.Item>> registerHandlerItem() default HandlerItemBlockRegister.class;

    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface Item {
        String modID();

        String name();

        Class<? extends Handler<net.minecraft.item.Item>> registerHandler() default HandlerItemRegister.class;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface Enchantment {
        String modID();

        String name();

        Class<? extends Handler<net.minecraft.enchantment.Enchantment>> registerHandler() default HandlerEnchantmentRegister.class;
    }

}





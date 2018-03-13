//package com.unrealdinnerbone.old.annoations;
//
//import com.unrealdinnerbone.yaum.api.handlers.*;
//
//import java.lang.annotation.*;
//
//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE)
//public @interface Register {
//
//
//    @Retention(RetentionPolicy.RUNTIME)
//    @Target(ElementType.TYPE)
//    @interface Block {
//        String modID();
//
//        String name();
//
//        Class<? extends Handler<net.minecraft.block.Block>> registerHandlerBlock() default HandlerBlockRegister.class;
//
//        Class<? extends Handler<net.minecraft.item.Item>> registerHandlerItem() default HandlerItemBlockRegister.class;
//
//    }
//
//    @Retention(RetentionPolicy.RUNTIME)
//    @Target(ElementType.TYPE)
//    @interface Item {
//        String modID();
//
//        String name();
//
//        Class<? extends Handler<net.minecraft.item.Item>> registerHandler() default HandlerItemRegister.class;
//    }
//
//    @Retention(RetentionPolicy.RUNTIME)
//    @Target(ElementType.TYPE)
//    @interface Enchantment {
//        String modID();
//
//        String name();
//
//        Class<? extends Handler<net.minecraft.enchantment.Enchantment>> registerHandler() default HandlerEnchantmentRegister.class;
//    }
//
//}
//
//        initItems(event.getAsmData().getAll(Register.Item.class.getName()));
//        initBlocks(event.getAsmData().getAll(Register.Block.class.getName()));
//        initEnchantments(event.getAsmData().getAll(Register.Enchantment.class.getName()));


//    }

//    private void initEnchantments(Set<ASMDataTable.ASMData> dataSet) {
//        for (ASMDataTable.ASMData data : dataSet) {
//            Class enchantmentClass = ReflectionUtils.getClassFormName(data.getClassName());
//            Object enchantmentObject = ReflectionUtils.createInstance(enchantmentClass);
//            if (enchantmentObject != null) {
//
//                if (enchantmentClass.isAnnotationPresent(Register.Enchantment.class)) {
//                    Register.Enchantment enchantmentAnnotation = (Register.Enchantment) enchantmentClass.getAnnotation(Register.Enchantment.class);
//                    if (enchantmentObject instanceof Enchantment) {
//                        Enchantment enchantment = (Enchantment) enchantmentObject;
//                        if(enchantment instanceof IConfigRegister) {
//                            IConfigRegister register = (IConfigRegister) enchantment;
//                            if(!register.doRegistration()) {
//                                break;
//                            }
//                        }
//                        Handler<Enchantment> handler = ReflectionUtils.createInstance(enchantmentAnnotation.registerHandler());
//                        ObjectWrapper<Enchantment> enchementWrapper = new ObjectWrapper<>(enchantment, enchantmentAnnotation.name(), enchantmentAnnotation.modID());
//                        Registry.registerEnchantment(enchementWrapper, handler);
//                    } else {
//                        Yaum.getLogHelper().error("The class " + data.getClassName() + " is marked to load as a block but does extend Block");
//                    }
//                }
//            }
//        }
//    }
//
//
//    private void initBlocks(Set<ASMDataTable.ASMData> dataSet) {
//        for (ASMDataTable.ASMData data : dataSet) {
//            Class blockClass = ReflectionUtils.getClassFormName(data.getClassName());
//            Object classObject = ReflectionUtils.createInstance(blockClass);
//            if (classObject != null) {
//                if (blockClass.isAnnotationPresent(Register.Block.class)) {
//                    Register.Block blockAnnotation = (Register.Block) blockClass.getAnnotation(Register.Block.class);
//                    if (classObject instanceof Block) {
//                        Block block = (Block) classObject;
//                        if(block instanceof IConfigRegister) {
//                            IConfigRegister register = (IConfigRegister) block;
//                            if(!register.doRegistration()) {
//                                break;
//                            }
//                        }
//                        Handler<Block> blockHandler = ReflectionUtils.createInstance(blockAnnotation.registerHandlerBlock());
//                        ObjectWrapper<Block> blockWrapper = new ObjectWrapper<>(block, blockAnnotation.name(), blockAnnotation.modID());
//                        Handler<Item> itemHandler = ReflectionUtils.createInstance(blockAnnotation.registerHandlerItem());
//                        ObjectWrapper<Item> itemWrapper = new ObjectWrapper<>(new ItemBlock(block), blockAnnotation.name(), blockAnnotation.modID());
//                        Registry.registerBlock(blockWrapper, blockHandler, itemWrapper, itemHandler);
//                    } else {
//                        Yaum.getLogHelper().error("The class " + data.getClassName() + " is marked to load as a block but does extend Block");
//                    }
//                }
//            }
//        }
//    }
//
//    private void initItems(Set<ASMDataTable.ASMData> dataSet) {
//        for (ASMDataTable.ASMData data : dataSet) {
//            Class itemClass = ReflectionUtils.getClassFormName(data.getClassName());
//            Object itemObejct = ReflectionUtils.createInstance(itemClass);
//            if (itemObejct != null) {
//                if (itemClass.isAnnotationPresent(Register.Item.class)) {
//                    Register.Item itemAnnotation = (Register.Item) itemClass.getAnnotation(Register.Item.class);
//                    if (itemObejct instanceof Item) {
//                        Item item = (Item) itemObejct;
//                        if(item instanceof IConfigRegister) {
//                            IConfigRegister register = (IConfigRegister) item;
//                            if(!register.doRegistration()) {
//                                break;
//                            }
//                        }
//                        Handler<Item> itemHandler = ReflectionUtils.createInstance(itemAnnotation.registerHandler());
//                        ObjectWrapper<Item> itemWrapper = new ObjectWrapper<>(item, itemAnnotation.name(), itemAnnotation.modID());
//                        Registry.registerItem(itemWrapper, itemHandler);
//                    } else {
//                        Yaum.getLogHelper().error("The class " + data.getClassName() + " is marked to load as a item but does extend Item");
//                    }
//                }
//            }
//        }
//
//    }





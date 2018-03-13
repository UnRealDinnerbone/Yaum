//package com.unrealdinnerbone.old;
//
//import com.unrealdinnerbone.yaum.Yaum;
//
//import javax.annotation.Nullable;
//
//public class ReflectionUtils
//{
//    @Nullable
//    public static Class<?> getClassFormName(String name) {
//        try {
//            return Class.forName(name);
//        } catch (ClassNotFoundException e) {
//            Yaum.getLogHelper().error("Error the class " + name + " is not there");
//            return null;
//        }
//    }
//
//    @Nullable
//    public static <T> T createInstance(Class<T> classToMake) {
//        try {
//            return classToMake.newInstance();
//        } catch (IllegalAccessException | InstantiationException e) {
//            Yaum.getLogHelper().error("Error the class " + classToMake.getName() + " does not have and empty constructor");
//            return null;
//        }
//    }
//}

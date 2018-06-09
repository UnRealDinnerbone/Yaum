package com.unrealdinnerbone.yaum.api.register;

import com.unrealdinnerbone.yaum.Yaum;
import com.unrealdinnerbone.yaum.api.IYaumMod;
import com.unrealdinnerbone.yaum.api.util.LangHelper;
import com.unrealdinnerbone.yaum.api.util.LogHelper;

import java.util.*;

public class Register {

    private static final HashMap<Class<?>, List<Map.Entry<IYaumMod, IYaumObject>>> registeredObject;

    static {
        registeredObject = new HashMap<>();
    }

    public static void register(IYaumMod mod, IYaumObject iYaumObject) {
        if (!registeredObject.containsKey(iYaumObject.get().getRegistryType())) {
            registeredObject.put(iYaumObject.get().getRegistryType(), new ArrayList<>());
        }
        registeredObject.get(iYaumObject.get().getRegistryType()).add(new AbstractMap.SimpleEntry<>(mod, iYaumObject));
        iYaumObject.onRegister(mod);
    }


    public static void register(String modName, IYaumObject yaumObject) {
        IYaumMod mod = new DummyMod(modName);
        register(mod, yaumObject);
    }

    public static HashMap<Class<?>, List<Map.Entry<IYaumMod, IYaumObject>>> getRegisteredObject() {
        return registeredObject;
    }

    private static final class DummyMod implements IYaumMod {

        private final String MOD_NAME;

        DummyMod(String modName) {
            this.MOD_NAME = modName;
        }


        @Override
        public String getModName() {
            return MOD_NAME;
        }

        @Override
        public LogHelper getLogHelper() {
            return Yaum.getInstance().getLogHelper();
        }

        @Override
        public LangHelper getLangHelper() {
            return Yaum.getInstance().getLangHelper();
        }
    }
}

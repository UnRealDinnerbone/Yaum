package com.unrealdinnerbone.yaum.loader;

import com.unrealdinnerbone.yaum.api.IYaumRegisterObject;

public class ObjectWrapper<T> implements IYaumRegisterObject<T> {

    private T t;
    private String name;
    private String modID;

    public ObjectWrapper(T t, String name, String modID) {
            this.t = t;
            this.name = name;
            this.modID = modID;
    }

    @Override
    public T get() {
        return t;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getModID() {
        return modID;
    }

}

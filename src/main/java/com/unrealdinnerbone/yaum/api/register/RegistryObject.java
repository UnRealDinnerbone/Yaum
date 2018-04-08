package com.unrealdinnerbone.yaum.api.register;


import com.unrealdinnerbone.yaum.api.IYaumMod;

public class RegistryObject {

    private IYaumMod mod;
    private IYaumObject yaumObject;

    public RegistryObject(IYaumMod mod, IYaumObject yaumObject) {
        this.mod = mod;
        this.yaumObject = yaumObject;
    }

    public IYaumMod getMod() {
        return mod;
    }

    public IYaumObject getYaumObject() {
        return yaumObject;
    }
}
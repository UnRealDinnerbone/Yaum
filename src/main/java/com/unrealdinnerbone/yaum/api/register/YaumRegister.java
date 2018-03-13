package com.unrealdinnerbone.yaum.api.register;

import com.unrealdinnerbone.yaum.api.IYaumRegisterObject;
import com.unrealdinnerbone.yaum.api.handlers.Handler;
import com.unrealdinnerbone.yaum.libs.Wrapper;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.ArrayList;

public class YaumRegister3<T extends IForgeRegistryEntry<T>> {

    private ArrayList<Wrapper<IYaumRegisterObject<T>, Handler<T>>> wrapperList;

    public YaumRegister3() {
        this.wrapperList = new ArrayList<>();
    }

    public void register(IYaumRegisterObject<T> registerObject, Handler<T> handler) {
        this.wrapperList.add(new Wrapper<>(registerObject, handler));
    }

    public ArrayList<Wrapper<IYaumRegisterObject<T>, Handler<T>>> getWrapperList() {
        return this.wrapperList;
    }


}

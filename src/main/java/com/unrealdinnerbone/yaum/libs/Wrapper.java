package com.unrealdinnerbone.yaum.libs;


import javax.annotation.Nullable;

public class Wrapper<A,B> {

    @Nullable
    private A a;
    @Nullable
    private B b;

    @Nullable
    public Wrapper(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Nullable
    public A getA() {
        return a;
    }

    @Nullable
    public B getB() {
        return b;
    }
}

package com.unrealdinnerbone.yaum.test;

import com.unrealdinnerbone.yaum.Yaum;
import com.unrealdinnerbone.yaum.api.register.Register;


public class TestHolder {

    public static PortalSound portalSound;

    public static void init() {
        portalSound = new PortalSound();
        Register.register(Yaum.getInstance(), portalSound);
    }
}

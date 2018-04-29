package com.unrealdinnerbone.yaum.test;

import com.unrealdinnerbone.yaum.api.register.annotation.Register;
import com.unrealdinnerbone.yaum.common.item.YaumItemRecord;
import com.unrealdinnerbone.yaum.libs.Reference;

@Register(Reference.MOD_ID)
public class TestRecord extends YaumItemRecord {

    public TestRecord() {
        super("record_stillAlive", TestHolder.portalSound);
    }

}

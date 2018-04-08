package com.unrealdinnerbone.yaum.refelction;

import com.unrealdinnerbone.yaum.Yaum;
import com.unrealdinnerbone.yaum.api.register.IConfgRegister;
import com.unrealdinnerbone.yaum.api.register.IYaumObject;
import com.unrealdinnerbone.yaum.api.register.annotation.Register;
import com.unrealdinnerbone.yaum.libs.utils.ReflectionUtils;
import net.minecraftforge.fml.common.discovery.ASMDataTable;

import java.util.Set;

public class ReflectionHandler {

    public static void handleLoading(ASMDataTable dataTable) {
        initBlocks(dataTable.getAll(Register.class.getName()));
    }

    private static void initBlocks(Set<ASMDataTable.ASMData> dataSet) {
        for (ASMDataTable.ASMData data : dataSet) {
            Class objectClass = ReflectionUtils.getClassFormName(data.getClassName());
            if (objectClass != null) {
                Object classObject = ReflectionUtils.createInstance(objectClass);
                if (classObject != null) {
                    if (objectClass.isAnnotationPresent(Register.class)) {
                        Register objectAnnotation = (Register) objectClass.getAnnotation(Register.class);
                        if (classObject instanceof IConfgRegister) {
                            IConfgRegister register = (IConfgRegister) classObject;
                            if (!register.doRegistration()) {
                                Yaum.getInstance().getLogHelper().debug(classObject.getClass().getName() + " is not going to be registered");
                                break;
                            }
                        }
                        if (classObject instanceof IYaumObject) {
                            IYaumObject yaumObject = (IYaumObject) classObject;
                            com.unrealdinnerbone.yaum.api.Register.register(objectAnnotation.modID(), yaumObject);
                        } else {
                            Yaum.getInstance().getLogHelper().error(classObject.getClass().getName() + " is not going to registered since it does not implement IYaumObject ");
                        }
                    }
                }
            }
        }
    }
}
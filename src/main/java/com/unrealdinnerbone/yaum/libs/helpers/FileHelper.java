package com.unrealdinnerbone.yaum.libs.helpers;

import com.unrealdinnerbone.yaum.Yaum;
import io.netty.util.internal.StringUtil;
import net.minecraft.world.storage.ThreadedFileIOBase;
import org.apache.commons.io.FileUtils;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileHelper
{

    public static void writeStringToFile(String info, @Nonnull File file, boolean useThread) {
        if(useThread) {
            ThreadedFileIOBase.getThreadedIOInstance().queueIO(() -> {
                writeStringToFile(info, file, false);
                return false;
            });
        }
        try {
            FileUtils.writeStringToFile(file, info, StandardCharsets.UTF_8);
        } catch (IOException ioException) {
            Yaum.getInstance().getLogHelper().error("There was and error while writing string to file " + file.getName());
        }
    }
}

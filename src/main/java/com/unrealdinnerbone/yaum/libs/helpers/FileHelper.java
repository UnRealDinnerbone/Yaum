package com.unrealdinnerbone.yaum.libs.helpers;

import net.minecraft.world.storage.ThreadedFileIOBase;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FileHelper
{


    public static void writeStringToFileThered(String info, File file) {
        ThreadedFileIOBase.getThreadedIOInstance().queueIO(() -> {
            try {
                FileUtils.writeStringToFile(file, info, StandardCharsets.UTF_8);
            } catch (IOException ioException ) {

            }
            return false;
        });
    }
    public static void writeStringToFile(String info, File file) {
        try {
            FileUtils.writeStringToFile(file, info, StandardCharsets.UTF_8);
        } catch (IOException ioException) {

        }
    }
}

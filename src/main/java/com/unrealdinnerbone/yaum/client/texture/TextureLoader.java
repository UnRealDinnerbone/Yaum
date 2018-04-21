package com.unrealdinnerbone.yaum.client.texture;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.unrealdinnerbone.yaum.Yaum;
import com.unrealdinnerbone.yaum.api.texture.TextureRegister;
import com.unrealdinnerbone.yaum.api.texture.TextureWrapper;
import com.unrealdinnerbone.yaum.api.texture.WebTexture;
import com.unrealdinnerbone.yaum.libs.Reference;
import com.unrealdinnerbone.yaum.libs.helpers.DownloadHelper;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@SideOnly(Side.CLIENT)
public class TextureLoader {

    private static HashMap<String, TextureWrapper> textureWrappers = new HashMap<>();
    private final static Gson gson = new GsonBuilder().create();

    @SideOnly(Side.CLIENT)
    public static void reload() {
        for (Map.Entry<String, String> stringStringEntry : TextureRegister.getTextureManagerList()) {
            String id = stringStringEntry.getKey();
            String url = stringStringEntry.getValue();
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                JsonReader reader = new JsonReader(new InputStreamReader((InputStream) connection.getContent()));
                TextureWrapper textureWrapper = gson.fromJson(reader, TextureWrapper.class);
                textureWrappers.put(id, textureWrapper);
                if (textureWrapper.getModID() != null) {
                    if (Loader.isModLoaded(textureWrapper.getModID())) {
                        for (WebTexture texture : textureWrapper.getTextures()) {
                            if (texture.getId() != null && !texture.getId().isEmpty()) {
                                if (texture.getUrl() != null && !texture.getUrl().isEmpty()) {
                                    DownloadHelper.downloadResourceLocation(texture.getUrl(), texture.getLocation(), Reference.TEXTURE_404);
                                } else {
                                    Yaum.getInstance().getLogHelper().error("TextureLoader with value has and invalid texture url null/empty texture id " + texture.getId());
                                }
                            } else {
                                Yaum.getInstance().getLogHelper().error("TextureLoader with value has and invalid texture no id gives/empty");
                            }
                        }
                    } else {
                        Yaum.getInstance().getLogHelper().error("TextureLoader with the url " + url + " will not load since it has the value " + textureWrapper.getModID() + " but that mod id is not in game");
                    }
                } else {
                    Yaum.getInstance().getLogHelper().error("Failed to init the TextureLoader with the url " + url);
                }

                reader.close();
            } catch (final IOException e) {
                Yaum.getInstance().getLogHelper().error("Failed to load the TextureLoader with the url " + url + " json is not right");
            }
        }
    }

    public static HashMap<String, TextureWrapper> getTextureWrappers() {
        return textureWrappers;
    }
}

package com.unrealdinnerbone.yaum.texture;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.unrealdinnerbone.yaum.Yaum;
import com.unrealdinnerbone.yaum.libs.Reference;
import com.unrealdinnerbone.yaum.libs.helpers.DownloadHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@SideOnly(Side.CLIENT)
public class TextureManager
{
    private static List<TextureManager> textureManagerList;

    static {
        textureManagerList = new ArrayList<>();
    }

    private String url;
    private TextureWrapper wrapper;

    public TextureManager(String url) {
        this.url = url;
    }


    public static void registerTextureManager(TextureManager textureManager) {
        textureManagerList.add(textureManager);
    }

    public static List<TextureManager> getTextureManagerList() {
        return textureManagerList;
    }

    public String getUrl() {
        return url;
    }

    @SideOnly(Side.CLIENT)
    public static void reload() {
        for(TextureManager manager: textureManagerList) {
            try {
                HttpURLConnection connection = (HttpURLConnection) new URL(manager.getUrl()).openConnection();
                JsonReader reader = new JsonReader(new InputStreamReader((InputStream) connection.getContent()));
                Gson gson = new GsonBuilder().create();
                TextureWrapper wrapepr = gson.fromJson(reader, TextureWrapper.class);
                manager.wrapper = wrapepr;
                if(wrapepr.getModID() != null) {
                    if (Loader.isModLoaded(wrapepr.getModID())) {
                        for(Texture texture: wrapepr.getTextures()) {
                            if(texture.getId() != null && !texture.getId().isEmpty()) {
                                if(texture.getUrl() != null && !texture.getUrl().isEmpty()) {
                                    ResourceLocation location = DownloadHelper.downloadResourceLocation(texture.getUrl(), new ResourceLocation(wrapepr.getModID(), "downloaded/" + texture.getId()), Reference.TEXTURE_404);
                                    texture.setLocation(location);
                                } else {
                                    Yaum.getInstance().getLogHelper().error("TextureManager with modID has and invalid texture url null/empty texture id " + texture.getId());
                                }
                            }else {
                                Yaum.getInstance().getLogHelper().error("TextureManager with modID has and invalid texture no id gives/empty");
                            }
                        }
                    }else {
                        Yaum.getInstance().getLogHelper().error("TextureManager with the url " + manager.getUrl()  + " will not load since it has the modID " + wrapepr.getModID() + " but that mod id is not in game");
                    }
                }else {
                    Yaum.getInstance().getLogHelper().error("Failed to init the TextureManager with the url " + manager.getUrl());
                }

                reader.close();
            } catch (final IOException e) {
                Yaum.getInstance().getLogHelper().error("Failed to load the TextureManager with the url " + manager.getUrl() + " json is not right");
            }
        }
    }

    public TextureWrapper getWrapper() {
        return wrapper;
    }

    public static class TextureWrapper {

        private String modID;
        private List<Texture> textures;

        public List<Texture> getTextures() {
            return textures == null ? new ArrayList<>() : textures;
        }

        public String getModID() {
            return modID;
        }

        @Nullable
        public Texture getTextureByID(String id) {
            return textures.stream().filter(texture -> texture.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
        }
    }
}

package com.unrealdinnerbone.yaum.perks;

import com.google.gson.stream.JsonReader;
import com.unrealdinnerbone.yaum.libs.Reference;
import com.unrealdinnerbone.yaum.yaum;
import net.minecraft.entity.player.EntityPlayer;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.UUID;

public class StatsGetter
{

    private static HashMap<UUID, Supporter> supporters = new HashMap<>();

    public static void ReadPepsData() {

        try {

            final HttpURLConnection connection = (HttpURLConnection) new URL(Reference.SUPPORTER_DATA_JSON).openConnection();
            final JsonReader reader = new JsonReader(new InputStreamReader((InputStream) connection.getContent()));

            reader.beginObject();

            while (reader.hasNext()) {

                reader.nextName();
                UUID playerID = null;
                boolean cape = false;
                boolean elytra = false;
                boolean fancyChat = false;
                String elytraTexture = null;
                String capeTexture = null;
                reader.beginObject();

                while (reader.hasNext()) {

                    final String name = reader.nextName();

                    if (name.equals("playerID")) {
                        playerID = UUID.fromString(reader.nextString());
                    } else if (name.equals("cape")) {
                        cape = reader.nextBoolean();
                    } else if (name.equals("elytra")) {
                        elytra = reader.nextBoolean();
                    } else if (name.equals("elytraTexture")) {
                        elytraTexture = reader.nextString();
                    } else if (name.equals("capeTexture")) {
                        capeTexture = reader.nextString();
                    } else if (name.equals("fancyChat")) {
                        fancyChat = reader.nextBoolean();
                    } else
                        reader.skipValue();
                }

                Supporter supporter = new Supporter(playerID, cape, elytra, elytraTexture, capeTexture, fancyChat);
                supporters.put(playerID, supporter);
                reader.endObject();
            }

            reader.endObject();
            reader.close();
        } catch (final IOException e)
        {
            yaum.getRegistry().getLogHelper().error(e.getCause());
        }
    }

    public static boolean isSupporter(UUID uuid) {
        return supporters.containsKey(uuid);
    }

    public static boolean isSupporter(EntityPlayer player) {
        return isSupporter(player.getUniqueID());
    }

    @Nullable
    public static Supporter getSupporter(EntityPlayer player) {
        return getSupporter(player.getUniqueID());
    }
    @Nullable
    public static Supporter getSupporter(UUID uuid) {
        if(isSupporter(uuid)) {
            return supporters.get(uuid);
        }else {
            return null;
        }
    }
}

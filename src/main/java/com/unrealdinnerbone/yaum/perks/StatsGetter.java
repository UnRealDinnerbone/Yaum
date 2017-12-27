package com.unrealdinnerbone.yaum.perks;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.unrealdinnerbone.yaum.libs.Reference;
import com.unrealdinnerbone.yaum.Yaum;
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
            Gson gson = new GsonBuilder().create();
            //Todo THIWS
            //Supporters supporters = gson.fromJson(reader, Supporters.class);
            reader.endObject();
            reader.close();
        } catch (final IOException e) {
            Yaum.getRegistry().getLogHelper().error(e.getCause());
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

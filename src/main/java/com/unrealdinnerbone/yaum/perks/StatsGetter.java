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

    private static Supporters supporters;

    public static void initStats() {

        try {
            final HttpURLConnection connection = (HttpURLConnection) new URL(Reference.SUPPORTER_DATA_JSON).openConnection();
            final JsonReader reader = new JsonReader(new InputStreamReader((InputStream) connection.getContent()));
            Gson gson = new GsonBuilder().create();
            supporters = gson.fromJson(reader, Supporters.class);
            reader.close();
        } catch (final IOException e) {
            Yaum.getLogHelper().error("There was and error when loading supporter json, this is ok");
        }
    }

    public static boolean isSupporter(UUID uuid) {
        return supporters.getSupporters().stream().anyMatch(supporter -> supporter.getPlayerID().equals(uuid));
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
        return supporters.getSupporters().stream().filter(supporter -> supporter.getPlayerID().equals(uuid)).findFirst().orElse(null);
    }
}

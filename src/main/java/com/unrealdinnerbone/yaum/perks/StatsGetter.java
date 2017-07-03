package com.unrealdinnerbone.yaum.perks;

import com.google.gson.stream.JsonReader;
import com.unrealdinnerbone.yaum.util.LogHelper;
import com.unrealdinnerbone.yaum.yaum;
import net.minecraft.entity.player.EntityPlayer;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StatsGetter
{

    private static final List<Supporter> SUPPORTERS = new ArrayList<>();
    private static final String SUPPORTER_URL = "https://raw.githubusercontent.com/UnRealDinnerbone/Yarm/1.10.2/Files/People/newPeople.json";

    public static void ReadPepsData() {

        try {

            final HttpURLConnection connection = (HttpURLConnection) new URL(SUPPORTER_URL).openConnection();
            final JsonReader reader = new JsonReader(new InputStreamReader((InputStream) connection.getContent()));

            reader.beginObject();

            while (reader.hasNext()) {

                reader.nextName();
                UUID playerID = null;
                boolean cape = false;
                boolean elytra = false;
                String type = "Cool Person";
                String elytraTexture = null;
                String capeTexture = null;
                reader.beginObject();

                while (reader.hasNext()) {

                    final String name = reader.nextName();

                    if (name.equals("playerID"))
                        playerID = UUID.fromString(reader.nextString());

                    else if (name.equals("type"))
                        type = reader.nextString();

                    else if (name.equals("cape"))
                        cape = reader.nextBoolean();

                    else if (name.equals("elytra"))
                        elytra = reader.nextBoolean();

                    else if (name.equals("elytraTexture"))
                        elytraTexture = reader.nextString();

                    else if (name.equals("capeTexture"))
                        capeTexture = reader.nextString();
                    else
                        reader.skipValue();
                }

                SUPPORTERS.add(new Supporter(playerID, cape, elytra, type, elytraTexture, capeTexture));
                reader.endObject();
            }

            reader.endObject();
            reader.close();
        }
        catch (final MalformedURLException e)
        {
            yaum.getLogHelper().warn(e.getCause());
        }
        catch (final IOException e)
        {
            yaum.getLogHelper().warn(e.getCause());
        }
    }

    public static boolean isSupporter(EntityPlayer player) {

        for (final Supporter supporter: SUPPORTERS)
            if (supporter.getPlayerID().equals(player.getUniqueID()))
                return true;
        return false;
    }

    public static final Supporter getSupporterData(EntityPlayer player) {

        for (final Supporter supporter: SUPPORTERS)
            if (supporter.getPlayerID().equals(player.getUniqueID()))
                return supporter;

        return null;
    }
}

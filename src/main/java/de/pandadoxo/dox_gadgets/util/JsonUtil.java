// -----------------------
// Coded by Pandadoxo
// on 20.03.2021 at 18:26 
// -----------------------

package de.pandadoxo.dox_gadgets.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {

    private static Gson gson;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();

        gson = gsonBuilder.create();
    }


    public static Gson getGson() {
        return gson;
    }
}

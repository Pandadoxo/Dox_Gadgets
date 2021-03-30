// -----------------------
// Coded by Pandadoxo
// on 20.03.2021 at 18:08 
// -----------------------

package de.pandadoxo.dox_gadgets.util;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import de.pandadoxo.dox_gadgets.Main;
import de.pandadoxo.dox_gadgets.player.GPlayerConfig;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FilesUtil {

    private final File player = new File(Main.getInstance().getDataFolder(), "playerConfig.json");

    public FilesUtil() {
        create();
        load();
    }

    public void create() {
        try{
            if(!player.exists()) {
                player.getParentFile().mkdirs();
                player.createNewFile();
            }

        }catch (IOException ignored) {
        }
    }

    public void load() {
        try{
            JsonReader playerR = new JsonReader(new FileReader(player));
            Main.setGPlayerConfig(new Gson().fromJson(playerR, GPlayerConfig.class));
            if(Main.getGPlayerConfig() == null) Main.setGPlayerConfig(new GPlayerConfig());
            playerR.close();

        }catch (IOException ignored) {
        }
    }

    public void save() {
        try{
            PrintWriter playerW = new PrintWriter(player);
            playerW.println(JsonUtil.getGson().toJson(Main.getGPlayerConfig()));
            playerW.flush();
            playerW.close();

        }catch (IOException ignored) {
        }
    }
}

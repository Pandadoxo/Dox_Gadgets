package de.pandadoxo.dox_gadgets;

import de.pandadoxo.dox_gadgets.armor.boots.BootsConfig;
import de.pandadoxo.dox_gadgets.armor.chest.ChestConfig;
import de.pandadoxo.dox_gadgets.armor.helmet.HelmetConfig;
import de.pandadoxo.dox_gadgets.armor.leggings.LeggingsConfig;
import de.pandadoxo.dox_gadgets.commands.OpenCmd;
import de.pandadoxo.dox_gadgets.gadget.GadgetConfig;
import de.pandadoxo.dox_gadgets.core.GadgetCore;
import de.pandadoxo.dox_gadgets.player.GPlayerConfig;
import de.pandadoxo.dox_gadgets.util.ColorUtil;
import de.pandadoxo.dox_gadgets.util.FilesUtil;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    private static String PREFIX = "§7| §e§lGadgets §8» §r";
    private static String TOKEN = "change_this_token_to_whatever_you_want";
    private static String WRONGSYNTAX = "§7Falscher Syntax! Benutze: §e";

    private static Main instance;
    private static Doxperm doxperm;
    private static FilesUtil filesUtil;
    private static ColorUtil colorUtil;
    private static GPlayerConfig gPlayerConfig;

    private static GadgetConfig gadgetConfig;
    private static HelmetConfig helmetConfig;
    private static ChestConfig chestConfig;
    private static LeggingsConfig leggingsConfig;
    private static BootsConfig bootsConfig;

    private static GadgetCore gadgetCore;

    @Override
    public void onEnable() {
        instance = this;
        loadConfig();
        gPlayerConfig = new GPlayerConfig();
        gadgetConfig = new GadgetConfig();
        helmetConfig = new HelmetConfig();
        chestConfig = new ChestConfig();
        leggingsConfig = new LeggingsConfig();
        bootsConfig = new BootsConfig();

        gadgetCore = new GadgetCore();

        doxperm = new Doxperm(PREFIX());
        filesUtil = new FilesUtil();
        colorUtil = new ColorUtil().startRainbow();


        getCommand("open_gadgets").setExecutor(new OpenCmd());

    }

    private void loadConfig() {
        reloadConfig();
        if (!getConfig().isSet("prefix")) getConfig().set("prefix", PREFIX.replace('§', '&'));
        if (!getConfig().isSet("command_token")) getConfig().set("command_token", TOKEN);
            saveConfig();

         PREFIX = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(getConfig().getString("prefix")));
         TOKEN = getConfig().getString("command_token");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance() {
        return instance;
    }

    public static Doxperm getDoxperm() {
        return doxperm;
    }

    public static GPlayerConfig getGPlayerConfig() {
        return gPlayerConfig;
    }

    public static void setGPlayerConfig(GPlayerConfig gPlayerConfig) {
        Main.gPlayerConfig = gPlayerConfig;
    }

    public static GadgetConfig getGadgetConfig() {
        return gadgetConfig;
    }

    public static HelmetConfig getHelmetConfig() {
        return helmetConfig;
    }

    public static ChestConfig getChestConfig() {
        return chestConfig;
    }

    public static LeggingsConfig getLeggingsConfig() {
        return leggingsConfig;
    }

    public static BootsConfig getBootsConfig() {
        return bootsConfig;
    }

    public static FilesUtil getFilesUtil() {
        return filesUtil;
    }

    public static ColorUtil getColorUtil() {
        return colorUtil;
    }

    public static String PREFIX() {
        return PREFIX;
    }

    public static String TOKEN() {
        return TOKEN;
    }

    public static String WRONGSYNTAX() {
        return PREFIX + WRONGSYNTAX;
    }

    public static GadgetCore getGadgetCore() {
        return gadgetCore;
    }
}

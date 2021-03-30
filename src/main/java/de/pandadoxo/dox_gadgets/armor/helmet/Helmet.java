// -----------------------
// Coded by Pandadoxo
// on 28.03.2021 at 14:33 
// -----------------------

package de.pandadoxo.dox_gadgets.armor.helmet;

import de.pandadoxo.dox_gadgets.Main;
import de.pandadoxo.dox_gadgets.api.gui.Menu.GuiItem;
import de.pandadoxo.dox_gadgets.core.EHelmet;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import java.util.Collections;

public abstract class Helmet implements Listener {

    private static final String NAME = "§8• §7Helme §8•";
    public static GuiItem defaultItem = new GuiItem(NAME, Collections.singletonList("§8» §7Nichts ausgewählt"), Material.LEATHER_HELMET);

    private boolean listening;
    private EHelmet helmet;

    public Helmet(EHelmet helmet) {
        this.helmet = helmet;
        Main.getHelmetConfig().helmets.add(this);
    }

    abstract public void onUse(Player player);

    abstract void onItemMove(InventoryClickEvent event);

    abstract void onItemDrop(PlayerDropItemEvent event);

    public EHelmet getHelmet() {
        return helmet;
    }

    public Helmet addListener() {
        if (!listening) {
            Bukkit.getPluginManager().registerEvents(this, Main.getInstance());
            listening = true;
        }
        return this;
    }

    public Helmet removeListener() {
        if (listening) {
            HandlerList.unregisterAll(this);
            listening = false;
        }
        return this;
    }

    public boolean isListening() {
        return listening;
    }

    public void setListening(boolean listening) {
        this.listening = listening;
    }


    public void setHelmet(EHelmet helmet) {
        this.helmet = helmet;
    }

}

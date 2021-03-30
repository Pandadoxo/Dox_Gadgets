// -----------------------
// Coded by Pandadoxo
// on 28.03.2021 at 14:33 
// -----------------------

package de.pandadoxo.dox_gadgets.armor.boots;

import de.pandadoxo.dox_gadgets.Main;
import de.pandadoxo.dox_gadgets.api.gui.Menu.GuiItem;
import de.pandadoxo.dox_gadgets.core.EBoots;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import java.util.Collections;

public abstract class Boots implements Listener {

    private static final String NAME = "§8• §7Schuhe §8•";
    public static GuiItem defaultItem = new GuiItem(NAME, Collections.singletonList("§8» §7Nichts ausgewählt"), Material.LEATHER_BOOTS);

    private boolean listening;
    private EBoots boots;

    public Boots(EBoots boots) {
        this.listening = false;
        this.boots = boots;
        Main.getBootsConfig().boots.add(this);
    }

    abstract public void onUse(Player player);

    abstract void onItemMove(InventoryClickEvent event);

    abstract void onItemDrop(PlayerDropItemEvent event);

    public EBoots getBoots() {
        return boots;
    }

    public Boots addListener() {
        if (!listening) {
            Bukkit.getPluginManager().registerEvents(this, Main.getInstance());
            listening = true;
        }
        return this;
    }

    public Boots removeListener() {
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


    public void setBoots(EBoots boots) {
        this.boots = boots;
    }

}

// -----------------------
// Coded by Pandadoxo
// on 23.03.2021 at 20:09 
// -----------------------

package de.pandadoxo.dox_gadgets.gadget;

import de.pandadoxo.dox_gadgets.Main;
import de.pandadoxo.dox_gadgets.api.gui.Menu.GuiItem;
import de.pandadoxo.dox_gadgets.core.EGadget;
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

public abstract class Gadget implements Listener {

    private static final String NAME = "§8• §7Items §8•";
    public static GuiItem defaultItem = new GuiItem(NAME, Collections.singletonList("§8» §7Nichts ausgewählt"), Material.BARRIER);

    private boolean listening;
    private EGadget gadget;

    public Gadget(EGadget gadget) {
        this.listening = false;
        this.gadget = gadget;
        Main.getGadgetConfig().gadgets.add(this);
    }

    abstract public void onUse(Player player);

    abstract void onItemMove(InventoryClickEvent event);

    abstract void onItemDrop(PlayerDropItemEvent event);

    public Gadget addListener() {
        if (!listening) {
            Bukkit.getPluginManager().registerEvents(this, Main.getInstance());
            listening = true;
        }
        return this;
    }

    public Gadget removeListener() {
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

    public EGadget getGadget() {
        return gadget;
    }

    public void setGadget(EGadget gadget) {
        this.gadget = gadget;
    }

}

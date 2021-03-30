package de.pandadoxo.dox_gadgets.api.gui.Menu;

import de.pandadoxo.dox_gadgets.Main;
import de.pandadoxo.dox_gadgets.api.gui.Listener.ButtonPressedListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;

public class GuiMenu extends ButtonPressedListener {

    public static List<GuiMenu> Menus = new ArrayList<>();

    private int size;
    private int page;
    private int maxPage;
    private String name;
    private String reference;
    private Player viewer;
    private Inventory inventory;

    private GuiMenu currentMenu;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Player getViewer() {
        return viewer;
    }

    public void setViewer(Player viewer) {
        this.viewer = viewer;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public GuiMenu(String name, int size, Player viewer) {
        this(name, size, 1, 1, viewer, null);
    }

    public GuiMenu(String name, int size, int page, int maxPage, Player viewer) {
        this(name, size, page, maxPage, viewer, null);
    }

    public GuiMenu(String name, int size, int page, int maxPage, Player viewer, String reference) {
        this.name = name;
        this.size = size;
        this.page = page;
        this.maxPage = maxPage;
        this.viewer = viewer;
        this.reference = reference;

        this.currentMenu = this;
        Menus.add(currentMenu);

        inventory = Bukkit.createInventory(null, size, name);

        Listener listener = new Listener() {
            @EventHandler
            public void onInventoryClick(InventoryClickEvent e) {
                if (!(e.getWhoClicked() instanceof Player))
                    return;
                if (e.getInventory().equals(getInventory()))
                    e.setCancelled(true);
            }

            @EventHandler
            public void onInventoryMove(InventoryMoveItemEvent e) {
                if (e.getInitiator().equals(getInventory()))
                    e.setCancelled(true);
            }
        };

        Bukkit.getPluginManager().registerEvents(listener, Main.getInstance());
    }

    @Override
    public boolean onPressed(ClickType clickType, GuiMenu menu, GuiItem iconOn, GuiItem iconOff, int slot, boolean active) {
        return true;
    }

}

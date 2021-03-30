package de.pandadoxo.dox_gadgets.api.gui.Buttons;

import de.pandadoxo.dox_gadgets.Main;
import de.pandadoxo.dox_gadgets.api.gui.Listener.ButtonPressedListener;
import de.pandadoxo.dox_gadgets.api.gui.Menu.GuiItem;
import de.pandadoxo.dox_gadgets.api.gui.Menu.GuiMenu;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class SwitchButton extends Button {

    private Listener listener;
    private GuiMenu menu;
    private int slot;
    private GuiItem iconOn;
    private GuiItem iconOff;
    private boolean active;
    private ButtonPressedListener buttonPressedListener;

    public GuiMenu getMenu() {
        return menu;
    }

    public void setMenu(GuiMenu menu) {
        this.menu = menu;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public GuiItem getIconOn() {
        return iconOn;
    }

    public void setIconOn(GuiItem iconOn) {
        this.iconOn = iconOn;
    }

    public GuiItem getIconOff() {
        return iconOff;
    }

    public void setIconOff(GuiItem iconOff) {
        this.iconOff = iconOff;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        if (active) menu.getInventory().setItem(slot, iconOn.getItem());
        else menu.getInventory().setItem(slot, iconOff.getItem());
        this.active = active;
    }

    public ButtonPressedListener getButtonPressedListener() {
        return buttonPressedListener;
    }

    public void setButtonPressedListener(ButtonPressedListener buttonPressedListener) {
        this.buttonPressedListener = buttonPressedListener;
    }

    public SwitchButton(GuiItem iconOn, GuiItem iconOff, GuiMenu menu, int slot,
                        ButtonPressedListener buttonPressedListener) {
        super(menu, slot);
        this.iconOn = iconOn;
        this.iconOff = iconOff;
        this.menu = menu;
        this.slot = slot;
        this.buttonPressedListener = buttonPressedListener;

        if (active)
            menu.getInventory().setItem(slot, iconOn.getItem());
        else
            menu.getInventory().setItem(slot, iconOff.getItem());

        Listener listener = new Listener() {
            @EventHandler
            public void onInventoryClick(InventoryClickEvent e) {
                if (getMenu() == null)
                    return;
                if (!e.getInventory().equals(getMenu().getInventory())) {
                    destroy();
                    return;
                }
                if (e.getSlot() != getSlot())
                    return;
                if (!(e.getWhoClicked() instanceof Player))
                    return;
                e.setCancelled(true);
                setActive(!active);
                ((Player) e.getWhoClicked()).playSound(e.getWhoClicked().getLocation(), Sound.BLOCK_CHEST_LOCKED, 1, 2);
                getButtonPressedListener().onPressed(e.getClick(), menu, getIconOn(), getIconOff(), getSlot(), active);
                return;
            }
        };
        Bukkit.getPluginManager().registerEvents(listener, Main.getInstance());

    }

    public void destroy() {
        HandlerList.unregisterAll(listener);
        iconOn = null;
        iconOff = null;
        menu = null;
        slot = -1;
        buttonPressedListener = null;

        listener = null;
    }

}

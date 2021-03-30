package de.pandadoxo.dox_gadgets.api.gui.Listener;


import de.pandadoxo.dox_gadgets.api.gui.Menu.GuiItem;
import de.pandadoxo.dox_gadgets.api.gui.Menu.GuiMenu;
import org.bukkit.event.inventory.ClickType;

public class ButtonPressedListener {

    public ButtonPressedListener() {
    }

    public boolean onPressed(ClickType clickType, GuiMenu menu, GuiItem iconOn, GuiItem iconOff, int slot, boolean active) {
        return true;
    }

    public boolean onPressed(ClickType clickType, GuiMenu menu, GuiItem icon, int slot) {
        return true;
    }

}

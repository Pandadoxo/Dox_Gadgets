// -----------------------
// Coded by Pandadoxo
// on 28.03.2021 at 14:15 
// -----------------------

package de.pandadoxo.dox_gadgets.core;

import de.pandadoxo.dox_gadgets.api.gui.Menu.GuiItem;
import de.pandadoxo.dox_gadgets.armor.leggings.LRainbow;

public enum ELeggings {

    RAINBOW("gadgets.leggings.rainbow",10, LRainbow.showItem),
    NONE("",22, GadgetCore.NONE);

    private String permission;
    private int slot;
    private GuiItem item;

    ELeggings(String permission, int slot, GuiItem item) {
        this.permission = permission;
        this.slot = slot;
        this.item = item;
    }

    public String getPermission() {
        return permission;
    }

    public int getSlot() {
        return slot;
    }

    public GuiItem getItem() {
        return item;
    }
}

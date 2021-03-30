// -----------------------
// Coded by Pandadoxo
// on 28.03.2021 at 14:15 
// -----------------------

package de.pandadoxo.dox_gadgets.core;

import de.pandadoxo.dox_gadgets.api.gui.Menu.GuiItem;
import de.pandadoxo.dox_gadgets.armor.boots.BFire;
import de.pandadoxo.dox_gadgets.armor.boots.BLove;
import de.pandadoxo.dox_gadgets.armor.boots.BRainbow;

public enum EBoots {

    RAINBOW("gadgets.boots.rainbow", 10, BRainbow.showItem), FIRE("gadgets.boots.fire", 11, BFire.showItem),
    LOVE("gadgets.boots.love", 12, BLove.showItem), NONE("", 22, GadgetCore.NONE);

    private String permission;
    private int slot;
    private GuiItem item;

    EBoots(String permission, int slot, GuiItem item) {
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

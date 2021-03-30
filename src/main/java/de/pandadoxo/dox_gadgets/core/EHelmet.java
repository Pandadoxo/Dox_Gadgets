// -----------------------
// Coded by Pandadoxo
// on 28.03.2021 at 14:15 
// -----------------------

package de.pandadoxo.dox_gadgets.core;

import de.pandadoxo.dox_gadgets.api.gui.Menu.GuiItem;
import de.pandadoxo.dox_gadgets.armor.helmet.*;

public enum EHelmet {

    RAINBOW("gadgets.helmet.rainbow",10, HRainbow.showItem),
    TURTLE("gadgets.helmet.turle",11, HTurtle.showItem),
    ASTRONAUT("gadgets.helmet.astronaut",12, HAstronaut.showItem),
    END_ROD("gadgets.helmet.end_rod",13, HEndRod.showItem),
    REDSTONE_TORCH("gadgets.helmet.redstone_torch",14, HRedstoneTorch.showItem),
    NONE("",22, GadgetCore.NONE);

    private String permission;
    private int slot;
    private GuiItem item;

    EHelmet(String permission, int slot, GuiItem item) {
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

// -----------------------
// Coded by Pandadoxo
// on 20.03.2021 at 18:28 
// -----------------------

package de.pandadoxo.dox_gadgets.core;

import de.pandadoxo.dox_gadgets.api.gui.Menu.GuiItem;
import de.pandadoxo.dox_gadgets.gadget.GElytra;
import de.pandadoxo.dox_gadgets.gadget.GEnderPearl;
import de.pandadoxo.dox_gadgets.gadget.GGrapplingHook;

public enum EGadget {

    ENDERPEARL("gadgets.enderpearl",11, GEnderPearl.showItem),
    ELYTRA("gadgets.elytra",12, GElytra.showItem),
    GRAPPLING_HOOK("gadgets.grappling",10, GGrapplingHook.showItem),
    NONE("",22, GadgetCore.NONE);

    private String permission;
    private int slot;
    private GuiItem item;

    EGadget(String permission, int slot, GuiItem item) {
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

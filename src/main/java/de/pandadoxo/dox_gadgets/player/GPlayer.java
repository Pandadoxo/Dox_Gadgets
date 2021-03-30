// -----------------------
// Coded by Pandadoxo
// on 20.03.2021 at 18:23 
// -----------------------

package de.pandadoxo.dox_gadgets.player;

import de.pandadoxo.dox_gadgets.core.*;

public class GPlayer {

    private String uuid;
    private EGadget gadget;
    private EHelmet helmet;
    private EChest chest;
    private ELeggings leggings;
    private EBoots boots;

    public GPlayer(String uuid, EGadget gadget, EHelmet helmet, EChest chest, ELeggings leggings, EBoots boots) {
        this.uuid = uuid;
        this.gadget = gadget;
        this.helmet = helmet;
        this.chest = chest;
        this.leggings = leggings;
        this.boots = boots;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public EGadget getGadget() {
        return gadget;
    }

    public void setGadget(EGadget gadget) {
        this.gadget = gadget;
    }

    public EHelmet getHelmet() {
        return helmet;
    }

    public void setHelmet(EHelmet helmet) {
        this.helmet = helmet;
    }

    public EChest getChest() {
        return chest;
    }

    public void setChest(EChest chest) {
        this.chest = chest;
    }

    public ELeggings getLeggings() {
        return leggings;
    }

    public void setLeggings(ELeggings leggings) {
        this.leggings = leggings;
    }

    public EBoots getBoots() {
        return boots;
    }

    public void setBoots(EBoots boots) {
        this.boots = boots;
    }
}

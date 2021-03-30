// -----------------------
// Coded by Pandadoxo
// on 29.03.2021 at 10:29 
// -----------------------

package de.pandadoxo.dox_gadgets.core;

import de.pandadoxo.dox_gadgets.api.gui.Menu.GuiItem;
import de.pandadoxo.dox_gadgets.armor.boots.BFire;
import de.pandadoxo.dox_gadgets.armor.boots.BLove;
import de.pandadoxo.dox_gadgets.armor.boots.BNone;
import de.pandadoxo.dox_gadgets.armor.boots.BRainbow;
import de.pandadoxo.dox_gadgets.armor.chest.CNone;
import de.pandadoxo.dox_gadgets.armor.chest.CRainbow;
import de.pandadoxo.dox_gadgets.armor.helmet.*;
import de.pandadoxo.dox_gadgets.armor.leggings.LNone;
import de.pandadoxo.dox_gadgets.armor.leggings.LRainbow;
import de.pandadoxo.dox_gadgets.gadget.GElytra;
import de.pandadoxo.dox_gadgets.gadget.GEnderPearl;
import de.pandadoxo.dox_gadgets.gadget.GGrapplingHook;
import de.pandadoxo.dox_gadgets.gadget.GNone;
import org.bukkit.Material;

public class GadgetCore {

    public static final GuiItem NONE = new GuiItem("§8• §cNichts §8•", Material.BARRIER);

    //Gadgets
    private GElytra gElytra;
    private GEnderPearl gEnderPearl;
    private GGrapplingHook gGrapplingHook;
    private GNone gNone;

    //Helmets
    private HRainbow hRainbow;
    private HEndRod hEndRod;
    private HRedstoneTorch hRedstoneTorch;
    private HTurtle hTurtle;
    private HAstronaut hAstronaut;
    private HNone hNone;

    //Chests
    private CRainbow cRainbow;
    private CNone cNone;

    //Leggings
    private LRainbow lRainbow;
    private LNone lNone;

    //Boots
    private BRainbow bRainbow;
    private BFire bFire;
    private BLove bLove;
    private BNone bNone;

    public GadgetCore() {
        gElytra = (GElytra) new GElytra(EGadget.ELYTRA).addListener();
        gEnderPearl = (GEnderPearl) new GEnderPearl(EGadget.ENDERPEARL).addListener();
        gGrapplingHook = (GGrapplingHook) new GGrapplingHook(EGadget.GRAPPLING_HOOK).addListener();
        gNone = new GNone(EGadget.NONE);

        hRainbow = (HRainbow) new HRainbow(EHelmet.RAINBOW).addListener();
        hEndRod = (HEndRod) new HEndRod(EHelmet.END_ROD).addListener();
        hRedstoneTorch = (HRedstoneTorch) new HRedstoneTorch(EHelmet.REDSTONE_TORCH).addListener();
        hTurtle = (HTurtle) new HTurtle(EHelmet.TURTLE).addListener();
        hAstronaut = (HAstronaut) new HAstronaut(EHelmet.ASTRONAUT).addListener();
        hNone = new HNone(EHelmet.NONE);

        cRainbow = (CRainbow) new CRainbow(EChest.RAINBOW).addListener();
        cNone = new CNone(EChest.NONE);

        lRainbow = (LRainbow) new LRainbow(ELeggings.RAINBOW).addListener();
        lNone = new LNone(ELeggings.NONE);

        bRainbow = (BRainbow) new BRainbow(EBoots.RAINBOW).addListener();
        bFire = (BFire) new BFire(EBoots.FIRE).addListener();
        bLove = (BLove) new BLove(EBoots.LOVE).addListener();
        bNone = new BNone(EBoots.NONE);
    }

    public GElytra getgElytra() {
        return gElytra;
    }

    public GEnderPearl getgEnderPearl() {
        return gEnderPearl;
    }

    public GGrapplingHook getgGrapplingHook() {
        return gGrapplingHook;
    }

    public GNone getgNone() {
        return gNone;
    }

    public HRainbow gethRainbow() {
        return hRainbow;
    }

    public HEndRod gethEndRod() {
        return hEndRod;
    }

    public HRedstoneTorch gethRedstoneTorch() {
        return hRedstoneTorch;
    }

    public HTurtle gethTurtle() {
        return hTurtle;
    }

    public HAstronaut gethAstronaut() {
        return hAstronaut;
    }

    public HNone gethNone() {
        return hNone;
    }

    public CRainbow getcRainbow() {
        return cRainbow;
    }

    public CNone getcNone() {
        return cNone;
    }

    public LRainbow getlRainbow() {
        return lRainbow;
    }

    public LNone getlNone() {
        return lNone;
    }

    public BRainbow getbRainbow() {
        return bRainbow;
    }

    public BFire getbFire() {
        return bFire;
    }

    public BLove getbLove() {
        return bLove;
    }

    public BNone getbNone() {
        return bNone;
    }
}

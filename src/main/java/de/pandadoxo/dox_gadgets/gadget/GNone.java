// -----------------------
// Coded by Pandadoxo
// on 29.03.2021 at 11:13 
// -----------------------

package de.pandadoxo.dox_gadgets.gadget;

import de.pandadoxo.dox_gadgets.Main;
import de.pandadoxo.dox_gadgets.core.EGadget;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class GNone extends Gadget {


    public GNone(EGadget gadget) {
        super(gadget);
    }

    @Override
    public void onUse(Player player) {
        player.getInventory().remove(Main.getGadgetCore().getgElytra().elytraItem.getItem());
        player.getInventory().remove(Main.getGadgetCore().getgElytra().rocketItem.getItem());
        player.getInventory().remove(Main.getGadgetCore().getgEnderPearl().realItem.getItem());
        player.getInventory().remove(Main.getGadgetCore().getgGrapplingHook().realItem.getItem());
    }

    @Override
    void onItemMove(InventoryClickEvent event) {

    }

    @Override
    void onItemDrop(PlayerDropItemEvent event) {

    }
}

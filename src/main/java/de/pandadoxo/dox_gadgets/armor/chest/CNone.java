// -----------------------
// Coded by Pandadoxo
// on 29.03.2021 at 11:13 
// -----------------------

package de.pandadoxo.dox_gadgets.armor.chest;

import de.pandadoxo.dox_gadgets.Main;
import de.pandadoxo.dox_gadgets.core.EChest;
import de.pandadoxo.dox_gadgets.core.EGadget;
import de.pandadoxo.dox_gadgets.gadget.Gadget;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class CNone extends Chest {


    public CNone(EChest chest) {
        super(chest);
    }

    @Override
    public void onUse(Player player) {
        player.getInventory().setChestplate(new ItemStack(Material.AIR));
    }

    @Override
    void onItemMove(InventoryClickEvent event) {

    }

    @Override
    void onItemDrop(PlayerDropItemEvent event) {

    }
}

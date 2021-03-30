// -----------------------
// Coded by Pandadoxo
// on 29.03.2021 at 11:13 
// -----------------------

package de.pandadoxo.dox_gadgets.armor.boots;

import de.pandadoxo.dox_gadgets.core.EBoots;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class BNone extends Boots {


    public BNone(EBoots boots) {
        super(boots);
    }

    @Override
    public void onUse(Player player) {
        player.getInventory().setBoots(new ItemStack(Material.AIR));
    }

    @Override
    void onItemMove(InventoryClickEvent event) {

    }

    @Override
    void onItemDrop(PlayerDropItemEvent event) {

    }
}

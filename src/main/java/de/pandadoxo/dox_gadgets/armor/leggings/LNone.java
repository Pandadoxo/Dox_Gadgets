// -----------------------
// Coded by Pandadoxo
// on 29.03.2021 at 11:13 
// -----------------------

package de.pandadoxo.dox_gadgets.armor.leggings;

import de.pandadoxo.dox_gadgets.core.ELeggings;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class LNone extends Leggings {


    public LNone(ELeggings leggings) {
        super(leggings);
    }

    @Override
    public void onUse(Player player) {
        player.getInventory().setLeggings(new ItemStack(Material.AIR));
    }

    @Override
    void onItemMove(InventoryClickEvent event) {

    }

    @Override
    void onItemDrop(PlayerDropItemEvent event) {

    }
}

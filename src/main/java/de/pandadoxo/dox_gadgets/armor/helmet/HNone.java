// -----------------------
// Coded by Pandadoxo
// on 29.03.2021 at 11:13 
// -----------------------

package de.pandadoxo.dox_gadgets.armor.helmet;

import de.pandadoxo.dox_gadgets.core.EHelmet;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class HNone extends Helmet {


    public HNone(EHelmet helmet) {
        super(helmet);
    }

    @Override
    public void onUse(Player player) {
        player.getInventory().setHelmet(new ItemStack(Material.AIR));
    }

    @Override
    void onItemMove(InventoryClickEvent event) {

    }

    @Override
    void onItemDrop(PlayerDropItemEvent event) {

    }
}

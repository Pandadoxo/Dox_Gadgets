// -----------------------
// Coded by Pandadoxo
// on 29.03.2021 at 18:09 
// -----------------------

package de.pandadoxo.dox_gadgets.armor.helmet;

import de.pandadoxo.dox_gadgets.Main;
import de.pandadoxo.dox_gadgets.api.gui.Menu.GuiItem;
import de.pandadoxo.dox_gadgets.core.EHelmet;
import de.pandadoxo.dox_gadgets.player.GPlayer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;

public class HAstronaut extends Helmet {

    public static final String NAME = "§8• §fAstronauten Helm §8•";
    public static final GuiItem showItem = new GuiItem(NAME, Material.GLASS);
    public final GuiItem realItem = new GuiItem(NAME, Material.GLASS, true).setUnbreakable(true);

    public HAstronaut(EHelmet helmet) {
        super(helmet);
    }

    @Override
    public void onUse(Player player) {
        GPlayer gPlayer = Main.getGPlayerConfig().getPlayer(player);
        gPlayer.setHelmet(getHelmet());

        player.getInventory().setHelmet(realItem.getItem());
    }

    @Override
    @EventHandler
    void onItemMove(InventoryClickEvent event) {
        if (event.getCurrentItem() != null && event.getCurrentItem().getItemMeta() != null) {
            if (event.getSlotType().equals(InventoryType.SlotType.ARMOR) && event.getCurrentItem().getItemMeta().getDisplayName().equals(NAME)) {
                event.setCancelled(true);
            }
        }
    }

    @Override
    @EventHandler
    void onItemDrop(PlayerDropItemEvent event) {
        if (event.getItemDrop().getItemStack().getItemMeta() != null) {
            if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().equals(NAME)) {
                event.setCancelled(true);
            }
        }
    }
}

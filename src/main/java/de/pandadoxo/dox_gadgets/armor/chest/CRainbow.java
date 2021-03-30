// -----------------------
// Coded by Pandadoxo
// on 28.03.2021 at 14:53 
// -----------------------

package de.pandadoxo.dox_gadgets.armor.chest;

import de.pandadoxo.dox_gadgets.Main;
import de.pandadoxo.dox_gadgets.api.gui.Menu.GuiItem;
import de.pandadoxo.dox_gadgets.armor.boots.Boots;
import de.pandadoxo.dox_gadgets.core.EBoots;
import de.pandadoxo.dox_gadgets.core.EChest;
import de.pandadoxo.dox_gadgets.player.GPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;

import java.util.Arrays;

public class CRainbow extends Chest {

    public static final String NAME = "§8• §aRainbow Brustplatte §8•";
    public static final GuiItem showItem = new GuiItem(NAME, Material.LEATHER_CHESTPLATE).setLeatherArmorColor(Color.fromRGB(85, 255, 85));
    public final GuiItem realItem = new GuiItem(NAME, Material.LEATHER_CHESTPLATE, true).setUnbreakable(true);

    public CRainbow(EChest chest) {
        super(chest);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), this::onTick, 0, 1);
    }

    @Override
    public void onUse(Player player) {
        GPlayer gPlayer = Main.getGPlayerConfig().getPlayer(player);
        gPlayer.setChest(getChest());
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

    void onTick() {
        realItem.setLeatherArmorColor(Main.getColorUtil().getRainbowColor());
        for (Player all : Bukkit.getOnlinePlayers()) {
            GPlayer gPlayer = Main.getGPlayerConfig().getPlayer(all);
            if (gPlayer.getChest().equals(getChest())) {
                all.getInventory().setChestplate(realItem.getItem());
            }
        }
    }
}

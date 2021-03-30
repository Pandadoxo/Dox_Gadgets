// -----------------------
// Coded by Pandadoxo
// on 28.03.2021 at 14:53 
// -----------------------

package de.pandadoxo.dox_gadgets.armor.boots;

import de.pandadoxo.dox_gadgets.Main;
import de.pandadoxo.dox_gadgets.api.gui.Menu.GuiItem;
import de.pandadoxo.dox_gadgets.core.EBoots;
import de.pandadoxo.dox_gadgets.player.GPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class BFire extends Boots {

    public static final String NAME = "§8• §6Feuer Schuhe §8•";
    public static final GuiItem showItem = new GuiItem(NAME, Material.LEATHER_BOOTS).setLeatherArmorColor(Color.fromRGB(255, 170, 0));
    public final GuiItem realItem = new GuiItem(NAME, Material.LEATHER_BOOTS).setUnbreakable(true).setLeatherArmorColor(Color.fromRGB(255, 170, 0));

    public BFire(EBoots boots) {
        super(boots);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), this::onTick, 0, 1);
    }

    @Override
    public void onUse(Player player) {
        GPlayer gPlayer = Main.getGPlayerConfig().getPlayer(player);
        gPlayer.setBoots(getBoots());

        player.getInventory().setBoots(realItem.getItem());
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

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        GPlayer gPlayer = Main.getGPlayerConfig().getPlayer((Player) event.getEntity());
        if (gPlayer.getBoots().equals(getBoots())) {
            if (event.getCause().equals(EntityDamageEvent.DamageCause.FIRE)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event) {
        GPlayer gPlayer = Main.getGPlayerConfig().getPlayer((Player) event.getPlayer());
        if (gPlayer.getBoots().equals(getBoots())) {
            if (!event.isSneaking()) {
                event.getPlayer().setFireTicks(0);
            }
        }

    }

    void onTick() {
        for (Player all : Bukkit.getOnlinePlayers()) {
            GPlayer gPlayer = Main.getGPlayerConfig().getPlayer(all);
            if (gPlayer.getBoots().equals(getBoots())) {
                if (all.isSneaking()) {
                    all.setFireTicks(2);
                }
                all.getWorld().spawnParticle(Particle.FLAME, all.getLocation().add(0, .1, 0), 1, 0, 0, 0, 0);
            }
        }
    }
}

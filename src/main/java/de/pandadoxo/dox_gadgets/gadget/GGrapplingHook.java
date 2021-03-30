// -----------------------
// Coded by Pandadoxo
// on 25.03.2021 at 09:19 
// -----------------------

package de.pandadoxo.dox_gadgets.gadget;

import de.pandadoxo.dox_gadgets.Main;
import de.pandadoxo.dox_gadgets.api.gui.Menu.GuiItem;
import de.pandadoxo.dox_gadgets.core.EChest;
import de.pandadoxo.dox_gadgets.core.EGadget;
import de.pandadoxo.dox_gadgets.player.GPlayer;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerFishEvent;

import java.util.Arrays;
import java.util.Collections;

public class GGrapplingHook extends Gadget {

    public static final String NAME = "§8• §6Grappling Hook §8•";
    public static final GuiItem showItem = new GuiItem(NAME, Arrays.asList("§8» §7Ein Enterhaken. Angel einen", "§8» §7Block, um dich zu boosten"), Material.FISHING_ROD);
    public final GuiItem realItem = new GuiItem(NAME, Collections.emptyList(), Material.FISHING_ROD).setUnbreakable(true);

    public GGrapplingHook(EGadget gadget) {
        super(gadget);
    }


    @Override
    public void onUse(Player player) {
        GPlayer gPlayer = Main.getGPlayerConfig().getPlayer(player);
        if(gPlayer.getChest().equals(EChest.NONE)) {
            player.getInventory().setChestplate(null);
        }

        player.getInventory().setItem(6, realItem.getItem());
    }

    @Override
    @EventHandler
    void onItemMove(InventoryClickEvent event) {
        if (event.getCurrentItem() != null && event.getCurrentItem().isSimilar(realItem.getItem())) {
            event.setCancelled(true);
        }
    }

    @Override
    @EventHandler
    void onItemDrop(PlayerDropItemEvent event) {
        if (event.getItemDrop().getItemStack().isSimilar(realItem.getItem())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onFish(PlayerFishEvent event) {
        if (!event.getHook().isOnGround()) {
            return;
        }

        Player player = event.getPlayer();
        GPlayer gPlayer = Main.getGPlayerConfig().getPlayer(player);
        if (!gPlayer.getGadget().equals(getGadget())) {
            return;
        }

        player.setVelocity(player.getLocation().subtract(event.getHook().getLocation()).toVector().normalize().multiply(-3).setY(.9));
        player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SHOOT, 0.6f, 1.4f);
    }

}

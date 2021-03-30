// -----------------------
// Coded by Pandadoxo
// on 28.03.2021 at 12:27 
// -----------------------

package de.pandadoxo.dox_gadgets.gadget;

import de.pandadoxo.dox_gadgets.Main;
import de.pandadoxo.dox_gadgets.api.gui.Menu.GuiItem;
import de.pandadoxo.dox_gadgets.core.EChest;
import de.pandadoxo.dox_gadgets.core.EGadget;
import de.pandadoxo.dox_gadgets.player.GPlayer;
import org.bukkit.Material;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import java.util.Arrays;

public class GElytra extends Gadget {

    public static final String ELYTRA_NAME = "§8• §2Elytra §8•";
    public static final String ROCKET_NAME = "§8• §aRakete §8•";
    public static final GuiItem showItem = new GuiItem(ELYTRA_NAME, Arrays.asList("§8» §7Eine Elytra mit unendlich", "§8» §7vielen Raketen"), Material.ELYTRA);
    public final GuiItem elytraItem = new GuiItem(ELYTRA_NAME, Material.ELYTRA, true).setUnbreakable(true);
    public final GuiItem rocketItem = new GuiItem(ROCKET_NAME, Material.FIREWORK_ROCKET, true);

    public GElytra(EGadget gadget) {
        super(gadget);
    }

    @Override
    public void onUse(Player player) {
        GPlayer gPlayer = Main.getGPlayerConfig().getPlayer(player);
        gPlayer.setChest(EChest.NONE);

        player.getInventory().setItem(6, rocketItem.getItem());
        player.getInventory().setChestplate(elytraItem.getItem());
    }

    @Override
    @EventHandler
    void onItemMove(InventoryClickEvent event) {
        if (event.getCurrentItem() != null && (event.getCurrentItem().isSimilar(elytraItem.getItem()) || event.getCurrentItem().isSimilar(rocketItem.getItem()))) {
            event.setCancelled(true);
        }
    }

    @Override
    @EventHandler
    void onItemDrop(PlayerDropItemEvent event) {
        if (event.getItemDrop().getItemStack().isSimilar(elytraItem.getItem()) || event.getItemDrop().getItemStack().isSimilar(rocketItem.getItem())) {
            event.setCancelled(true);
        }
    }


    @EventHandler
    public void onLaunch(ProjectileLaunchEvent event) {
        if (!(event.getEntity() instanceof Firework)) {
            return;
        }
        if (event.getEntity().getShooter() == null) {
            return;
        }
        if (!(event.getEntity().getShooter() instanceof Player)) {
            return;
        }

        Firework firework = (Firework) event.getEntity();
        Player player = (Player) event.getEntity().getShooter();
        GPlayer gPlayer = Main.getGPlayerConfig().getPlayer(player);

        if (!gPlayer.getGadget().equals(getGadget())) {
            return;
        }
        if (!firework.getFireworkMeta().getDisplayName().equals(ROCKET_NAME)) {
            return;
        }

        player.getInventory().setItem(6, rocketItem.getItem());
    }
}

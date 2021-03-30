// -----------------------
// Coded by Pandadoxo
// on 23.03.2021 at 20:25 
// -----------------------

package de.pandadoxo.dox_gadgets.gadget;

import de.pandadoxo.dox_gadgets.Main;
import de.pandadoxo.dox_gadgets.api.gui.Menu.GuiItem;
import de.pandadoxo.dox_gadgets.core.EChest;
import de.pandadoxo.dox_gadgets.core.EGadget;
import de.pandadoxo.dox_gadgets.player.GPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.spigotmc.event.entity.EntityDismountEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class GEnderPearl extends Gadget {


    public static final String NAME = "§8• §5Enderperle §8•";
    public static final GuiItem showItem = new GuiItem(NAME, Arrays.asList("§8» §7Eine Enderperle, die unendlich oft", "§8» §7geworfen werden kann"), Material.ENDER_PEARL);
    public final GuiItem realItem = new GuiItem(NAME, Material.ENDER_PEARL, true);
    public final GuiItem cooldownItem = new GuiItem(NAME, Material.FIREWORK_STAR, true);

    public GEnderPearl(EGadget gadget) {
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
        if (event.getCurrentItem() != null && (event.getCurrentItem().isSimilar(realItem.getItem()) || event.getCurrentItem().isSimilar(cooldownItem.getItem()))) {
            event.setCancelled(true);
        }
    }

    @Override
    @EventHandler
    void onItemDrop(PlayerDropItemEvent event) {
        if (event.getItemDrop().getItemStack().isSimilar(realItem.getItem()) || event.getItemDrop().getItemStack().isSimilar(cooldownItem.getItem())) {
            event.setCancelled(true);
        }
    }


    @EventHandler
    public void onLaunch(ProjectileLaunchEvent event) {
        if (!(event.getEntity() instanceof EnderPearl)) {
            return;
        }
        if (event.getEntity().getShooter() == null) {
            return;
        }
        if (!(event.getEntity().getShooter() instanceof Player)) {
            return;
        }

        EnderPearl enderPearl = (EnderPearl) event.getEntity();
        Player player = (Player) event.getEntity().getShooter();
        GPlayer gPlayer = Main.getGPlayerConfig().getPlayer(player);

        if (!gPlayer.getGadget().equals(getGadget())) {
            return;
        }
        if (enderPearl.getItem().getItemMeta() == null || !enderPearl.getItem().getItemMeta().getDisplayName().equals(NAME)) {
            return;
        }

        PearlEntity pearlEntity = new PearlEntity(player, enderPearl, this);
        pearlEntity.particleTask();
        pearlEntity.ride();
    }

    @EventHandler
    public void onHit(ProjectileHitEvent event) {
        if (!(event.getEntity() instanceof EnderPearl)) {
            return;
        }
        if (event.getEntity().getShooter() == null) {
            return;
        }
        if (!(event.getEntity().getShooter() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getEntity().getShooter();

        PearlEntity pearl = PearlEntity.getPearl(player);
        if (pearl == null) {
            return;
        }

        pearl.destroy();
    }

    @EventHandler
    public void onLeave(EntityDismountEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        if (!(event.getDismounted() instanceof EnderPearl)) {
            return;
        }

        Player player = (Player) event.getEntity();

        PearlEntity pearl = PearlEntity.getPearl(player);
        if (pearl == null) {
            return;
        }

        pearl.destroy();
    }

    private static class PearlEntity {

        private static List<PearlEntity> pearlEntities = new ArrayList<>();

        private static PearlEntity getPearl(Player player) {
            for (PearlEntity pearlEntity : pearlEntities) {
                if (pearlEntity.getUuid().equals(player.getUniqueId())) {
                    return pearlEntity;
                }
            }
            return null;
        }

        private UUID uuid;
        private EnderPearl pearl;
        private BukkitTask task;
        private final GEnderPearl pearlInstance;

        public PearlEntity(Player player, EnderPearl pearl, GEnderPearl instance) {
            this.uuid = player.getUniqueId();
            this.pearl = pearl;
            this.pearlInstance = instance;
            Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> player.getInventory().setItem(6, pearlInstance.cooldownItem.getItem()), 1);
            pearlEntities.add(this);
        }

        public void destroy() {
            pearlEntities.remove(this);

            Player player = Bukkit.getPlayer(uuid);

            if (pearl != null && !pearl.isDead() && player != null) {
                pearl.removePassenger(player);
                pearl.remove();
            }
            if (task != null) {
                task.cancel();
            }

            if (player != null) {
                GPlayer gPlayer = Main.getGPlayerConfig().getPlayer(player);
                if (gPlayer.getGadget().equals(pearlInstance.getGadget())) {
                    Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> player.getInventory().setItem(6, pearlInstance.realItem.getItem()), 10L);
                }
            }
        }

        public void particleTask() {
            task = new BukkitRunnable() {
                @Override
                public void run() {
                    spawnParticle();
                }
            }.runTaskTimer(Main.getInstance(), 0L, 1L);
        }

        public void spawnParticle() {
            if (pearl != null && !pearl.isDead()) {
                pearl.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, pearl.getLocation(), 1, 0, 0, 0, 0);
            } else {
                destroy();
            }
        }

        public void ride() {
            Player player = Bukkit.getPlayer(uuid);
            if (pearl != null && !pearl.isDead() && player != null) {
                pearl.addPassenger(player);
            }
        }

        public UUID getUuid() {
            return uuid;
        }

        public void setUuid(UUID uuid) {
            this.uuid = uuid;
        }

        public EnderPearl getPearl() {
            return pearl;
        }

        public void setPearl(EnderPearl pearl) {
            this.pearl = pearl;
        }

    }
}

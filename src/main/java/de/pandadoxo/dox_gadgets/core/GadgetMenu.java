// -----------------------
// Coded by Pandadoxo
// on 28.03.2021 at 12:16 
// -----------------------

package de.pandadoxo.dox_gadgets.core;

import de.pandadoxo.dox_gadgets.Main;
import de.pandadoxo.dox_gadgets.api.gui.Buttons.NormalButton;
import de.pandadoxo.dox_gadgets.api.gui.Listener.ButtonPressedListener;
import de.pandadoxo.dox_gadgets.api.gui.Menu.GuiItem;
import de.pandadoxo.dox_gadgets.api.gui.Menu.GuiMenu;
import de.pandadoxo.dox_gadgets.armor.boots.BRainbow;
import de.pandadoxo.dox_gadgets.armor.boots.Boots;
import de.pandadoxo.dox_gadgets.armor.chest.CRainbow;
import de.pandadoxo.dox_gadgets.armor.chest.Chest;
import de.pandadoxo.dox_gadgets.armor.helmet.*;
import de.pandadoxo.dox_gadgets.armor.leggings.LRainbow;
import de.pandadoxo.dox_gadgets.armor.leggings.Leggings;
import de.pandadoxo.dox_gadgets.gadget.GElytra;
import de.pandadoxo.dox_gadgets.gadget.GEnderPearl;
import de.pandadoxo.dox_gadgets.gadget.GGrapplingHook;
import de.pandadoxo.dox_gadgets.gadget.Gadget;
import de.pandadoxo.dox_gadgets.player.GPlayer;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GadgetMenu {

    private Player player;
    private GPlayer gPlayer;
    private GuiMenu mainMenu;
    private GuiMenu helmetMenu;
    private GuiMenu chestMenu;
    private GuiMenu leggingsMenu;
    private GuiMenu bootsMenu;
    private GuiMenu gadgetMenu;
    private final GuiItem whiteSpace = new GuiItem(" ", Material.GRAY_STAINED_GLASS_PANE);
    private final GuiItem backItem = new GuiItem("§c« §8| §7Zurück", Material.SPRUCE_DOOR);

    public GadgetMenu(Player player) {
        this.player = player;
        this.gPlayer = Main.getGPlayerConfig().getPlayer(player);
    }

    public void clearMenus() {
        mainMenu.getInventory().clear();
        helmetMenu.getInventory().clear();
        chestMenu.getInventory().clear();
        leggingsMenu.getInventory().clear();
        bootsMenu.getInventory().clear();
        gadgetMenu.getInventory().clear();
    }

    public void prepareMenus() {
        //clearMenus();
        prepareMainMenu();
        prepareItemsMenu();
        prepareHelmetMenu();
        prepareChestMenu();
        prepareLeggingsMenu();
        prepareBootsMenu();
    }

    public void prepareMainMenu() {
        this.mainMenu = new GuiMenu("§8» §7Gadgets", 5 * 9, player);

        //Main Menu
        GuiItem mainMenuGadget = new GuiItem("§8• §aExtras §8•", Material.BLAZE_POWDER);
        GuiItem mainMenuHelmet = new GuiItem("§8• §6Helme §8•", Material.LEATHER_HELMET).setLeatherArmorColor(Color.fromRGB(85, 255, 85));
        GuiItem mainMenuChest = new GuiItem("§8• §6Brustplatten §8•", Material.LEATHER_CHESTPLATE).setLeatherArmorColor(Color.fromRGB(85, 255, 85));
        GuiItem mainMenuLeggings = new GuiItem("§8• §6Hosen §8•", Material.LEATHER_LEGGINGS).setLeatherArmorColor(Color.fromRGB(85, 255, 85));
        GuiItem mainMenuBoots = new GuiItem("§8• §6Schuhe §8•", Material.LEATHER_BOOTS).setLeatherArmorColor(Color.fromRGB(85, 255, 85));

      /*  switch (gPlayer.getGadget()) {
            default:
                mainMenuGadget = Gadget.defaultItem;
                break;
            case ELYTRA:
                mainMenuGadget = GElytra.showItem.advancedCopy().setShine(true);
                break;
            case ENDERPEARL:
                mainMenuGadget = GEnderPearl.showItem.advancedCopy().setShine(true);
                break;
            case GRAPPLING_HOOK:
                mainMenuGadget = GGrapplingHook.showItem.advancedCopy().setShine(true);
                break;
        }
        switch (gPlayer.getHelmet()) {
            default:
                mainMenuHelmet = Helmet.defaultItem;
                break;
            case RAINBOW:
                mainMenuHelmet = HRainbow.showItem.advancedCopy().setShine(true);
                break;
            case REDSTONE_TORCH:
                mainMenuHelmet = HRedstoneTorch.showItem.advancedCopy().setShine(true);
                break;
            case TURTLE:
                mainMenuHelmet = HTurtle.showItem.advancedCopy().setShine(true);
                break;
            case END_ROD:
                mainMenuHelmet = HEndRod.showItem.advancedCopy().setShine(true);
                break;
        }
        switch (gPlayer.getChest()) {
            default:
                mainMenuChest = Chest.defaultItem;
                break;
            case RAINBOW:
                mainMenuChest = CRainbow.showItem.advancedCopy().setShine(true);
                break;
        }
        switch (gPlayer.getLeggings()) {
            default:
                mainMenuLeggings = Leggings.defaultItem;
                break;
            case RAINBOW:
                mainMenuLeggings = LRainbow.showItem.advancedCopy().setShine(true);
                break;
        }
        switch (gPlayer.getBoots()) {
            default:
                mainMenuBoots = Boots.defaultItem;
                break;
            case RAINBOW:
                mainMenuBoots = BRainbow.showItem.advancedCopy().setShine(true);
                break;
        }*/

        for (int i = 0; i < mainMenu.getSize(); i++) mainMenu.getInventory().setItem(i, whiteSpace.getItem());

        new NormalButton(mainMenuGadget, mainMenu, 31, true, new ButtonPressedListener() {
            @Override
            public boolean onPressed(ClickType clickType, GuiMenu menu, GuiItem icon, int slot) {
                openItemsMenu();
                return true;
            }
        });
        new NormalButton(mainMenuHelmet, mainMenu, 10, true, new ButtonPressedListener() {
            @Override
            public boolean onPressed(ClickType clickType, GuiMenu menu, GuiItem icon, int slot) {
                openHelmetMenu();
                return true;
            }
        });
        new NormalButton(mainMenuChest, mainMenu, 12, true, new ButtonPressedListener() {
            @Override
            public boolean onPressed(ClickType clickType, GuiMenu menu, GuiItem icon, int slot) {
                openChestMenu();
                return true;
            }
        });
        new NormalButton(mainMenuLeggings, mainMenu, 14, true, new ButtonPressedListener() {
            @Override
            public boolean onPressed(ClickType clickType, GuiMenu menu, GuiItem icon, int slot) {
                openLeggingsMenu();
                return true;
            }
        });
        new NormalButton(mainMenuBoots, mainMenu, 16, true, new ButtonPressedListener() {
            @Override
            public boolean onPressed(ClickType clickType, GuiMenu menu, GuiItem icon, int slot) {
                openBootsMenu();
                return true;
            }
        });
    }

    public void prepareItemsMenu() {
        this.gadgetMenu = new GuiMenu("§8» §7Items", 3 * 9, player);
        for (int i = 0; i < gadgetMenu.getSize(); i++) {
            gadgetMenu.getInventory().setItem(i, whiteSpace.getItem());
            if (i >= 9 && i < gadgetMenu.getSize() - 9 && i % 9 == 0) i += 7;
        }


        for (EGadget eGadget : EGadget.values()) {
            GuiItem item = eGadget.getItem().advancedCopy().setShine(gPlayer.getGadget().equals(eGadget) && !eGadget.equals(EGadget.NONE));
            item.setName(item.getName() + " §8| " + (gPlayer.getGadget().equals(eGadget) ? "§aAktiviert" : "§cDeaktiviert"));
            List<String> lore = new ArrayList<>(item.getLore() != null ? item.getLore() : Collections.emptyList());
            lore.add(" ");
            lore.add(player.hasPermission(eGadget.getPermission()) ? "§a✔ §8| §7Du besitzt dieses Item" : "§c❌ §8| §7Du besitzt dieses Item nicht");
            if (!eGadget.equals(EGadget.NONE)) item.setLore(lore);
            new NormalButton(item, gadgetMenu, eGadget.getSlot(), true, new ButtonPressedListener() {
                @Override
                public boolean onPressed(ClickType clickType, GuiMenu menu, GuiItem icon, int slot) {
                    if (!player.hasPermission(eGadget.getPermission()) && !eGadget.equals(EGadget.NONE)) {
                        openItemsMenu();
                        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_DIDGERIDOO, 1, 1);
                        return false;
                    }

                    gPlayer.setGadget(eGadget);
                    switch (eGadget) {
                        case NONE:
                            Main.getGadgetCore().getgNone().onUse(player);
                            break;
                        case ENDERPEARL:
                            Main.getGadgetCore().getgEnderPearl().onUse(player);
                            break;
                        case ELYTRA:
                            Main.getGadgetCore().getgElytra().onUse(player);
                            break;
                        case GRAPPLING_HOOK:
                            Main.getGadgetCore().getgGrapplingHook().onUse(player);
                            break;
                    }
                    openItemsMenu();
                    return true;
                }
            });
        }

        new NormalButton(backItem, gadgetMenu, 18, true, new ButtonPressedListener() {
            @Override
            public boolean onPressed(ClickType clickType, GuiMenu menu, GuiItem icon, int slot) {
                prepareMainMenu();
                openMainMenu();
                return true;
            }
        });
    }

    public void prepareHelmetMenu() {
        this.helmetMenu = new GuiMenu("§8» §7Helme", 3 * 9, player);
        for (int i = 0; i < helmetMenu.getSize(); i++) {
            helmetMenu.getInventory().setItem(i, whiteSpace.getItem());
            if (i >= 9 && i < helmetMenu.getSize() - 9 && i % 9 == 0) i += 7;
        }

        for (EHelmet eHelmet : EHelmet.values()) {
            GuiItem item = eHelmet.getItem().advancedCopy().setShine(gPlayer.getHelmet().equals(eHelmet) && !eHelmet.equals(EHelmet.NONE));
            item.setName(item.getName() + " §8| " + (gPlayer.getHelmet().equals(eHelmet) ? "§aAktiviert" : "§cDeaktiviert"));
            List<String> lore = new ArrayList<>(item.getLore() != null ? item.getLore() : Collections.emptyList());
            lore.add(" ");
            lore.add(player.hasPermission(eHelmet.getPermission()) ? "§a✔ §8| §7Du besitzt dieses Item" : "§c❌ §8| §7Du besitzt dieses Item nicht");
            if (!eHelmet.equals(EHelmet.NONE)) item.setLore(lore);
            new NormalButton(item, helmetMenu, eHelmet.getSlot(), true, new ButtonPressedListener() {
                @Override
                public boolean onPressed(ClickType clickType, GuiMenu menu, GuiItem icon, int slot) {
                    if (!player.hasPermission(eHelmet.getPermission()) && !eHelmet.equals(EHelmet.NONE)) {
                        openHelmetMenu();
                        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_DIDGERIDOO, 1, 1);
                        return false;
                    }

                    gPlayer.setHelmet(eHelmet);
                    switch (eHelmet) {
                        case NONE:
                            Main.getGadgetCore().gethNone().onUse(player);
                            break;
                        case RAINBOW:
                            Main.getGadgetCore().gethRainbow().onUse(player);
                            break;
                        case REDSTONE_TORCH:
                            Main.getGadgetCore().gethRedstoneTorch().onUse(player);
                            break;
                        case END_ROD:
                            Main.getGadgetCore().gethEndRod().onUse(player);
                            break;
                        case TURTLE:
                            Main.getGadgetCore().gethTurtle().onUse(player);
                            break;
                        case ASTRONAUT:
                            Main.getGadgetCore().gethAstronaut().onUse(player);
                            break;
                    }
                    openHelmetMenu();
                    return true;
                }
            });
        }

        for (int i = mainMenu.getSize() - 9; i < mainMenu.getSize(); i++) mainMenu.getInventory().setItem(i, whiteSpace.getItem());

        new NormalButton(backItem, helmetMenu, 18, true, new ButtonPressedListener() {
            @Override
            public boolean onPressed(ClickType clickType, GuiMenu menu, GuiItem icon, int slot) {
                prepareMainMenu();
                openMainMenu();
                return true;
            }
        });
    }

    public void prepareChestMenu() {
        this.chestMenu = new GuiMenu("§8» §7Brustplatten", 3 * 9, player);
        for (int i = 0; i < chestMenu.getSize(); i++) {
            chestMenu.getInventory().setItem(i, whiteSpace.getItem());
            if (i >= 9 && i < chestMenu.getSize() - 9 && i % 9 == 0) i += 7;
        }

        for (EChest eChest : EChest.values()) {
            GuiItem item = eChest.getItem().advancedCopy().setShine(gPlayer.getChest().equals(eChest) && !eChest.equals(EChest.NONE));
            item.setName(item.getName() + " §8| " + (gPlayer.getChest().equals(eChest) ? "§aAktiviert" : "§cDeaktiviert"));
            List<String> lore = new ArrayList<>(item.getLore() != null ? item.getLore() : Collections.emptyList());
            lore.add(" ");
            lore.add(player.hasPermission(eChest.getPermission()) ? "§a✔ §8| §7Du besitzt dieses Item" : "§c❌ §8| §7Du besitzt dieses Item nicht");
            if (!eChest.equals(EChest.NONE)) item.setLore(lore);
            new NormalButton(item, chestMenu, eChest.getSlot(), true, new ButtonPressedListener() {
                @Override
                public boolean onPressed(ClickType clickType, GuiMenu menu, GuiItem icon, int slot) {
                    if (!player.hasPermission(eChest.getPermission()) && !eChest.equals(EChest.NONE)) {
                        openChestMenu();
                        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_DIDGERIDOO, 1, 1);
                        return false;
                    }

                    gPlayer.setChest(eChest);
                    switch (eChest) {
                        case NONE:
                            Main.getGadgetCore().getcNone().onUse(player);
                            break;
                        case RAINBOW:
                            Main.getGadgetCore().getcRainbow().onUse(player);
                            break;
                    }
                    openChestMenu();
                    return true;
                }
            });
        }

        for (int i = mainMenu.getSize() - 9; i < mainMenu.getSize(); i++) mainMenu.getInventory().setItem(i, whiteSpace.getItem());

        new NormalButton(backItem, chestMenu, 18, true, new ButtonPressedListener() {
            @Override
            public boolean onPressed(ClickType clickType, GuiMenu menu, GuiItem icon, int slot) {
                prepareMainMenu();
                openMainMenu();
                return true;
            }
        });
    }

    public void prepareLeggingsMenu() {
        this.leggingsMenu = new GuiMenu("§8» §7Hosen", 3 * 9, player);
        for (int i = 0; i < leggingsMenu.getSize(); i++) {
            leggingsMenu.getInventory().setItem(i, whiteSpace.getItem());
            if (i >= 9 && i < leggingsMenu.getSize() - 9 && i % 9 == 0) i += 7;
        }

        for (ELeggings eLeggings : ELeggings.values()) {
            GuiItem item = eLeggings.getItem().advancedCopy().setShine(gPlayer.getLeggings().equals(eLeggings) && !eLeggings.equals(ELeggings.NONE));
            item.setName(item.getName() + " §8| " + (gPlayer.getLeggings().equals(eLeggings) ? "§aAktiviert" : "§cDeaktiviert"));
            List<String> lore = new ArrayList<>(item.getLore() != null ? item.getLore() : Collections.emptyList());
            lore.add(" ");
            lore.add(player.hasPermission(eLeggings.getPermission()) ? "§a✔ §8| §7Du besitzt dieses Item" : "§c❌ §8| §7Du besitzt dieses Item nicht");
            if (!eLeggings.equals(ELeggings.NONE)) item.setLore(lore);
            new NormalButton(item, leggingsMenu, eLeggings.getSlot(), true, new ButtonPressedListener() {
                @Override
                public boolean onPressed(ClickType clickType, GuiMenu menu, GuiItem icon, int slot) {
                    if (!player.hasPermission(eLeggings.getPermission()) && !eLeggings.equals(ELeggings.NONE)) {
                        openLeggingsMenu();
                        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_DIDGERIDOO, 1, 1);
                        return false;
                    }

                    gPlayer.setLeggings(eLeggings);
                    switch (eLeggings) {
                        case NONE:
                            Main.getGadgetCore().getlNone().onUse(player);
                            break;
                        case RAINBOW:
                            Main.getGadgetCore().getlRainbow().onUse(player);
                            break;
                    }
                    openLeggingsMenu();
                    return true;
                }
            });
        }

        for (int i = mainMenu.getSize() - 9; i < mainMenu.getSize(); i++) mainMenu.getInventory().setItem(i, whiteSpace.getItem());

        new NormalButton(backItem, leggingsMenu, 18, true, new ButtonPressedListener() {
            @Override
            public boolean onPressed(ClickType clickType, GuiMenu menu, GuiItem icon, int slot) {
                prepareMainMenu();
                openMainMenu();
                return true;
            }
        });
    }

    public void prepareBootsMenu() {
        this.bootsMenu = new GuiMenu("§8» §7Schuhe", 3 * 9, player);
        for (int i = 0; i < bootsMenu.getSize(); i++) {
            bootsMenu.getInventory().setItem(i, whiteSpace.getItem());
            if (i >= 9 && i < bootsMenu.getSize() - 9 && i % 9 == 0) i += 7;
        }

        for (EBoots eBoots : EBoots.values()) {
            GuiItem item = eBoots.getItem().advancedCopy().setShine(gPlayer.getBoots().equals(eBoots) && !eBoots.equals(EBoots.NONE));
            item.setName(item.getName() + " §8| " + (gPlayer.getBoots().equals(eBoots) ? "§aAktiviert" : "§cDeaktiviert"));
            List<String> lore = new ArrayList<>(item.getLore() != null ? item.getLore() : Collections.emptyList());
            lore.add(" ");
            lore.add(player.hasPermission(eBoots.getPermission()) ? "§a✔ §8| §7Du besitzt dieses Item" : "§c❌ §8| §7Du besitzt dieses Item nicht");
            if (!eBoots.equals(EBoots.NONE)) item.setLore(lore);
            new NormalButton(item, bootsMenu, eBoots.getSlot(), true, new ButtonPressedListener() {
                @Override
                public boolean onPressed(ClickType clickType, GuiMenu menu, GuiItem icon, int slot) {
                    if (!player.hasPermission(eBoots.getPermission()) && !eBoots.equals(EBoots.NONE)) {
                        openBootsMenu();
                        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_DIDGERIDOO, 1, 1);
                        return false;
                    }

                    gPlayer.setBoots(eBoots);
                    switch (eBoots) {
                        case NONE:
                            Main.getGadgetCore().getbNone().onUse(player);
                            break;
                        case RAINBOW:
                            Main.getGadgetCore().getbRainbow().onUse(player);
                            break;
                        case FIRE:
                            Main.getGadgetCore().getbFire().onUse(player);
                            break;
                        case LOVE:
                            Main.getGadgetCore().getbLove().onUse(player);
                            break;
                    }
                    openBootsMenu();
                    return true;
                }
            });
        }

        for (int i = mainMenu.getSize() - 9; i < mainMenu.getSize(); i++) mainMenu.getInventory().setItem(i, whiteSpace.getItem());

        new NormalButton(backItem, bootsMenu, 18, true, new ButtonPressedListener() {
            @Override
            public boolean onPressed(ClickType clickType, GuiMenu menu, GuiItem icon, int slot) {
                prepareMainMenu();
                openMainMenu();
                return true;
            }
        });
    }

    public void openMainMenu() {
        prepareMainMenu();
        player.openInventory(mainMenu.getInventory());
    }

    public void openHelmetMenu() {
        prepareHelmetMenu();
        player.openInventory(helmetMenu.getInventory());
    }

    public void openChestMenu() {
        prepareChestMenu();
        player.openInventory(chestMenu.getInventory());
    }

    public void openLeggingsMenu() {
        prepareLeggingsMenu();
        player.openInventory(leggingsMenu.getInventory());
    }

    public void openBootsMenu() {
        prepareBootsMenu();
        player.openInventory(bootsMenu.getInventory());
    }

    public void openItemsMenu() {
        prepareItemsMenu();
        player.openInventory(gadgetMenu.getInventory());
    }


}

package de.pandadoxo.dox_gadgets.api.gui.Menu;

import de.pandadoxo.dox_gadgets.Main;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;
import org.bukkit.potion.PotionEffect;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuiItem {

    private String name;
    private List<String> lore;
    private Material type;
    private String skin;
    private ItemStack item;
    private Color leatherArmorColor;
    private ChatColor potionColor;
    private boolean shine;
    private boolean unbreakable;
    private int durability;
    private PotionEffect potionEffect;
    private HashMap<Enchantment, Integer> enchantments = new HashMap<>();

    public String getName() {
        return name;
    }

    public GuiItem setName(String name) {
        this.name = name;
        ItemMeta itemMeta = this.item.getItemMeta();
        itemMeta.setDisplayName(name);
        this.item.setItemMeta(itemMeta);
        return this;
    }

    public List<String> getLore() {
        return lore;
    }

    public GuiItem setLore(List<String> lore) {
        this.lore = lore;
        ItemMeta itemMeta = this.item.getItemMeta();
        itemMeta.setLore(lore);
        this.item.setItemMeta(itemMeta);
        return this;
    }

    public Color getLeatherArmorColor() {
        return leatherArmorColor;
    }

    public GuiItem setLeatherArmorColor(ChatColor leatherArmorColor) {
        this.leatherArmorColor = Main.getColorUtil().getColorMap().get(leatherArmorColor);
        LeatherArmorMeta itemMeta = (LeatherArmorMeta) this.item.getItemMeta();
        itemMeta.setColor(Main.getColorUtil().getColorMap().get(leatherArmorColor));
        this.item.setItemMeta(itemMeta);
        return this;
    }

    public GuiItem setLeatherArmorColor(Color leatherArmorColor) {
        this.leatherArmorColor = leatherArmorColor;
        LeatherArmorMeta itemMeta = (LeatherArmorMeta) this.item.getItemMeta();
        itemMeta.setColor(leatherArmorColor);
        this.item.setItemMeta(itemMeta);
        return this;
    }

    public ChatColor getPotionColor() {
        return potionColor;
    }

    public GuiItem setPotionColor(ChatColor potionColor) {
        this.potionColor = potionColor;
        PotionMeta itemMeta = (PotionMeta) this.item.getItemMeta();
        itemMeta.setColor(Main.getColorUtil().getColorMap().get(potionColor));
        this.item.setItemMeta(itemMeta);
        return this;
    }

    public Material getType() {
        return type;
    }

    public void setType(Material type) {
        this.type = type;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public ItemStack getItem() {
        return item;
    }

    public GuiItem setItem(ItemStack item) {
        this.item = item;
        return this;
    }

    public GuiItem setShine(boolean shine) {
        this.shine = shine;
        ItemMeta itemMeta = this.item.getItemMeta();
        if (shine) itemMeta.addEnchant(Enchantment.DURABILITY, 2, true);
        else itemMeta.removeEnchant(Enchantment.DURABILITY);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        this.item.setItemMeta(itemMeta);
        return this;
    }

    public GuiItem setDurability(int durability) {
        this.durability = durability;
        Damageable itemMeta = (Damageable) this.item.getItemMeta();
        itemMeta.setDamage((int) (this.type.getMaxDurability()) - durability);
        this.item.setItemMeta((ItemMeta) itemMeta);
        return this;
    }


    public int getDurability() {
        return durability;
    }

    public GuiItem setUnbreakable(boolean unbreakable) {
        this.unbreakable = unbreakable;
        ItemMeta itemMeta = this.item.getItemMeta();
        itemMeta.setUnbreakable(unbreakable);
        this.item.setItemMeta(itemMeta);
        return this;
    }

    public boolean isUnbreakable() {
        return unbreakable;
    }

    public GuiItem setPotionEffect(PotionEffect potionEffect) {
        this.potionEffect = potionEffect;
        PotionMeta itemMeta = (PotionMeta) this.item.getItemMeta();
        itemMeta.setColor(potionEffect.getType().getColor());
        itemMeta.addCustomEffect(potionEffect, false);
        this.item.setItemMeta(itemMeta);
        return this;
    }

    public GuiItem hideEnchantments(boolean hide) {
        ItemMeta itemMeta = this.item.getItemMeta();
        if (hide) {
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        } else {
            itemMeta.removeItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        this.item.setItemMeta(itemMeta);
        return this;
    }

    public PotionEffect getPotionEffect() {
        return potionEffect;
    }

    public boolean isShine() {
        return shine;
    }

    public GuiItem(String name, Material type) {
        this(name, null, type);
    }

    public GuiItem(String name, Material type, boolean shine) {
        this(name, null, type, null, false, shine);
    }

    public GuiItem(String name, List<String> lore, Material type) {
        this(name, lore, type, null);
    }

    public GuiItem(String name, List<String> lore, Material type, String skin) {
        this(name, lore, type, skin, false);
    }

    public GuiItem(String name, List<String> lore, Material type, String skin, boolean unbreakable) {
        this(name, lore, type, skin, unbreakable, false);
    }

    public GuiItem(String name, List<String> lore, Material type, String skin, boolean unbreakable, boolean shine) {
        this(name, lore, type, skin, unbreakable, shine, new Enchantment[0]);
    }

    public GuiItem(String name, List<String> lore, Material type, String skin, Map<Enchantment, Integer> enchantments) {
        this.name = name;
        this.lore = lore;
        this.type = type;
        this.skin = null;
        this.shine = false;
        this.item = new ItemStack(type);
        this.enchantments = new HashMap<>(enchantments);

        if (type != Material.PLAYER_HEAD) {
            ItemMeta itemMeta = this.item.getItemMeta();
            itemMeta.setDisplayName(name);
            itemMeta.setLore(lore);
            for (Enchantment e : enchantments.keySet()) itemMeta.addEnchant(e, enchantments.get(e), true);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            this.item.setItemMeta(itemMeta);
        } else {
            SkullMeta skullMeta = (SkullMeta) this.item.getItemMeta();
            skullMeta.setDisplayName(name);
            skullMeta.setLore(lore);
            skullMeta.setOwner(skin);
            for (Enchantment e : enchantments.keySet()) skullMeta.addEnchant(e, enchantments.get(e), true);
            skullMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            skullMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            this.item.setItemMeta(skullMeta);
        }
    }

    public GuiItem(String name, List<String> lore, Material type, String skin, boolean unbreakable, boolean shine, Enchantment... enchantments) {
        this.name = name;
        this.lore = lore;
        this.type = type;
        this.skin = skin;
        this.shine = shine;
        this.item = new ItemStack(type);

        if (type != Material.PLAYER_HEAD) {
            ItemMeta itemMeta = this.item.getItemMeta();
            itemMeta.setDisplayName(name);
            itemMeta.setLore(lore);
            itemMeta.setUnbreakable(unbreakable);
            if (shine) itemMeta.addEnchant(Enchantment.DURABILITY, 2, true);
            for (Enchantment e : enchantments) itemMeta.addEnchant(e, 1, true);
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            this.item.setItemMeta(itemMeta);
        } else {
            SkullMeta skullMeta = (SkullMeta) this.item.getItemMeta();
            skullMeta.setDisplayName(name);
            skullMeta.setLore(lore);
            skullMeta.setOwner(skin);
            skullMeta.setUnbreakable(unbreakable);
            if (shine) skullMeta.addEnchant(Enchantment.DURABILITY, 2, true);
            for (Enchantment e : enchantments) skullMeta.addEnchant(e, 1, true);
            skullMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            skullMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            this.item.setItemMeta(skullMeta);
        }
    }

    public GuiItem(String name, List<String> lore, ItemStack item, boolean shine) {
        this.name = name;
        this.lore = lore;
        this.type = item.getType();
        this.skin = null;
        this.item = item;

        ItemMeta itemMeta = this.item.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        if (shine) itemMeta.addEnchant(Enchantment.DURABILITY, 2, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        this.item.setItemMeta(itemMeta);

    }

    public GuiItem simpleCopy() {
        return new GuiItem(name, lore, type, skin);
    }

    public GuiItem advancedCopy() {
        GuiItem item = new GuiItem(name, lore, type, skin, enchantments).setShine(shine);
        if (durability != 0) {
            item.setDurability(durability);
        }
        if (potionEffect != null) {
            item.setPotionEffect(potionEffect);
        }
        if (potionColor != null) {
            item.setPotionColor(potionColor);
        }
        if (leatherArmorColor != null) {
            item.setLeatherArmorColor(leatherArmorColor);
        }
        item.setUnbreakable(unbreakable);
        item.hideEnchantments(enchantments == null || enchantments.isEmpty());

        return item;
    }

}

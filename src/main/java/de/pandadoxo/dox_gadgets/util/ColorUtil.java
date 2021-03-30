// -----------------------
// Coded by Pandadoxo
// on 20.03.2021 at 19:39 
// -----------------------

package de.pandadoxo.dox_gadgets.util;

import de.pandadoxo.dox_gadgets.Main;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColorUtil {

    private static final int n = 120;
    private static int i = 0;
    private static BukkitTask rainbowTask;

    private final Map<ChatColor, Color> colorMap = new HashMap<>();

    public ColorUtil() {
        colorMap.put(ChatColor.BLACK, Color.fromRGB(0, 0, 0));
        colorMap.put(ChatColor.DARK_BLUE, Color.fromRGB(0, 0, 170));
        colorMap.put(ChatColor.DARK_GREEN, Color.fromRGB(0, 170, 0));
        colorMap.put(ChatColor.DARK_AQUA, Color.fromRGB(0, 170, 170));
        colorMap.put(ChatColor.DARK_RED, Color.fromRGB(170, 0, 0));
        colorMap.put(ChatColor.DARK_PURPLE, Color.fromRGB(170, 0, 170));
        colorMap.put(ChatColor.GOLD, Color.fromRGB(255, 170, 0));
        colorMap.put(ChatColor.GRAY, Color.fromRGB(170, 170, 170));
        colorMap.put(ChatColor.DARK_GRAY, Color.fromRGB(85, 85, 85));
        colorMap.put(ChatColor.BLUE, Color.fromRGB(85, 85, 255));
        colorMap.put(ChatColor.GREEN, Color.fromRGB(85, 255, 85));
        colorMap.put(ChatColor.AQUA, Color.fromRGB(85, 255, 255));
        colorMap.put(ChatColor.RED, Color.fromRGB(255, 85, 85));
        colorMap.put(ChatColor.LIGHT_PURPLE, Color.fromRGB(255, 85, 255));
        colorMap.put(ChatColor.YELLOW, Color.fromRGB(255, 255, 85));
        colorMap.put(ChatColor.WHITE, Color.fromRGB(255, 255, 255));
    }

    public ColorUtil startRainbow() {
        if (rainbowTask == null) {
            rainbowTask = new BukkitRunnable() {
                @Override
                public void run() {
                    i++;
                    if (i >= n) {
                        i = 0;
                    }
                }
            }.runTaskTimer(Main.getInstance(), 0, 1);
        }
        return this;
    }

    public ColorUtil stopRainbow() {
        if (rainbowTask != null) {
            rainbowTask.cancel();
        }
        return this;
    }

    public Map<ChatColor, Color> getColorMap() {
        return colorMap;
    }

    public Color getRainbowColor() {
        return Color.fromBGR(rainbowColors().get(i).getRed(), rainbowColors().get(i).getBlue(), rainbowColors().get(i).getGreen());
    }

    private List<java.awt.Color> rainbowColors() {
        List<java.awt.Color> clut = new ArrayList<java.awt.Color>(n);
        for (int i = 0; i < n; i++) {
            clut.add(java.awt.Color.getHSBColor((float) i / n, 1, 1));
        }
        return clut;
    }
}

// -----------------------
// Coded by Pandadoxo
// on 20.03.2021 at 18:23 
// -----------------------

package de.pandadoxo.dox_gadgets.player;

import de.pandadoxo.dox_gadgets.core.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GPlayerConfig {

    public List<GPlayer> players = new ArrayList<>();

    public GPlayer getPlayer(Player player) {
        for (GPlayer gPlayer : players) {
            if (gPlayer.getUuid().equals(player.getUniqueId().toString())) {
                return gPlayer;
            }
        }
        return createPlayer(player);
    }

    public GPlayer createPlayer(Player player) {
        GPlayer gPlayer = new GPlayer(player.getUniqueId().toString(), EGadget.NONE, EHelmet.NONE, EChest.NONE, ELeggings.NONE, EBoots.NONE);
        players.add(gPlayer);
        return gPlayer;
    }

}

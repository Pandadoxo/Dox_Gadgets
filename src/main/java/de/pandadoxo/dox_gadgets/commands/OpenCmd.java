// -----------------------
// Coded by Pandadoxo
// on 28.03.2021 at 12:04 
// -----------------------

package de.pandadoxo.dox_gadgets.commands;

import de.pandadoxo.dox_gadgets.Main;
import de.pandadoxo.dox_gadgets.core.GadgetMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpenCmd implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        final String syntax = Main.WRONGSYNTAX() + "/open_gadgets <Token>";

        if (!(sender instanceof Player))
            return true;
        Player p = (Player) sender;
        if (!Main.getDoxperm().has(p, "gadgets.open", true)) {
            return true;
        }

        if(args.length != 1) {
            p.sendMessage(syntax);
            return true;
        }

        String token = args[0];
        if(!token.equals(Main.TOKEN())) {
            p.sendMessage(Main.PREFIX() + "§7Falscher Token!");
            return true;
        }

        GadgetMenu menu = new GadgetMenu(p);
        menu.prepareMenus();
        menu.openMainMenu();
        return false;
    }


}
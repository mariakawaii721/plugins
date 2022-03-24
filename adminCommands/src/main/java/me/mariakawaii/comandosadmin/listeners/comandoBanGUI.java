package me.mariakawaii.comandosadmin.listeners;

import me.mariakawaii.comandosadmin.classes.banGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class comandoBanGUI implements CommandExecutor {

    static banGUI plugin;

    public comandoBanGUI(banGUI plugin) {
        comandoBanGUI.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
                plugin.abrirGUI(p);
        }
        return true;
    }
}

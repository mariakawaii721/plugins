package me.mariakawaii.comandosadmin.comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class comandoNoche implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("adminCommands.noche")){
                p.getLocation().getWorld().setTime(13000);
            }else {
                p.sendMessage(ChatColor.RED + "¿Le tienes miedo al sol o qué?");
            }
        }
        return true;
    }
}

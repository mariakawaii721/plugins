package me.mariakawaii.comandosadmin.comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class comandoDia implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("adminCommands.dia")){
                p.getLocation().getWorld().setTime(1000);
            }else{
                p.sendMessage(ChatColor.RED + "Menos trucos Harry   ");
            }

        }
        return true;
    }
}

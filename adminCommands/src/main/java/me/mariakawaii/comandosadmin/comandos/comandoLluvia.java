package me.mariakawaii.comandosadmin.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class comandoLluvia implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("adminComamnds.lluvia")){
                World mundo = Bukkit.getWorlds().get(0);
                mundo.setStorm(true);
            }else {
                p.sendMessage(ChatColor.RED + "No eres Dios, para");
            }

        }
        return true;
    }
}


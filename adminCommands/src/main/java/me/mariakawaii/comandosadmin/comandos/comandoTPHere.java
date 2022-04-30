package me.mariakawaii.comandosadmin.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class comandoTPHere implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;

            if(args.length == 0){
                p.sendMessage(ChatColor.RED + "Añade el nick de un jugador para poder usar el comando");
            }else{
                Player jugadorAteletransportar = Bukkit.getPlayer(args[0]);
                jugadorAteletransportar.teleport(p.getLocation());

            }
        }


        return true;
    }
}

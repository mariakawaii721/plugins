package me.mariakawaii.comandosadmin.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class comandoTP implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("adminCommands.tp")){
                if(args.length == 0){
                    p.sendMessage(ChatColor.RED + "Añade el nick de un jugador para teletransportate");
                }else if(args.length == 1){
                    Player objetivo = Bukkit.getPlayer(args[0]);
                    p.teleport(objetivo.getLocation());
                }else if(args.length == 2){
                    Player jugadorAteletransportar = Bukkit.getPlayer(args[0]);
                    Player objetivo = Bukkit.getPlayer(args[1]);
                    jugadorAteletransportar.teleport(objetivo.getLocation());
                }
            }else {
                p.sendMessage(ChatColor.RED + "You are not a wizzard Harry");
            }

        }

        return true;
    }
}

package me.mariakawaii.comandosadmin.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class comandoFly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("adminCommands.fly")){
                if(args.length == 0){
                    comandoFlight(p);
                }else if(args.length == 1){
                    Player jugadorFly = Bukkit.getPlayer(args[0]);
                    comandoFlight(jugadorFly);
                }
            }else {
                p.sendMessage(ChatColor.RED + "A patita vas =D");
            }

        }
        return true;
    }

    private void comandoFlight(Player p){
        if(!p.getAllowFlight()){
            p.setAllowFlight(true);
            p.sendMessage(ChatColor.GREEN + "Vuelo activado");
        }else{
            p.setAllowFlight(false);
            p.sendMessage(ChatColor.RED + "Cuidado que te caes");
        }
    }
}

package me.mariakawaii.comandosadmin.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class comandoSol implements CommandExecutor {
    Random rnd = new Random();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        int tiempo = rnd.nextInt(300,900);
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("adminComamnds.sol")){
                World mundo = Bukkit.getWorlds().get(0);
                mundo.setClearWeatherDuration(tiempo);
            }else {
                p.sendMessage(ChatColor.RED + "Gremlin...");
            }

        }
        return true;
    }
}

package me.mariakawaii.comandosadmin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class comandoCreativo implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.getGameMode() == GameMode.CREATIVE){
                p.sendMessage(ChatColor.RED + "Ya estás en modo creativo");
            }else{
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(ChatColor.GREEN + "Modo de juego cambiado a " + ChatColor.WHITE + "Creativo");
            }
        }
        return true;
    }
}

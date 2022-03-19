package me.mariakawaii.comandosadmin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class comandoEspectador implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.getGameMode() == GameMode.SPECTATOR){
                p.sendMessage(ChatColor.RED + "Ya estás en modo espectador");
            }else{
                p.setGameMode(GameMode.SPECTATOR);
                p.sendMessage(ChatColor.GREEN + "Modo de juego cambiado a " + ChatColor.WHITE + "Espectador");
            }
        }
        return true;
    }
}

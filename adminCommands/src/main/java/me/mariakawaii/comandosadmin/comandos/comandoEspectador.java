package me.mariakawaii.comandosadmin.comandos;

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
            if(p.hasPermission("adminCommands.espectador")){
                if(p.getGameMode() == GameMode.SPECTATOR){
                    p.sendMessage(ChatColor.RED + "Ya estás en modo espectador");
                }else{
                    p.setGameMode(GameMode.SPECTATOR);
                    p.sendMessage(ChatColor.GREEN + "Modo de juego cambiado a " + ChatColor.WHITE + "Espectador");
                }
            }else{
                p.sendMessage(ChatColor.RED + "Un poco Cásper sí que eres");
            }

        }
        return true;
    }
}

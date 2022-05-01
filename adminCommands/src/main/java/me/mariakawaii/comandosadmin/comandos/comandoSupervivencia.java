package me.mariakawaii.comandosadmin.comandos;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class comandoSupervivencia implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("adminCommands.supervivencia")){
                if(p.getGameMode() == GameMode.SURVIVAL){
                    p.sendMessage(ChatColor.RED + "Ya estás en supervivencua");
                }else{
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage(ChatColor.GREEN + "Modo de juego cambiado a " + ChatColor.WHITE + "Supervivencia");
                }
            }else{
                p.sendMessage(ChatColor.RED + "Tu nombre no es Bear Grylls");
            }

        }
        return true;
    }
}

package me.mariakawaii.comandosadmin.comandos;

import me.mariakawaii.comandosadmin.classes.customInventory;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class comandoAdminGUI implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("adminCommands.admingui")){
                customInventory gui = new customInventory();
                p.openInventory(gui.getInventory());
            }else{
                p.sendMessage(ChatColor.RED + "¿Te crees Dios o qué?");
            }

        }
        return true;
    }
}

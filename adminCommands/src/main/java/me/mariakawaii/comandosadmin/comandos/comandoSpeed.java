package me.mariakawaii.comandosadmin.comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class comandoSpeed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("adminCommands.speed")){
                if(args.length == 0){
                    p.sendMessage(ChatColor.AQUA + "Pon un número entre 1 y 10");
                }
                int velocidad = 0;
                try {
                    velocidad = Integer.parseInt(args[0]);
                }catch (NumberFormatException e){
                    p.sendMessage(ChatColor.AQUA + "Pon un número entre 1 y 10");
                    return true;
                }
                float velocidadReal = 0.09f * velocidad + 0.020f;
                if(p.isFlying()){
                    if(p.getFlySpeed() < 1f){
                        p.setFlySpeed(velocidadReal);
                    }else{
                        p.setFlySpeed(velocidadReal);
                    }
                }else{
                    if(p.getWalkSpeed() < 1f){
                        p.setWalkSpeed(velocidadReal);
                    }else{
                        p.setWalkSpeed(velocidadReal);
                    }
                }

                p.sendMessage(ChatColor.AQUA + "Tu velocidad ahora es " + velocidad);
            }else{
                p.sendMessage(ChatColor.RED + "Francesco Virgolini pero sin ruedas");
            }
        }
        return true;
    }
}

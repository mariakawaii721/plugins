package me.mariakawaii.comandosadmin.listeners;

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
            if(args.length == 0){
                p.sendMessage(ChatColor.YELLOW + "Pon un número del 1 al 10");
            }
            int velocidad = 0;
                try {
                    velocidad = Integer.parseInt(args[0]);
                }catch (NumberFormatException e){
                    p.sendMessage(ChatColor.YELLOW + "Pon un número del 1 al 10");
                    return false;
                }
            float velocidadReal = 0.09f * velocidad + 0.06f;
                if(p.isFlying()){
                    if(p.getFlySpeed() < 1f){
                        p.setFlySpeed(velocidadReal);
                        p.sendMessage("vel " + p.getFlySpeed());
                    }else{
                        p.setFlySpeed(velocidadReal);
                        p.sendMessage("vel " + p.getFlySpeed());
                    }
                }else{
                    if(p.getWalkSpeed() < 1f){
                        p.setWalkSpeed(velocidadReal);
                        p.sendMessage("vel " + p.getWalkSpeed());
                    }else{
                        p.setWalkSpeed(velocidadReal);
                        p.sendMessage("vel " + p.getWalkSpeed());
                    }
                }
                if(velocidad < 1 || velocidad > 10){
                    p.sendMessage(ChatColor.YELLOW + "Pon un número del 1 al 10");
                }
                p.sendMessage(ChatColor.YELLOW + "Tu velocidad ahora es " + velocidad);
            }
        return true;
    }
}

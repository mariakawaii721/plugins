package me.mariakawaii.comandosadmin.listeners;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class comandoSpeed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        int velocidad = 0;
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 0){
                p.sendMessage(ChatColor.YELLOW + "Pon un número del 1 al 10");
            }
                try {
                    velocidad = Integer.parseInt(args[0]);
                }catch (NumberFormatException e){
                    p.sendMessage(ChatColor.YELLOW + "Pon un número del 1 al 10");
                    return false;
                }
                if(velocidad < 1 || velocidad > 10){
                    p.sendMessage(ChatColor.YELLOW + "Pon un número del 1 al 10");
                }
                p.sendMessage(ChatColor.YELLOW + "Tu velocidad ahora es " + velocidad);
            }
        return true;
    }

    /*private float conseguirVelocidad(Player p){
        return p.getFlySpeed();

        if(p.isFlying()){
                    p.setFlySpeed((float) velocidad / 10);
                    if(conseguirVelocidad(p) > 1f){
                        p.setFlySpeed(0.2f);
                    }
                }else{
                    p.setWalkSpeed((float) velocidad / 10);
                    if(conseguirVelocidad(p) > 1f){
                        p.setWalkSpeed(0.2f);
                    }
                }
    }*/
}

package me.mariakawaii.comandosadmin.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class onJoinLeaveEvent implements Listener {
        @EventHandler
        public void playerJoin(PlayerJoinEvent e){
            Player p = e.getPlayer();
            if(p.hasPlayedBefore()) {
                e.setJoinMessage(ChatColor.LIGHT_PURPLE + "Ara Ara~ " + e.getPlayer().getDisplayName() );
            }else{
                e.setJoinMessage("¡"+ChatColor.GREEN + "" + ChatColor.BOLD + e.getPlayer().getDisplayName() + " ha entrado " + ChatColor.YELLOW + "" + ChatColor.BOLD + "por primera vez! Flipa");
            }
        }
        @EventHandler
        public void playerLeave(PlayerQuitEvent e){
            Player p = e.getPlayer();
            e.setQuitMessage("Bye " + ChatColor.RED + e.getPlayer().getDisplayName() + " :(");
        }
    }


package me.mariakawaii.comandosadmin.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class chatFormatEvent implements Listener {
    @EventHandler
    public void chatFormat(AsyncPlayerChatEvent e){
        e.getFormat();
        Player p = e.getPlayer();
        e.setFormat(p.getDisplayName() + ": " + e.getMessage());
    }
}

package me.mariakawaii.comandosadmin.events;

import me.mariakawaii.comandosadmin.listeners.comandoVanish;
import me.mariakawaii.comandosadmin.classes.customInventory;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class onClickEventGUI implements Listener {
    @EventHandler
    public void clickEvent(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getClickedInventory().getHolder() instanceof customInventory) {
            e.setCancelled(true);
            switch (e.getCurrentItem().getType()) {
                case DIAMOND:
                    p.setGameMode(GameMode.CREATIVE);
                    break;
                case EMERALD:
                    p.setGameMode(GameMode.SURVIVAL);
                    break;
                case AMETHYST_SHARD:
                    p.setGameMode(GameMode.SPECTATOR);
                    break;
                case IRON_INGOT:
                    p.setGameMode(GameMode.ADVENTURE);
                    break;
                case GLASS:
                    comandoVanish.vanish(p);
                    break;
            }
        }
    }
}
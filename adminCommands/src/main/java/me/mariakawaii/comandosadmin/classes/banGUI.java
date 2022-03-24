package me.mariakawaii.comandosadmin.classes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class banGUI {

    public void abrirGUI(Player p){
        ArrayList<Player> jugadores = new ArrayList<>(p.getServer().getOnlinePlayers());
        Inventory banGUI = Bukkit.createInventory(p,45, "Lista de jugadores");
        for (int i = 0; i < jugadores.size(); i++) {
            ItemStack cabezaJugador = new ItemStack(Material.PLAYER_HEAD,1);
            ItemMeta meta = cabezaJugador.getItemMeta();
            meta.setDisplayName(jugadores.get(i).getDisplayName());
            cabezaJugador.setItemMeta(meta);

            banGUI.addItem(cabezaJugador);
        }
        p.openInventory(banGUI);
    }
}

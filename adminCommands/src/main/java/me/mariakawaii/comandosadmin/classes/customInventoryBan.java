package me.mariakawaii.comandosadmin.classes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;
import java.util.List;

public class customInventoryBan implements InventoryHolder {

    private final Inventory inv;

    public customInventoryBan(){
        inv = Bukkit.createInventory(this,9, ChatColor.DARK_RED + "Panel admin");
        ban();
    }

    private void ban(){
        ItemStack item;

        item = customItem("Banear",Material.IRON_AXE,Collections.singletonList("§fBanear jugador"));
        inv.setItem(inv.firstEmpty(),item);
        item = customItem("Jugador",Material.PLAYER_HEAD,Collections.singletonList("§fCambia tu modo de juego a supervivencia"));
        inv.setItem(inv.firstEmpty(),item);
        item = customItem("Espectador",Material.AMETHYST_SHARD,Collections.singletonList("§fCambia tu modo de juego a espectador"));
        inv.setItem(inv.firstEmpty(),item);

    }

    private ItemStack customItem(String nombre, Material material, List<String> lore){
        ItemStack item = new ItemStack(material,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§b"+nombre);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public Inventory getInventory(){
        return inv;
    }
}

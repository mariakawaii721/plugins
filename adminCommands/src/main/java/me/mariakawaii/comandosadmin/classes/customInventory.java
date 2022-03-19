package me.mariakawaii.comandosadmin.classes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.Collections;
import java.util.List;

public class customInventory implements InventoryHolder {

    private Inventory inv;

    public customInventory(){
        inv = Bukkit.createInventory(this,54, ChatColor.DARK_RED + "Panel admin");
        init();
    }

    private void init(){
        ItemStack item;
        for (int i = 0; i < 11; i++) {
            item = customItem("",Material.BLACK_STAINED_GLASS_PANE, Collections.singletonList(""));
            inv.setItem(i,item);
        }
        item = customItem("Creativo",Material.DIAMOND,Collections.singletonList("§fCambia tu modo de juego a creativo"));
        inv.setItem(inv.firstEmpty(),item);
        item = customItem("Survival",Material.EMERALD,Collections.singletonList("§fCambia tu modo de juego a supervivencia"));
        inv.setItem(inv.firstEmpty(),item);
        item = customItem("Espectador",Material.AMETHYST_SHARD,Collections.singletonList("§fCambia tu modo de juego a espectador"));
        inv.setItem(inv.firstEmpty(),item);
        item = customItem("Aventura",Material.IRON_INGOT,Collections.singletonList("§fCambia tu modo de juego a aventura"));
        inv.setItem(inv.firstEmpty(),item);
        item = customItem("Vanish",Material.GLASS,Collections.singletonList("§fTe vuelve invisible para el resto de jugadores"));
        inv.setItem(inv.firstEmpty(),item);
        for (int i = 16; i < 54; i++) {
            item = customItem("",Material.BLACK_STAINED_GLASS_PANE, Collections.singletonList(""));
            inv.setItem(i,item);
        }
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

package me.mariakawaii.comandosadmin.events;

import me.mariakawaii.comandosadmin.classes.banGUI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class banEvent implements Listener {

    banGUI plugin;

    public banEvent(banGUI plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClickMenu(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();
        Inventory banJugadorGUI = Bukkit.createInventory(p,9,"Confirmar ban");
        ItemStack is = e.getCurrentItem();
        if(is.getType().equals(Material.PLAYER_HEAD) && e.getCurrentItem().getType() == Material.PLAYER_HEAD){
            p.sendMessage("asdasddasdasdasdasd");
            Player aBanear = p.getServer().getPlayer(e.getCurrentItem().getItemMeta().getDisplayName());
            p.openInventory(prueba(p,aBanear));
        }
    }

    public Inventory prueba(Player p, Player aBanear){
        Inventory asd = Bukkit.createInventory(p,9,"Confirmar ban");

        ItemStack ban = new ItemStack(Material.IRON_AXE,1);
        ItemMeta banMeta = ban.getItemMeta();
        banMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Banear");
        ban.setItemMeta(banMeta);
        asd.setItem(0,ban);

        ItemStack cabeza = new ItemStack(Material.PLAYER_HEAD,1);
        ItemMeta cabezaMeta = cabeza.getItemMeta();
        cabezaMeta.setDisplayName(aBanear.getDisplayName());
        cabeza.setItemMeta(cabezaMeta);
        asd.setItem(4,cabeza);

        ItemStack volver = new ItemStack(Material.BARRIER,1);
        ItemMeta volverMeta = volver.getItemMeta();
        volverMeta.setDisplayName(ChatColor.RED + "Volver");
        volver.setItemMeta(volverMeta);
        asd.setItem(8,volver);
        return asd;
    }


}

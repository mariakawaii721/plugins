package me.mariakawaii.comandosadmin.events;

import me.mariakawaii.comandosadmin.comandos.comandoBanGUI;
import org.bukkit.BanList;
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

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class banEvent implements Listener {

    @EventHandler
    public void onClickMenu(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        Inventory banJugadorGUI = Bukkit.createInventory(p,9,ChatColor.RED + "Confirmar ban");
        ItemStack is = e.getCurrentItem();
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        if (is != null && is.getType().equals(Material.PLAYER_HEAD) && e.getCurrentItem().getType() == Material.PLAYER_HEAD) {
            Player aBanear = p.getServer().getPlayer(e.getCurrentItem().getItemMeta().getDisplayName());
            assert aBanear != null;
            p.openInventory(razonBan(p, aBanear));
            e.setCancelled(true);

        }else if(e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Razón")){
            try {
                Player aBanear = p.getServer().getPlayer(e.getCurrentItem().getItemMeta().getLocalizedName());
                if (is != null && e.getCurrentItem().getType() == Material.BARRIER) {
                    comandoBanGUI.abrirGUI(p);
                } else if (is != null && e.getCurrentItem().getType() == Material.TNT) {
                    p.openInventory(confirmarBAN(p, aBanear));
                    e.setCancelled(true);
                } else if (is != null && e.getCurrentItem().getType() == Material.STONE_SWORD) {
                    p.openInventory(confirmarBAN(p, aBanear));
                    e.setCancelled(true);
                } else if (is != null && e.getCurrentItem().getType() == Material.PUFFERFISH) {
                    p.openInventory(confirmarBAN(p, aBanear));
                    e.setCancelled(true);
                }
            }catch (NullPointerException npe){
                npe.getMessage();
            }
        }else if(e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Banear")){
            try {
                String nombre = e.getClickedInventory().getItem(0).getItemMeta().getDisplayName();
                if (is != null && e.getCurrentItem().getType() == Material.WOODEN_SWORD) {
                    c.add(Calendar.DATE, 7);
                    Date currentDatePlusOne = c.getTime();
                    p.openInventory(banJugadorGUI);
                    p.getServer().getBanList(BanList.Type.NAME).addBan(nombre, "Uso de cliente no perimtido", currentDatePlusOne, e.getClickedInventory().getItem(0).getItemMeta().getDisplayName());
                    p.kickPlayer("Baneado");
                    e.setCancelled(true);
                } else if (is != null && e.getCurrentItem().getType() == Material.IRON_SWORD) {
                    c.add(Calendar.MONTH, 1);
                    Date currentDatePlusOne = c.getTime();
                    p.openInventory(banJugadorGUI);
                    p.getServer().getBanList(BanList.Type.NAME).addBan(nombre, "Uso de cliente no perimtido", currentDatePlusOne, e.getClickedInventory().getItem(0).getItemMeta().getDisplayName());
                    p.kickPlayer("Baneado");
                    e.setCancelled(true);
                } else if (is != null && e.getCurrentItem().getType() == Material.DIAMOND_SWORD) {
                    p.openInventory(banJugadorGUI);
                    p.getServer().getBanList(BanList.Type.NAME).addBan(nombre, "Uso de cliente no perimtido", null, e.getClickedInventory().getItem(0).getItemMeta().getDisplayName());
                    p.kickPlayer("Baneado");
                    e.setCancelled(true);
                }
                if (Objects.requireNonNull(e.getCurrentItem()).getType() == Material.BARRIER) {
                    Player aBanear = p.getServer().getPlayer(Objects.requireNonNull(e.getCurrentItem().getItemMeta()).getLocalizedName());
                    p.openInventory(razonBan(p, aBanear));
                }
            }catch (NullPointerException npe){
                npe.getMessage();
            }
        }
    }

    private Inventory confirmarBAN(Player p, Player aBanear){
        Inventory inventarioBAN = Bukkit.createInventory(p,27,ChatColor.RED + "Banear");

        ItemStack cabeza = new ItemStack(Material.PLAYER_HEAD,1);
        ItemMeta cabezaMeta = cabeza.getItemMeta();
        cabezaMeta.setDisplayName(aBanear.getDisplayName());
        cabeza.setItemMeta(cabezaMeta);
        inventarioBAN.setItem(0,cabeza);

        ItemStack banCliente7 = new ItemStack(Material.WOODEN_SWORD,1);
        ItemMeta banMeta = banCliente7.getItemMeta();
        banMeta.setDisplayName(ChatColor.DARK_RED + "Banear (7d)");
        banCliente7.setItemMeta(banMeta);
        inventarioBAN.setItem(11,banCliente7);

        ItemStack banCliente30 = new ItemStack(Material.IRON_SWORD,1);
        ItemMeta banMeta2 = banCliente30.getItemMeta();
        banMeta.setDisplayName(ChatColor.DARK_RED + "Banear (30d)");
        banCliente30.setItemMeta(banMeta);
        inventarioBAN.setItem(13,banCliente30);

        ItemStack banClientePerma = new ItemStack(Material.DIAMOND_SWORD,1);
        ItemMeta banMeta3 = banClientePerma.getItemMeta();
        banMeta.setDisplayName(ChatColor.DARK_RED + "Banear (PERMANENTE)");
        banClientePerma.setItemMeta(banMeta);
        inventarioBAN.setItem(15,banClientePerma);

        ItemStack volver = new ItemStack(Material.BARRIER,1);
        ItemMeta volverMeta = volver.getItemMeta();
        volverMeta.setDisplayName(ChatColor.RED + "Volver");
        volver.setItemMeta(volverMeta);
        inventarioBAN.setItem(26,volver);
        return inventarioBAN;
    }

    private Inventory razonBan(Player p, Player aBanear){
        Inventory iventarioRazon = Bukkit.createInventory(p,27,ChatColor.RED + "Razón");

        ItemStack cabeza = new ItemStack(Material.PLAYER_HEAD,1);
        ItemMeta cabezaMeta = cabeza.getItemMeta();
        cabezaMeta.setDisplayName(aBanear.getDisplayName());
        cabeza.setItemMeta(cabezaMeta);
        iventarioRazon.setItem(0,cabeza);

        ItemStack razonGrifeo = new ItemStack(Material.TNT,1);
        ItemMeta metaGrifeo = razonGrifeo.getItemMeta();
        metaGrifeo.setDisplayName(ChatColor.WHITE + "Grifeo");
        razonGrifeo.setItemMeta(metaGrifeo);
        iventarioRazon.setItem(11,razonGrifeo);

        ItemStack razonHacks = new ItemStack(Material.STONE_SWORD,1);
        ItemMeta metaHacks = razonHacks.getItemMeta();
        metaHacks.setDisplayName(ChatColor.WHITE + "Hacks");
        razonHacks.setItemMeta(metaHacks);
        iventarioRazon.setItem(13,razonHacks);

        ItemStack razonOfensivo = new ItemStack(Material.PUFFERFISH,1);
        ItemMeta metaOfensivo = razonOfensivo.getItemMeta();
        metaOfensivo.setDisplayName(ChatColor.WHITE + "Ofensivo");
        razonOfensivo.setItemMeta(metaOfensivo);
        iventarioRazon.setItem(15,razonOfensivo);

        ItemStack volver = new ItemStack(Material.BARRIER,1);
        ItemMeta volverMeta = volver.getItemMeta();
        volverMeta.setDisplayName(ChatColor.RED + "Volver");
        volver.setItemMeta(volverMeta);
        iventarioRazon.setItem(26,volver);
        return iventarioRazon;
    }
}

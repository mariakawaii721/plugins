package me.mariakawaii.comandosadmin.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class comandoBanGUI implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("adminCommands.bangui")){
                abrirGUI(p);
            }else{
                p.sendMessage(ChatColor.RED + "Va a ser que no amigo =D");
            }

        }
        return true;
    }
    public static void abrirGUI(Player p){
        ArrayList<Player> jugadores = new ArrayList<>(p.getServer().getOnlinePlayers());
        Inventory banGUI = Bukkit.createInventory(p,54, "Lista de jugadores");
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

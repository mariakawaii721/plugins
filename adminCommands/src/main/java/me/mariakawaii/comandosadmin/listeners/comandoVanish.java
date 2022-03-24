package me.mariakawaii.comandosadmin.listeners;

import me.mariakawaii.comandosadmin.ComandosAdmin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class comandoVanish implements CommandExecutor {

    static ComandosAdmin plugin;

    public comandoVanish(ComandosAdmin plugin) {
        comandoVanish.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            vanish(p);
        }
        return true;
    }

    public static void vanish(Player p) {
        if (plugin.jugadoresInvisibles.contains(p)) {
            for (Player personas : Bukkit.getOnlinePlayers()) {
                personas.showPlayer(plugin, p);
            }
            plugin.jugadoresInvisibles.remove(p);
            p.sendMessage(ChatColor.RED + "Ahora eres visible para todo el mundo");
        } else if (!plugin.jugadoresInvisibles.contains(p)) {
            for (Player personas : Bukkit.getOnlinePlayers()) {
                personas.hidePlayer(plugin, p);
            }
            plugin.jugadoresInvisibles.add(p);
            p.sendMessage(ChatColor.GREEN + "Ahora eres invisible para todo el mundo");
        }
    }
}


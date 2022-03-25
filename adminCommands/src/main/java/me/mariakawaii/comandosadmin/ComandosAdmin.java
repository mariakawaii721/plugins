package me.mariakawaii.comandosadmin;

import me.mariakawaii.comandosadmin.events.onClickEventGUI;
import me.mariakawaii.comandosadmin.listeners.*;
import me.mariakawaii.comandosadmin.events.banEvent;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class ComandosAdmin extends JavaPlugin {

    public static final String reset = "\u001B[0m";
    public static final String verde = "\u001B[32m";
    public static final String azul = "\u001B[34m";
    public ArrayList<Player> jugadoresInvisibles = new ArrayList<>();

    @Override
    public void onEnable() {
        System.out.println(azul + "Plugin ComandosAdmin se ha iniciado " + verde + "CORRECTAMENTE" + reset);

        //EVENTOS
        getServer().getPluginManager().registerEvents(new onClickEventGUI(),this);
        getServer().getPluginManager().registerEvents(new banEvent(),this);
        //COMANDOS
        getCommand("creativo").setExecutor(new comandoCreativo());
        getCommand("espectador").setExecutor(new comandoEspectador());
        getCommand("aventura").setExecutor(new comandoAventura());
        getCommand("supervivencia").setExecutor(new comandoSupervivencia());
        getCommand("vanish").setExecutor(new comandoVanish(this));
        getCommand("vuelo").setExecutor(new comandoFly());
        getCommand("velocidad").setExecutor(new comandoSpeed());
        getCommand("gui").setExecutor(new comandoAdminGUI());
        getCommand("bangui").setExecutor(new comandoBanGUI());

    }


}

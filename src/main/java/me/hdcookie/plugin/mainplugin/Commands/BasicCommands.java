package me.hdcookie.plugin.mainplugin.Commands;

import me.hdcookie.plugin.mainplugin.MainPlugin;
import me.hdcookie.plugin.mainplugin.Utilities.Messages;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerCommandSendEvent;

public class BasicCommands implements Listener {
    private Messages messages;

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event){
        Player player = event.getPlayer();
        messages = new Messages();

        switch (event.getMessage()){
            case "/sun" : {
                event.setCancelled(true);
               player.sendMessage(ChatColor.translateAlternateColorCodes('&', MainPlugin.getMainInstance().getMessagefile().getString("basicCommands.sun")));
                event.getPlayer().getWorld().setStorm(false);
            } break;
            case "/rain" :{
                event.setCancelled(true);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', MainPlugin.getMainInstance().getMessagefile().getString("basicCommands.rain")));
                event.getPlayer().getWorld().setStorm(true);

            } case "/day" : {
                event.setCancelled(true);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', MainPlugin.getMainInstance().getMessagefile().getString("basicCommands.day")));
                event.getPlayer().getWorld().setTime(6000);
            }break;
            case "/night" : {
                event.setCancelled(true);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', MainPlugin.getMainInstance().getMessagefile().getString("basicCommands.night")));
                event.getPlayer().getWorld().setStorm(true);
            }

        }
    }
}

package me.hdcookie.plugin.mainplugin.Stuff;

import me.hdcookie.plugin.mainplugin.MainPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SpawnHub implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        FileConfiguration config = MainPlugin.getMainInstance().getConfig();
        String helper = "spawn-location.";

        Location spawnLocation = new Location(Bukkit.getWorld(config.getString("spawn-location.world")),
                config.getDouble(helper+"x"),
                config.getDouble(helper+"y"),
                config.getDouble(helper+"z"),
                config.getInt(helper+"yaw"),
                config.getInt(helper+"pitch"));
        event.getPlayer().teleport(spawnLocation);
    }
}

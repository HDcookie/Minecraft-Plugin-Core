package me.hdcookie.plugin.mainplugin.Stuff;

import me.hdcookie.plugin.mainplugin.MainPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.PortalCreateEvent;

public class Nether implements Listener {
    @EventHandler
    public void onPortalCreate(PortalCreateEvent event){
        if(MainPlugin.getMainInstance().getConfig().getBoolean("disable-nether")){
            if(event.getWorld().getName().equals("Factions")){
                event.setCancelled(true);
                event.getEntity().sendMessage("HaHa... not today");
            }
        }
    }
}

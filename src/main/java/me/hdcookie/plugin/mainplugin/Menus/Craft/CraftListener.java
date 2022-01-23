package me.hdcookie.plugin.mainplugin.Menus.Craft;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CraftListener implements Listener {
    @EventHandler
    public void event(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        player.sendMessage(event.getClickedInventory().toString());


        if(event.getInventory() == player.getOpenInventory().getTopInventory().getItem(1)){
            event.setCancelled(true);
        }else if(event.getInventory() == player.getOpenInventory().getTopInventory().getItem(2)){
            event.setCancelled(true);
        }

    }
}

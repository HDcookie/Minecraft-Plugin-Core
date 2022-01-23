package me.hdcookie.plugin.mainplugin.Items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class ItemListeners implements Listener {
    @EventHandler
    public void craftingTableListener(PlayerInteractEvent event){
        if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            //event is right click
            if(event.getItem().getItemMeta().getLore().contains("11111")){

                event.setCancelled(true);

                Inventory inv = Bukkit.createInventory(event.getPlayer(), InventoryType.WORKBENCH);
                event.getPlayer().openInventory(inv);
            }
        }
    }

    @EventHandler
    public void healWandListener(PlayerInteractEvent event){
        if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            //event is right click
            if(event.getItem().getItemMeta().getLore().contains("11110")){
                event.setCancelled(true);

                event.getPlayer().setHealth(event.getPlayer().getHealthScale());
                if(event.getItem().getAmount() == 1) {
                    event.getPlayer().getInventory().remove(event.getItem());
                }else event.getItem().setAmount(event.getItem().getAmount() - 1);
            }
        }
    }


}

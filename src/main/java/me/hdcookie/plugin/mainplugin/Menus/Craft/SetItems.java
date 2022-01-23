package me.hdcookie.plugin.mainplugin.Menus.Craft;

import me.hdcookie.plugin.mainplugin.MainPlugin;
import me.hdcookie.plugin.mainplugin.Utilities.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class SetItems implements Listener {
    ItemStack craftTable = new ItemBuilder(Material.CRAFTING_TABLE)
            .setName(ChatColor.GOLD+"Crafting"+ ChatColor.DARK_GRAY+" Table")
            .setLore(ChatColor.GRAY+"Click to open", ChatColor.GRAY+"A virtual  Crafting Table").toItemStack();

    ItemStack cmd1 = new ItemBuilder(Material.RED_BANNER).setName("Cmd1").setLore("remv").toItemStack();
    ItemStack cmd2 = new ItemBuilder(Material.RED_BANNER).setName("Cmd2").setLore("remv").toItemStack();
    ItemStack cmd3 = new ItemBuilder(Material.RED_BANNER).setName("Cmd3").setLore("remv").toItemStack();


    @EventHandler
    public void event(PlayerMoveEvent event){
        setItems(event.getPlayer());
        removeItems((Player) event.getPlayer());
    }
    @EventHandler
    public void event1(PlayerJoinEvent event){
        setItems(event.getPlayer());
        removeItems((Player) event.getPlayer());
    }
    @EventHandler
    public void event3(PlayerInteractEvent event){
        setItems(event.getPlayer());

        removeItems((Player) event.getPlayer());
    }
    @EventHandler
    public void event4(InventoryCloseEvent event){
       removeItems((Player) event.getPlayer());
    }
    public void setItems(Player player){

        //Creating ItemStacks


        player.getOpenInventory().getTopInventory().setItem(1 , craftTable);
        player.getOpenInventory().getTopInventory().setItem(2 , cmd1);
        player.getOpenInventory().getTopInventory().setItem(3 , cmd2);
        player.getOpenInventory().getTopInventory().setItem(4 , cmd3);

    }
    public void removeItems(Player player){



        Bukkit.getScheduler().runTaskLater(MainPlugin.getMainInstance(), () -> {
            if(player.getInventory().contains(cmd1)){
                player.getInventory().remove(cmd1);
            }
            if(player.getInventory().contains(cmd2)){
                player.getInventory().remove(cmd2);
            }
            if(player.getInventory().contains(cmd3)){
                player.getInventory().remove(cmd3);
            }
            if(player.getInventory().contains(craftTable)){
                player.getInventory().remove(craftTable);
            }
        }, 1);
    }
}

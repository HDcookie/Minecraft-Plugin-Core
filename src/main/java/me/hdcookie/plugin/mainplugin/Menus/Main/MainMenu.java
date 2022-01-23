package me.hdcookie.plugin.mainplugin.Menus.Main;

import me.hdcookie.plugin.mainplugin.Utilities.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MainMenu implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player)sender;
            Inventory inventory = Bukkit.createInventory(player, 18, "Player Menu");

            //Creating Item stacks
            ItemStack back = new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE)
                    .setName(" ").toItemStack();
            ItemStack pw = new ItemBuilder(Material.ENDER_PEARL)
                    .setName(ChatColor.BLUE+"Player"+ChatColor.DARK_BLUE+"Warps")
                    .setLore(ChatColor.GRAY+"Click to open player warps").toItemStack();



            //Adding them to menu
            //PlayerWarps
            inventory.setItem(1, pw);

            //bACKGROUND
            for(int i = 0; i < inventory.getSize(); i++){
                if(inventory.getItem(i) == null || inventory.getItem(i).getType() == Material.AIR){
                    inventory.setItem(i, back);}}

            player.openInventory(inventory);
        }


        return false;
    }
}

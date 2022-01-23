package me.hdcookie.plugin.mainplugin.Items;

import me.hdcookie.plugin.mainplugin.Utilities.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

public class Basics {

    public ItemStack getHealthWand(int amount){
        ItemStack healthWand = new ItemBuilder(Material.RED_BANNER, amount)
                .setName(ChatColor.RED+ "Healing " + ChatColor.DARK_RED + " Wand")
                .addEnchant(Enchantment.DURABILITY, 1)
                .setLore(ChatColor.DARK_GRAY + "This item will heal you to your full health.", ChatColor.DARK_GRAY+"Right Click to use", "11110")
                .toItemStack();
        return healthWand;
    }
    public ItemStack getCraftingTable(int amount){
        ItemStack craftingTable = new ItemBuilder(Material.CRAFTING_TABLE, amount)
                .setName(ChatColor.GOLD + "Crafting"+ ChatColor.YELLOW + "Table")
                .addEnchant(Enchantment.DURABILITY, 1)
                .setLore(ChatColor.DARK_GRAY+"Portable Crafting table.  ", "11111")
                .toItemStack();
        return craftingTable;
    }
}

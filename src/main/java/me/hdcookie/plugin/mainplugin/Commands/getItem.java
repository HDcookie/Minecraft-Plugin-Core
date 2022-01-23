package me.hdcookie.plugin.mainplugin.Commands;


import me.hdcookie.plugin.mainplugin.Items.Basics;
import me.hdcookie.plugin.mainplugin.MainPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class getItem implements CommandExecutor {
    private Basics basics;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        basics = new Basics();
        YamlConfiguration messages = MainPlugin.getMainInstance().getMessagefile();

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("MainPlugin.getItem")) {
                if (args.length == 1) {
                    switch (args[0]) {
                        case "healWand": {
                            player.getInventory().addItem(basics.getHealthWand(1));
                            player.sendMessage(messages.getString("commands.getItem.items.healWand"));
                        }break;
                        case "craftingTable": {
                            player.getInventory().addItem(basics.getCraftingTable(1));
                            player.sendMessage(messages.getString("commands.getItem.items.craftingTable"));
                        } break;
                        default: {
                            player.sendMessage(messages.getString("commands.getItem.itemNotFound"));
                        }

                    }
                }
            }
        }
        return false;
    }
}

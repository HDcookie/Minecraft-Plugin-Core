package me.hdcookie.plugin.mainplugin.Commands;

import me.hdcookie.plugin.mainplugin.MainPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class HubCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            FileConfiguration config = MainPlugin.getMainInstance().getConfig();
            String helper = "hub-location.";//So I dont have to retype it


            Location hubLocation = new Location(Bukkit.getWorld(config.getString("hub-location.world")),
                    config.getDouble(helper+"x"),
                    config.getDouble(helper+"y"),
                    config.getDouble(helper+"z"),
                    config.getInt(helper+"yaw"),
                    config.getInt(helper+"pitch"));

            player.teleport(hubLocation);


        }
        return false;
    }
}

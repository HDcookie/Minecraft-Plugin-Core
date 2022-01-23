package me.hdcookie.plugin.mainplugin.Utilities;

import me.hdcookie.plugin.mainplugin.MainPlugin;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Messages {

    public YamlConfiguration finalFile;

    public void initiateMessages(String name){
        File file = new File(MainPlugin.getMainInstance().getDataFolder(), "messages.yml");
        MainPlugin.getMainInstance().saveResource("messages.yml", true);//EDIT LATER!!!!!!!!!


        finalFile = YamlConfiguration.loadConfiguration(file);

        Bukkit.getConsoleSender().sendMessage(finalFile.getString("testMessage"));
    }

    public YamlConfiguration getFinalFile(){
        return finalFile;
    }
}

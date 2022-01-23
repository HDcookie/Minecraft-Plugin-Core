package me.hdcookie.plugin.mainplugin;

import me.hdcookie.plugin.mainplugin.Commands.BasicCommands;
import me.hdcookie.plugin.mainplugin.Commands.getItem;
import me.hdcookie.plugin.mainplugin.Items.ItemListeners;
import me.hdcookie.plugin.mainplugin.Menus.Main.MainMenu;
import me.hdcookie.plugin.mainplugin.Stuff.Nether;
import me.hdcookie.plugin.mainplugin.Utilities.Messages;
import me.hdcookie.plugin.mainplugin.Utilities.Sql;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;
import java.sql.SQLException;
import java.sql.Struct;

public final class MainPlugin extends JavaPlugin {
    private static MainPlugin mainInstance;
    private Sql sql;
    private Messages messages;

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "HDCOOKIE'S PLUGIN IS ENABLED \n IF YOU SEE THIS UR A NERD UNLESS UR NAME IS HDCOOKIE");
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        mainInstance = this;
        messages = new Messages();
        messages.initiateMessages("messages");

        saveResource("config.yml", true);


        //Adding Commands and Event stuff
        getCommand("menu").setExecutor(new MainMenu());//Main Menu?
        //getCommand("cban").setExecutor(new CBan());
        getCommand("getItem").setExecutor(new getItem()); //Basic items
        Bukkit.getPluginManager().registerEvents(new ItemListeners(), this);

        //Main Commands.
        Bukkit.getPluginManager().registerEvents(new BasicCommands(), this);
        //Disables portals, configurable
        Bukkit.getPluginManager().registerEvents(new Nether(), this);// Disable portals


        //JDa:
        if (getConfig().getBoolean("Discordbot.enabled")) {
            try {
                System.out.println(getConfig().getString("Discordbot.token"));
                JDA jda = JDABuilder.createDefault(getConfig().getString("Discordbot.token")).build();

                jda.getPresence().setActivity(Activity.playing(getConfig().getString("Discordbot.status")));
                System.out.println("should have worked");

            } catch (LoginException e) {
                e.printStackTrace();
            }


            //Sql
//        sql = new Sql();
//        try {
//            sql.connect();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        if(sql.isConnected()){
//            Bukkit.getConsoleSender().sendMessage("Connected to SQL Suscessfully... idk how to spell");
//        }


            //Bukkit.getPluginManager().registerEvents(new SetItems(), this);//Sets the items to the crafting grid
            //Bukkit.getPluginManager().registerEvents(new CraftListener(), this);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        //sql.disconnect();
    }
    public static MainPlugin getMainInstance(){
        return mainInstance;
    }

    public YamlConfiguration getMessagefile(){
        return messages.getFinalFile();
    }
}

package me.hdcookie.plugin.mainplugin.Commands;

import me.hdcookie.plugin.mainplugin.Utilities.Sql;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CBan implements CommandExecutor {

    private Sql sql;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sql = new Sql();

        if(args.length == 2) {
            String bannedPlayer = args[0];




            try {
                PreparedStatement ps = sql.getConnection().prepareStatement("INSERT INTO test (UUID, Reason, TimeBanned, BanExpires) VALUES (?, ?, ?);");
                ps.setString(1, "");
                ps.setString(2, "");
                ps.setString(3, "");
                ps.setString(4, "");


            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }
}

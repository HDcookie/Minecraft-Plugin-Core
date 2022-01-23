package me.hdcookie.plugin.mainplugin.Utilities;

import me.hdcookie.plugin.mainplugin.MainPlugin;
import org.bukkit.configuration.file.FileConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sql {

    private FileConfiguration config = MainPlugin.getMainInstance().getConfig();

    private final String HOST = config.getString("sql.host");
    private final int PORT = config.getInt("sql.port");
    private final String DATABASE = config.getString("sql.database");
    private final String USERNAME = config.getString("sql.username");
    private final String PASSWORD = config.getString("sql.password");

    private Connection connection;


    public void connect() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?useSSL=false",
                USERNAME, PASSWORD);


    }

    public boolean isConnected(){
        return connection != null;
    }

    public Connection getConnection(){
        return  connection;
    }

    public void disconnect() {
        if(isConnected()) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

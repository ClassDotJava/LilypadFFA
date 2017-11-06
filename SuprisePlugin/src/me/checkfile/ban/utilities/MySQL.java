package me.checkfile.ban.utilities;

import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySQL {


    private Connection connection;


    public MySQL(String ip, String userName, String password, String database) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + ip + "/" + database + "?user=" + userName + "&password=" + password);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getReason(Player p) {
        try {
            PreparedStatement statement = connection.prepareStatement("select reason from users where uuid" + p.getUniqueId() + " ");
            ResultSet result = statement.executeQuery();

            if(result.next()) {
                return result.getString("reason");
            }else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "[Failed to connect]";
        }


    }
    public void ban(Player player, String reason) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into users (udid, reason)\nvalues ('" + player.getUniqueId() + "', '" + reason + "');");
            statement.executeUpdate();
            statement.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}


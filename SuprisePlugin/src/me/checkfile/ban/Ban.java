package me.checkfile.ban;

import me.checkfile.ban.command.BanCommand;
import me.checkfile.ban.listener.onJoin;
import me.checkfile.ban.utilities.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;

public class Ban extends JavaPlugin{

    private MySQL mysql;
    private String host, database, username, password;
    public int port;
    public static String prefix = "§c[Ban] ";


    public void onEnable(){
        mysql = new MySQL("localhost", "root", "your_password", "bans");
        System.out.println("Ban enabled");            getCommand("ban").setExecutor(new BanCommand());
        Bukkit.getPluginManager().registerEvents(new onJoin(), this);

    }
    public void onDisable(){
        System.out.println("Ban enabled");
    }






}

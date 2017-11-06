package me.checkfile.ban.listener;

import me.checkfile.ban.utilities.MySQL;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class onJoin implements Listener{

    private MySQL mySQL;

    public void onJoin(PlayerLoginEvent event){
        String reason = mySQL.getReason(event.getPlayer());
        event.disallow(PlayerLoginEvent.Result.KICK_BANNED , reason);
    }
}

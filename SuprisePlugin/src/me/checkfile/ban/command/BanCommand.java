package me.checkfile.ban.command;

import me.checkfile.ban.Ban;
import me.checkfile.ban.utilities.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanCommand implements CommandExecutor{

    private MySQL mySQL;
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(command.getName().equalsIgnoreCase("ban")) {
            if(strings.length < 2) {
                commandSender.sendMessage(Ban.prefix + ChatColor.RED + ChatColor.BOLD + "Please state the name and the reason.");
            }
// ????z.z
            Player player = Bukkit.getServer().getPlayer(strings[0]);

            if(player == null) {
                commandSender.sendMessage(Ban.prefix + ChatColor.RED + ChatColor.BOLD + "That player is not online.");
                return true;
            }

            StringBuilder reason = new StringBuilder();
            for(int i = 1; i < strings.length; i++) {
                reason.append(strings[i]).append(" ");
            }
        }

        return true;
    }
}

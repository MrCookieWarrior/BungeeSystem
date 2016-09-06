package de.MrCookieWarrior.ProxyManager.Commands;

import de.MrCookieWarrior.ProxyManager.Manager.ConfigManager;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * @author Benjamin
 */
public class Hub extends Command {
    public Hub() {
    super("hub");
   }
   
    public void execute(CommandSender sender, String[] strings) {
    if ((sender instanceof ProxiedPlayer)) {
    ProxiedPlayer player = (ProxiedPlayer)sender;
    if (!player.getServer().getInfo().getName().equalsIgnoreCase(ConfigManager.getHub())) {
        ServerInfo target = ProxyServer.getInstance().getServerInfo(ConfigManager.getHub());
         player.connect(target);
    } else {
       player.sendMessage(ConfigManager.getPrefix() + "§cDu bist schon in einer Lobby.");
    }
} else {
    sender.sendMessage(new ComponentBuilder("... not here...").color(ChatColor.RED).create());
    }
  }
}
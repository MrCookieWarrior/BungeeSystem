/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.MrCookieWarrior.ProxyManager.Commands;

import de.MrCookieWarrior.ProxyManager.Manager.ConfigManager;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 *
 * @author Benjamin
 */
public class Maintenance extends Command {
    public Maintenance() {
    super("wartung", "wartung.wartung", new String[0]);
}
   
   public void execute(CommandSender sender, String[] strings) {
    if (strings.length != 1) {
    return;
    }
    if (strings[0].equalsIgnoreCase("on"))
{
    ConfigManager.set("MaintenaceManager.Status", Boolean.valueOf(true));
    sender.sendMessage(ConfigManager.getPrefix() + "Wartungsmodus ist angeschaltet.");
    for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
    if ((!p.hasPermission("wartung.join")) && (!p.hasPermission("proxymanager.admin"))) {
    p.disconnect("§f§oDu wurdest gekickt! \n §eGrund§f: " + ConfigManager.getMaintenanceMotd() + "\n §e§lWenn das ein Fehler ist, melde dich im Teamspeak.");
    }
    }
} else if (strings[0].equalsIgnoreCase("off")) {
   ConfigManager.set("MaintenaceManager.Status", Boolean.valueOf(false));
   sender.sendMessage(ConfigManager.getPrefix() + "Wartungsmodus ist ausgeschaltet.");
}
}
}
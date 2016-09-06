/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.MrCookieWarrior.ProxyManager.Commands;

import de.MrCookieWarrior.ProxyManager.Manager.ConfigManager;
import de.MrCookieWarrior.ProxyManager.Manager.KickManager;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

/**
 *
 * @author Benjamin
 */
public class Kick extends Command {
    public Kick() {
    super("k", "proxymanager.kick", new String[0]);
}
   
   public void execute(CommandSender sender, String[] args)
   {
    if (args.length == 0)
{
    sender.sendMessage(ConfigManager.getPrefix() + "§cDu musst einen Spieler angeben, und dazu einen Grund, warum du ihn gekickt hast.");
    return;
    }
    if (args.length == 2)
     {
    String target = args[0];
    String reason = args[1];
       
    KickManager.kickPlayer(sender, target, reason);
}
    }
}
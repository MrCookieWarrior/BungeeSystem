/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.MrCookieWarrior.ProxyManager.Commands;

import de.MrCookieWarrior.ProxyManager.Manager.ConfigManager;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.event.ProxyReloadEvent;
import net.md_5.bungee.api.plugin.Command;

/**
 *
 * @author Benjamin
*/
public class Reload extends Command {
   public Reload() {
   super("dcReload", "proxymanager.admin", new String[0]);
   }
  
    public void execute(CommandSender sender, String[] strings) {
    BungeeCord.getInstance().config.load();
    BungeeCord.getInstance().stopListeners();
    BungeeCord.getInstance().startListeners();
    ConfigManager.reloadConfiguration(true);
    BungeeCord.getInstance().getPluginManager().callEvent(new ProxyReloadEvent(sender));
    sender.sendMessage(ConfigManager.getPrefix() + "§aBungeeCord wurde reloaded.");
   }
}
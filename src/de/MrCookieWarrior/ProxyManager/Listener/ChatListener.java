/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.MrCookieWarrior.ProxyManager.Listener;

import de.MrCookieWarrior.ProxyManager.Manager.ConfigManager;
import java.util.List;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

/**
 *
 * @author Benjamin
 */
public class ChatListener implements Listener {
   @EventHandler(priority=64)
   public void onChat(ChatEvent chat) {
    if (!(chat.getSender() instanceof ProxiedPlayer)) {
    return;
    }
    ProxiedPlayer player = (ProxiedPlayer)chat.getSender();
    String msg = chat.getMessage();
    String[] cmd = msg.split(" ");
    List<String> blockCMD = ConfigManager.getBlockCMDS();
    for (String blockedCMD : blockCMD) {
    if (blockedCMD.equalsIgnoreCase(cmd[0]))
    {
        chat.setCancelled(true);
        player.sendMessage(ConfigManager.getBlockedCMDMessage());
        return;
    }
    }
    for (String zensur : ConfigManager.getCensorship()) {
    if ((msg.contains(zensur)) || (msg.contains(zensur.toUpperCase())))
    {
        chat.setCancelled(true);
        player.sendMessage(ConfigManager.getCensorshipMessage());
        return;
    }
}
   chat.setCancelled(false);
}
}
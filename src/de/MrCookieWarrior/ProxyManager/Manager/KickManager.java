/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.MrCookieWarrior.ProxyManager.Manager;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;

/**
 *
 * @author Benjamin
 */
public class KickManager {
    public static void kickPlayer(CommandSender player, String target, String reason) {
    ProxiedPlayer playerTarget = BungeeCord.getInstance().getPlayer(target);
    if (playerTarget != null) {
    if (reason != null) {
    if (player.getName().equalsIgnoreCase(playerTarget.getName())) {
    player.sendMessage(ConfigManager.getPrefix() + "§cDu kannst dich nicht selber kicken.");
        } else {
        BungeeCord.getInstance().getPlayer(target).disconnect("§7Du wurdest gekickt! \n §fGrund§f: §c" + reason + "\n §9§lWenn das ein Fehler ist, melde dich im Teamspeak.");
        }
    return;
   }
    player.sendMessage(ConfigManager.getPrefix() + "§cDu musst einen Grund angeben, um den Spieler zu kicken.");
    } else {
        player.sendMessage(ConfigManager.getPrefix() + "§cDer Spieler §f" + target + " §cist nicht §aOnline.");
    }
  }
}
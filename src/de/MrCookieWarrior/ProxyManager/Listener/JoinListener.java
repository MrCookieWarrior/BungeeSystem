/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.MrCookieWarrior.ProxyManager.Listener;

import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

/**
 *
 * @author Benjamin
 */
public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(ServerConnectedEvent connect) {
    ProxiedPlayer player = connect.getPlayer();
}
}
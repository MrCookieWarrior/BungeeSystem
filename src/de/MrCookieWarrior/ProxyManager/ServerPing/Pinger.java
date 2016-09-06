package de.MrCookieWarrior.ProxyManager.ServerPing;

import de.MrCookieWarrior.ProxyManager.Manager.ConfigManager;
import java.util.Collection;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

/**
 *
 * @author Benjamin
 */
public class Pinger implements Listener {
    @EventHandler(priority=5)
    public void onPing(ProxyPingEvent ping) {
    ServerPing con = ping.getResponse();
    con.setDescription(ConfigManager.getMotdLine1() + "\n" + ConfigManager.getMotdLine2());
    ping.setResponse(con);
    if (ConfigManager.getMaintenance() == true) {
    con.setVersion(new ServerPing.Protocol("§c§lWartungsarbeiten", 2));
    con.setDescription(ConfigManager.getMotdLine1() + "\n" + ConfigManager.getMaintenanceMotd());
    ping.setResponse(con);
    return;
    }
}
   
    @EventHandler
    public void onLogin(LoginEvent login) {
    if (!ConfigManager.getMaintenance()) {
    return;
   }
    boolean Permission = false;
    for (String s : BungeeCord.getInstance().getConfigurationAdapter().getGroups(login.getConnection().getName())) {
    Collection perms = BungeeCord.getInstance().getConfigurationAdapter().getList("permissions." + s, null);
    if ((perms.contains("wartung.permission")) || (perms.contains("*"))) {
    Permission = true;
    return;
    }
    }
    if (!Permission) {
    login.setCancelReason("Du wurdest gekickt! \n Grund&f: " + ConfigManager.getMaintenanceMotd() + "\nTut uns Leid wir haben Momentane Wartungsarbeiten...\nWenn das ein Fehler ist, melde dich im Teamspeak.\n&bTeamSpeak IP -> 84.200.7.158:9988");
    login.setCancelled(true);
}
   }
}
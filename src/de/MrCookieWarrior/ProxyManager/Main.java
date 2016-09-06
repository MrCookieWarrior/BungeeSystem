package de.MrCookieWarrior.ProxyManager;

import de.MrCookieWarrior.ProxyManager.Commands.Hub;
import de.MrCookieWarrior.ProxyManager.Commands.Kick;
import de.MrCookieWarrior.ProxyManager.Commands.Maintenance;
import de.MrCookieWarrior.ProxyManager.Commands.Reload;
import de.MrCookieWarrior.ProxyManager.Listener.ChatListener;
import de.MrCookieWarrior.ProxyManager.Listener.JoinListener;
import de.MrCookieWarrior.ProxyManager.Manager.ConfigManager;
import de.MrCookieWarrior.ProxyManager.ServerPing.Pinger;
import java.io.PrintStream;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

public class Main
   extends Plugin
{
    private static Main INSTANCE;
    private static ConfigManager configmanager;
   
    public void onEnable()
        
       {
    INSTANCE = this;
    ConfigManager.loadConfiguration();
    Register();
  }
  
   public void Register()
   {
    ProxyServer.getInstance().getPluginManager().registerListener(this, new Pinger());
    ProxyServer.getInstance().getPluginManager().registerListener(this, new ChatListener());
    ProxyServer.getInstance().getPluginManager().registerListener(this, new JoinListener());
    ProxyServer.getInstance().getPluginManager().registerCommand(this, new Maintenance());
    ProxyServer.getInstance().getPluginManager().registerCommand(this, new Reload());
    ProxyServer.getInstance().getPluginManager().registerCommand(this, new Hub());
    ProxyServer.getInstance().getPluginManager().registerCommand(this, new Kick());
   }
   
   public static Main getInstance()
   {
    return INSTANCE;
   }
  
   public void log(String log)
{
    System.out.println(ConfigManager.getPrefix() + log);
  }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.MrCookieWarrior.ProxyManager.Manager;

import de.MrCookieWarrior.ProxyManager.Main;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

/**
 *
 * @author Benjamin
 */
/*  15:    */ public class ConfigManager
/*  16:    */ {
/*  17: 22 */   public static File file = new File(Main.getInstance().getDataFolder().getPath(), "config.yml");
/*  18: 23 */   public static String path = "ProxyManager.";
/*  19: 24 */   public static List<String> CanJoin = new ArrayList();
/*  20:    */   
/*  21:    */   public static void loadConfiguration()
/*  22:    */   {
/*  23: 27 */     if (!Main.getInstance().getDataFolder().exists()) {
/*  24: 28 */       Main.getInstance().getDataFolder().mkdir();
/*  25:    */     }
/*  26: 31 */     if (!file.exists()) {
/*  27:    */       try
/*  28:    */       {
/*  29: 33 */         file.createNewFile();
/*  30: 34 */         set("GLOBAL_Prefix", "&6Titan&9Hero.&2de: &7");
/*  31: 35 */         set("GLOBAL_Censorship-Message", "&cBitte achte auf deine Wortwahl");
/*  32: 36 */         set("GLOBAL_BlockedCMD-Message", "&ci'm sorry, but you do not have permission to perform this command. Please contact the server administrators if you believe that this is in error.");
/*  33: 37 */         set("GLOBAL_Hub", "lobby");
/*  34: 38 */         set("GLOBAL_Chat", Boolean.valueOf(true));
/*  35:    */         
/*  36:    */ 
/*  37:    */ 
/*  38:    */ 
/*  39: 43 */         List<String> zensur = getStringList("GLOBAL_Censorship");
/*  40: 44 */         zensur.add("schwanz");
/*  41: 45 */         zensur.add("penis");
/*  42: 46 */         zensur.add("huso");
/*  43: 47 */         zensur.add("penner");
/*  44: 48 */         zensur.add("nazi");
/*  45: 49 */         zensur.add("arsch");
/*  46: 50 */         zensur.add("arschloch");
/*  47: 51 */         zensur.add("blöd");
/*  48: 52 */         zensur.add("doof");
/*  49: 53 */         zensur.add("hacker");
/*  49: 53 */         zensur.add("eZ");
/*  49: 53 */         zensur.add("ez");
/*  49: 53 */         zensur.add("Ez");
/*  49: 53 */         zensur.add("Easy");
/*  49: 53 */         zensur.add("easy");
/*  49: 53 */         zensur.add("sex");
/*  49: 53 */         zensur.add("Sex");
/*  50: 54 */         zensur.add("Vögeln");
/*  49: 53 */         zensur.add("vögeln");
/*  49: 53 */         zensur.add("Ficken");
/*  49: 53 */         zensur.add("ficken");
/*  49: 53 */         zensur.add("fick");
/*  49: 53 */         zensur.add("Fick");
/*  51: 55 */         set("GLOBAL_Censorship", zensur);
/*  52:    */         
/*  53: 57 */         List<String> blockcmd = getStringList("GLOBAL_BlockedCommands");
/*  54: 58 */         blockcmd.add("/?");
/*  55: 59 */         blockcmd.add("/pl");
/*  56: 60 */         blockcmd.add("/plugins");
/*  57: 61 */         blockcmd.add("/plugin");
/*  58: 62 */         blockcmd.add("/version");
/*  59: 63 */         blockcmd.add("/spigot");
					  blockcmd.add("/op");
/*  60: 64 */         blockcmd.add("/bukkit");
					  blockcmd.add("/help");
/*  61: 65 */         set("GLOBAL_BlockedCommands", blockcmd);
/*  62:    */         
/*  63:    */ 
/*  64:    */ 
/*  65:    */ 
/*  66: 70 */         set("MaintenaceManager.allowedPlayer", "");
/*  67: 71 */         List<String> players = getStringList("MaintenaceManager.allowedPlayer");
/*  69: 73 */         players.add("MrCookieWarrior");
/*  70: 74 */         players.add("spielhoehle");
/*  71: 75 */         set("MaintenaceManager.allowedPlayer", players);
/*  72:    */         
/*  73: 77 */         set("MotdManager.Line1", "&3Willkommen auf dem &aSpielhoele &3Community Netzwerk!");
/*  74: 78 */         set("MotdManager.Line2", "&§Wir Wünschen dir Viel Spaß &bWünscht dir das Team");
/*  75: 79 */         set("MaintenaceManager.Status", Boolean.valueOf(false));
/*  76: 80 */         set("MaintenaceManager.Motd", "&eTut uns Leid wir haben Momentane &4Wartungsarbeiten");
/*  77:    */         
/*  78:    */ 
/*  79:    */ 
/*  80:    */ 
/*  81: 85 */         set("MySQL.Host", "localhost");
/*  82: 86 */         set("MySQL.Port", Integer.valueOf(3306));
/*  83: 87 */         set("MySQL.Username", "");
/*  84: 88 */         set("MySQL.Passwort", "");
/*  85: 89 */         set("MySQL.Datenbank", "DuplyCraft");
/*  86:    */       }
/*  87:    */       catch (IOException ex)
/*  88:    */       {
/*  89: 91 */         Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "Loading error: ConfigManager.java");
/*  90:    */       }
/*  91:    */     }
/*  92: 94 */     reloadConfiguration(false);
/*  93:    */   }
/*  94:    */   
/*  95:    */   public static void reloadConfiguration(boolean done)
/*  96:    */   {
/*  97:    */     try
/*  98:    */     {
/*  99: 99 */       if (!done)
/* 100:    */       {
/* 101:100 */         Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
/* 102:101 */         return;
/* 103:    */       }
/* 104:104 */       loadConfiguration();
/* 105:    */     }
/* 106:    */     catch (IOException ex)
/* 107:    */     {
/* 108:106 */       Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "Reload error: ConfigManager.java");
/* 109:    */     }
/* 110:    */   }
/* 111:    */   
/* 112:    */   public static void set(String newPath, Object value)
/* 113:    */   {
/* 114:    */     try
/* 115:    */     {
/* 116:112 */       Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
/* 117:113 */       config.set(path + newPath, value);
/* 118:114 */       ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
/* 119:    */     }
/* 120:    */     catch (IOException ex)
/* 121:    */     {
/* 122:116 */       Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "setMethod : ConfigManager.java");
/* 123:    */     }
/* 124:    */   }
/* 125:    */   
/* 126:    */   public static boolean getBoolean(String newPath)
/* 127:    */     throws IOException
/* 128:    */   {
/* 129:121 */     Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
/* 130:122 */     return config.getBoolean(path + newPath);
/* 131:    */   }
/* 132:    */   
/* 133:    */   public static String getString(String newPath)
/* 134:    */     throws IOException
/* 135:    */   {
/* 136:126 */     Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
/* 137:127 */     return config.getString(path + newPath);
/* 138:    */   }
/* 139:    */   
/* 140:    */   public static int getInt(String newPath)
/* 141:    */     throws IOException
/* 142:    */   {
/* 143:131 */     Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
/* 144:132 */     return config.getInt(path + newPath);
/* 145:    */   }
/* 146:    */   
/* 147:    */   public static List<String> getStringList(String newPath)
/* 148:    */     throws IOException
/* 149:    */   {
/* 150:136 */     Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
/* 151:137 */     return config.getStringList(path + newPath);
/* 152:    */   }
/* 153:    */   
/* 154:    */   public static String getPath()
/* 155:    */   {
/* 156:141 */     return path;
/* 157:    */   }
/* 158:    */   
/* 159:    */   public static String getBlockedCMDMessage()
/* 160:    */   {
/* 161:    */     try
/* 162:    */     {
/* 163:146 */       return ChatColor.translateAlternateColorCodes('&', getString("GLOBAL_BlockedCMD-Message"));
/* 164:    */     }
/* 165:    */     catch (IOException ex)
/* 166:    */     {
/* 167:148 */       Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "BlockCMDMessage: ConfigManager.java");
/* 168:    */     }
/* 169:150 */     return null;
/* 170:    */   }
/* 171:    */   
/* 172:    */   public static String getMotdLine1()
/* 173:    */   {
/* 174:    */     try
/* 175:    */     {
/* 176:155 */       return ChatColor.translateAlternateColorCodes('&', getString("MotdManager.Line1"));
/* 177:    */     }
/* 178:    */     catch (IOException ex)
/* 179:    */     {
/* 180:157 */       Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "getMotdLine1: ConfigManager.java");
/* 181:    */     }
/* 182:159 */     return null;
/* 183:    */   }
/* 184:    */   
/* 185:    */   public static String getMotdLine2()
/* 186:    */   {
/* 187:    */     try
/* 188:    */     {
/* 189:164 */       return ChatColor.translateAlternateColorCodes('&', getString("MotdManager.Line2"));
/* 190:    */     }
/* 191:    */     catch (IOException ex)
/* 192:    */     {
/* 193:166 */       Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "getMotdLine2: ConfigManager.java");
/* 194:    */     }
/* 195:168 */     return null;
/* 196:    */   }
/* 197:    */   
/* 198:    */   public static String getPrefix()
/* 199:    */   {
/* 200:    */     try
/* 201:    */     {
/* 202:173 */       return ChatColor.translateAlternateColorCodes('&', getString("GLOBAL_Prefix"));
/* 203:    */     }
/* 204:    */     catch (IOException ex)
/* 205:    */     {
/* 206:175 */       Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "GlobalPrefix: ConfigManager.java");
/* 207:    */     }
/* 208:177 */     return null;
/* 209:    */   }
/* 210:    */   
/* 211:    */   public static boolean getChat()
/* 212:    */   {
/* 213:    */     try
/* 214:    */     {
/* 215:182 */       return getBoolean("GLOBAL_Chat");
/* 216:    */     }
/* 217:    */     catch (IOException ex)
/* 218:    */     {
/* 219:184 */       Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "GlobalChat: ConfigManager.java");
/* 220:    */     }
/* 221:186 */     return true;
/* 222:    */   }
/* 223:    */   
/* 224:    */   public static boolean getMaintenance()
/* 225:    */   {
/* 226:    */     try
/* 227:    */     {
/* 228:191 */       return getBoolean("MaintenaceManager.Status");
/* 229:    */     }
/* 230:    */     catch (IOException ex)
/* 231:    */     {
/* 232:193 */       Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "MaintenanceStatus: ConfigManager.java");
/* 233:    */     }
/* 234:195 */     return true;
/* 235:    */   }
/* 236:    */   
/* 237:    */   public static String getMaintenanceMotd()
/* 238:    */   {
/* 239:    */     try
/* 240:    */     {
/* 241:200 */       return ChatColor.translateAlternateColorCodes('&', getString("MaintenaceManager.Motd"));
/* 242:    */     }
/* 243:    */     catch (IOException ex)
/* 244:    */     {
/* 245:202 */       Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "MaintenanceMotd: ConfigManager.java");
/* 246:    */     }
/* 247:204 */     return null;
/* 248:    */   }
/* 249:    */   
/* 250:    */   public static List<String> getAllowPlayers()
/* 251:    */   {
/* 252:    */     try
/* 253:    */     {
/* 254:209 */       return getStringList("MaintenaceManager.allowedPlayer");
/* 255:    */     }
/* 256:    */     catch (IOException ex)
/* 257:    */     {
/* 258:211 */       Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "getAllowPlayers: ConfigManager.java");
/* 259:    */     }
/* 260:213 */     return null;
/* 261:    */   }
/* 262:    */   
/* 263:    */   public static List<String> getCensorship()
/* 264:    */   {
/* 265:    */     try
/* 266:    */     {
/* 267:218 */       return getStringList("GLOBAL_Censorship");
/* 268:    */     }
/* 269:    */     catch (IOException ex)
/* 270:    */     {
/* 271:220 */       Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "getCensorship: ConfigManager.java");
/* 272:    */     }
/* 273:222 */     return null;
/* 274:    */   }
/* 275:    */   
/* 276:    */   public static String getCensorshipMessage()
/* 277:    */   {
/* 278:    */     try
/* 279:    */     {
/* 280:227 */       return ChatColor.translateAlternateColorCodes('&', getString("GLOBAL_Censorship-Message"));
/* 281:    */     }
/* 282:    */     catch (IOException ex)
/* 283:    */     {
/* 284:229 */       Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "getCensorshipMessage: ConfigManager.java");
/* 285:    */     }
/* 286:231 */     return null;
/* 287:    */   }
/* 288:    */   
/* 289:    */   public static List<String> getBlockCMDS()
/* 290:    */   {
/* 291:    */     try
/* 292:    */     {
/* 293:236 */       return getStringList("GLOBAL_BlockedCommands");
/* 294:    */     }
/* 295:    */     catch (IOException ex)
/* 296:    */     {
/* 297:238 */       Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "BlockCMDS: ConfigManager.java");
/* 298:    */     }
/* 299:240 */     return null;
/* 300:    */   }
/* 301:    */   
/* 302:    */   public static String getHub()
/* 303:    */   {
/* 304:    */     try
/* 305:    */     {
/* 306:245 */       return ChatColor.translateAlternateColorCodes('&', getString("GLOBAL_Hub"));
/* 307:    */     }
/* 308:    */     catch (IOException ex)
/* 309:    */     {
/* 310:247 */       Logger.getLogger(ConfigManager.class.getName()).log(Level.SEVERE, null, "getHub: ConfigManager.java");
/* 311:    */     }
/* 312:249 */     return null;
/* 313:    */   }
/* 314:    */ }
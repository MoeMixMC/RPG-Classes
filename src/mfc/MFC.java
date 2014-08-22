package mfc;

import java.io.File;
import java.util.logging.Logger;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import Listeners.TeleportListener;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;

public class MFC extends JavaPlugin {
	
	public static MFC plugin;
	public YamlConfiguration config;
	public static Class warriorClass;
	public static Class priestClass;
	public static Class thiefClass;
	public static Class archerClass;
	
	public static Logger logger = Logger.getLogger("Minecraft");
	public static Economy economy = null;
	
	YamlConfiguration currencyConfig;
	
	public void onEnable(){
		setupEconomy();
		
		plugin = this;
		
		Portal wportal = new Portal("warriors");
		Portal aportal = new Portal("archers");
		Portal tportal = new Portal("thief");
		Portal pportal = new Portal("priest");
		
		warriorClass = new Class("Warrior");
		priestClass = new Class("Priest");
		thiefClass = new Class("Thief");
		archerClass = new Class("Archer");
		getServer().getPluginManager().registerEvents(new TeleportListener(), this);
		logger.info("MFC [MineFuse Classes] has been Enabled!");
		
	}
	
	public void onDisable(){
		logger.info("MFC [MineFuse Classes] has been Disabled!");
	}
	
	public WorldEditPlugin getWorldEdit(){
		Plugin p = Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
		if(p instanceof WorldEditPlugin){
			return (WorldEditPlugin)p;
		}
		return null;
	}
	
	public static MFC getInstance(){
		return plugin;
	}
    private boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player player = (Player)sender;
		if(label.equalsIgnoreCase("setspawn")){
			if(args.length == 0){
				player.sendMessage(ChatColor.RED + "Format: /setspawn [class]");
			}
			else if(args.length == 1){
				if(args[0].equalsIgnoreCase("warriors")){
					File file = new File("classes.yml");
					config = YamlConfiguration.loadConfiguration(file);
					
					int x = player.getLocation().getBlockX();
					int y = player.getLocation().getBlockY();
					int z = player.getLocation().getBlockZ();
					String world = player.getWorld().getName();
					
					config.set("Warriors.x", x);
					config.set("Warriors.y", y);
					config.set("Warriors.z", z);
					config.set("Warriors.world", world);
					try{
						config.save(file);
					}catch(Exception e){
						
					}
					player.sendMessage(ChatColor.GREEN + "Successfully set Warriors spawn point!");
				}
				if(args[0].equalsIgnoreCase("archers")){
					File file = new File("classes.yml");
					config = YamlConfiguration.loadConfiguration(file);
					
					int x = player.getLocation().getBlockX();
					int y = player.getLocation().getBlockY();
					int z = player.getLocation().getBlockZ();
					String world = player.getWorld().getName();
					
					config.set("Archers.x", x);
					config.set("Archers.y", y);
					config.set("Archers.z", z);
					config.set("Archers.world", world);
					
					try{
						config.save(file);
					}catch(Exception e){
						
					}
					
					player.sendMessage(ChatColor.GREEN + "Successfully set Archers spawn point!");
				}
				if(args[0].equalsIgnoreCase("thief")){
					File file = new File("classes.yml");
					config = YamlConfiguration.loadConfiguration(file);
					
					int x = player.getLocation().getBlockX();
					int y = player.getLocation().getBlockY();
					int z = player.getLocation().getBlockZ();
					String world = player.getWorld().getName();
					
					config.set("Thief.x", x);
					config.set("Thief.y", y);
					config.set("Thief.z", z);
					config.set("Thief.world", world);
					try{
						config.save(file);
					}catch(Exception e){
						
					}
					
					player.sendMessage(ChatColor.GREEN + "Successfully set Thief spawn point!");
					
				}
				if(args[0].equalsIgnoreCase("priest")){
					File file = new File("classes.yml");
					config = YamlConfiguration.loadConfiguration(file);
					
					int x = player.getLocation().getBlockX();
					int y = player.getLocation().getBlockY();
					int z = player.getLocation().getBlockZ();
					String world = player.getWorld().getName();
					
					config.set("Priest.x", x);
					config.set("Priest.y", y);
					config.set("Priest.z", z);
					config.set("Priest.world", world);
					try{
						config.save(file);
					}catch(Exception e){
						
					}
					player.sendMessage(ChatColor.GREEN + "Successfully set Priest spawn point!");
				}
			}
		}
		if(label.equalsIgnoreCase("setportal")){
			if(args.length == 0){
				player.sendMessage(ChatColor.RED + "Format: /setportal [class]");
			}
			else if(args.length == 1){
				if(args[0].equalsIgnoreCase("warriors")){
					
					File file = new File("portals.yml");
					config = YamlConfiguration.loadConfiguration(file);
					
					Location maxPoint = getWorldEdit().getSelection(player).getMaximumPoint();
					Location minPoint = getWorldEdit().getSelection(player).getMinimumPoint();
					// max point info
					int maxX = maxPoint.getBlockX();
					int maxY = maxPoint.getBlockY();
					int maxZ = maxPoint.getBlockZ();
					String maxWorld = maxPoint.getWorld().getName();
					// min point info
					int minX = minPoint.getBlockX();
					int minY = minPoint.getBlockY();
					int minZ = minPoint.getBlockZ();
					String minWorld = minPoint.getWorld().getName();
					
					config.set("Portals.Warriors.Max_Point.x", maxX);
					config.set("Portals.Warriors.Max_Point.y", maxY);
					config.set("Portals.Warriors.Max_Point.z", maxZ);
					config.set("Portals.Warriors.Max_Point.world", maxWorld);
					
					config.set("Portals.Warriors.Min_Point.x", minX);
					config.set("Portals.Warriors.Min_Point.y", minY);
					config.set("Portals.Warriors.Min_Point.z", minZ);
					config.set("Portals.Warriors.Min_Point.world", minWorld);
					try{
						config.save(file);
					}catch(Exception e){
						
					}
					player.sendMessage("set");
				}
				if(args[0].equalsIgnoreCase("archers")){
					
					File file = new File("portals.yml");
					config = YamlConfiguration.loadConfiguration(file);
					
					Location maxPoint = getWorldEdit().getSelection(player).getMaximumPoint();
					Location minPoint = getWorldEdit().getSelection(player).getMinimumPoint();
					// max point info
					int maxX = maxPoint.getBlockX();
					int maxY = maxPoint.getBlockY();
					int maxZ = maxPoint.getBlockZ();
					String maxWorld = maxPoint.getWorld().getName();
					// min point info
					int minX = minPoint.getBlockX();
					int minY = minPoint.getBlockY();
					int minZ = minPoint.getBlockZ();
					String minWorld = minPoint.getWorld().getName();
					
					config.set("Portals.Archers.Max_Point.x", maxX);
					config.set("Portals.Archers.Max_Point.y", maxY);
					config.set("Portals.Archers.Max_Point.z", maxZ);
					config.set("Portals.Archers.Max_Point.world", maxWorld);
					
					config.set("Portals.Archers.Min_Point.x", minX);
					config.set("Portals.Archers.Min_Point.y", minY);
					config.set("Portals.Archers.Min_Point.z", minZ);
					config.set("Portals.Archers.Min_Point.world", minWorld);
					try{
						config.save(file);
					}catch(Exception e){
						
					}
					player.sendMessage("set");
				}
				if(args[0].equalsIgnoreCase("thief")){
					
					File file = new File("portals.yml");
					config = YamlConfiguration.loadConfiguration(file);
					
					Location maxPoint = getWorldEdit().getSelection(player).getMaximumPoint();
					Location minPoint = getWorldEdit().getSelection(player).getMinimumPoint();
					// max point info
					int maxX = maxPoint.getBlockX();
					int maxY = maxPoint.getBlockY();
					int maxZ = maxPoint.getBlockZ();
					String maxWorld = maxPoint.getWorld().getName();
					// min point info
					int minX = minPoint.getBlockX();
					int minY = minPoint.getBlockY();
					int minZ = minPoint.getBlockZ();
					String minWorld = minPoint.getWorld().getName();
					
					config.set("Portals.Thief.Max_Point.x", maxX);
					config.set("Portals.Thief.Max_Point.y", maxY);
					config.set("Portals.Thief.Max_Point.z", maxZ);
					config.set("Portals.Thief.Max_Point.world", maxWorld);
					
					config.set("Portals.Thief.Min_Point.x", minX);
					config.set("Portals.Thief.Min_Point.y", minY);
					config.set("Portals.Thief.Min_Point.z", minZ);
					config.set("Portals.Thief.Min_Point.world", minWorld);
					try{
						config.save(file);
					}catch(Exception e){
						
					}
					player.sendMessage("set");
				}
				if(args[0].equalsIgnoreCase("priest")){
					
					File file = new File("portals.yml");
					config = YamlConfiguration.loadConfiguration(file);
					
					Location maxPoint = getWorldEdit().getSelection(player).getMaximumPoint();
					Location minPoint = getWorldEdit().getSelection(player).getMinimumPoint();
					// max point info
					int maxX = maxPoint.getBlockX();
					int maxY = maxPoint.getBlockY();
					int maxZ = maxPoint.getBlockZ();
					String maxWorld = maxPoint.getWorld().getName();
					// min point info
					int minX = minPoint.getBlockX();
					int minY = minPoint.getBlockY();
					int minZ = minPoint.getBlockZ();
					String minWorld = minPoint.getWorld().getName();
					
					config.set("Portals.Priest.Max_Point.x", maxX);
					config.set("Portals.Priest.Max_Point.y", maxY);
					config.set("Portals.Priest.Max_Point.z", maxZ);
					config.set("Portals.Priest.Max_Point.world", maxWorld);
					
					config.set("Portals.Priest.Min_Point.x", minX);
					config.set("Portals.Priest.Min_Point.y", minY);
					config.set("Portals.Priest.Min_Point.z", minZ);
					config.set("Portals.Priest.Min_Point.world", minWorld);
					try{
						config.save(file);
					}catch(Exception e){
						
					}
					player.sendMessage("set");
				}
			}
		}
		if(label.equalsIgnoreCase("wportal")){
			String portal = Portal.getPortal("warriors").getName();
			player.sendMessage(portal);
		}
		if(label.equalsIgnoreCase("createfile")){
			File file = new File("currency.yml");
			currencyConfig = YamlConfiguration.loadConfiguration(file);
			currencyConfig.set("Warriors.ratio", "Enter ratio here (Ex: if 1 ingot equals $10, I would put 10 here)");
			currencyConfig.set("Archers.ratio", "Enter ratio here (Ex: if 1 ingot equals $10, I would put 10 here)");
			currencyConfig.set("Thief.ratio", "Enter ratio here (Ex: if 1 ingot equals $10, I would put 10 here)");
			currencyConfig.set("Priest.ratio", "Enter ratio here (Ex: if 1 ingot equals $10, I would put 10 here)");
			try{
				currencyConfig.save(file);
			}catch(Exception e){
				
			}
		}
		if(label.equalsIgnoreCase("deposit")){
			File file = new File("currency.yml");
			currencyConfig = YamlConfiguration.loadConfiguration(file);
			if(args.length == 0){
				// TODO deposit all ingots
			}
			else if(args.length == 1){
				ItemStack inHand = player.getItemInHand();
				int amount = inHand.getAmount();
				
				if(inHand.getType().equals(Material.GOLD_INGOT)){
					int depositAmount = Integer.parseInt(args[0]);
					if(depositAmount <= amount){
						player.getInventory().removeItem(new ItemStack(Material.GOLD_INGOT, depositAmount));
						if(Class.getClassOfPlayer(player).getName() == "Warrior"){
							int ratio = currencyConfig.getInt("Warriors.ratio");
							economy.depositPlayer(player.getName(), depositAmount*ratio);
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aYou have deposited &4"+depositAmount+" &agolden ingots!"));
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aRecieved &b"+depositAmount*ratio+"&a!"));
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aBalance: &b"+economy.getBalance(player)+"&a!"));
						}
						if(Class.getClassOfPlayer(player).getName() == "Archers"){
							int ratio = currencyConfig.getInt("Archers.ratio");
							economy.depositPlayer(player.getName(), depositAmount*ratio);
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aYou have deposited &4"+depositAmount+" &agolden ingots!"));
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aRecieved &b"+depositAmount*ratio+"&a!"));
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aBalance: &b"+economy.getBalance(player)+"&a!"));
						}
						if(Class.getClassOfPlayer(player).getName() == "Thief"){
							int ratio = currencyConfig.getInt("Thief.ratio");
							economy.depositPlayer(player.getName(), depositAmount*ratio);
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aYou have deposited &4"+depositAmount+" &agolden ingots!"));
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aRecieved &b"+depositAmount*ratio+"&a!"));
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aBalance: &b"+economy.getBalance(player)+"&a!"));
						}
						if(Class.getClassOfPlayer(player).getName() == "Priest"){
							int ratio = currencyConfig.getInt("Priest.ratio");
							economy.depositPlayer(player.getName(), depositAmount*ratio);
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aYou have deposited &4"+depositAmount+" &agolden ingots!"));
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aRecieved &b"+depositAmount*ratio+"&a!"));
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aBalance: &b"+economy.getBalance(player)+"&a!"));
						}
					}
				}
			}
		}
		if(label.equalsIgnoreCase("withdraw")){
			double balance = economy.getBalance(player.getName());
			if(args.length == 1){
				int withdrawAmount = Integer.parseInt(args[0]);
				
			}
		}
		return false;
	}
	
	
}

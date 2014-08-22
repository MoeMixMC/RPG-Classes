package mfc;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Class {
	
	public static YamlConfiguration classSpawnConfig;
	public String className;
	public HashMap<Player, Class> playerClass = new HashMap<Player, Class>();
	public ArrayList<ItemStack> classItems = new ArrayList<ItemStack>();
	
	
	
	public Class(String className){
		this.className = className;
	}
	
	public void addPlayer(Player p){
		playerClass.put(p, this);
		File file = new File("players.yml");
		classSpawnConfig = YamlConfiguration.loadConfiguration(file);
		classSpawnConfig.set("Players."+p.getName(), getName());
		try{
			classSpawnConfig.save(file);
		}catch(Exception e){
			
		}
	}
	
	public void removePlayer(Player p){
		playerClass.remove(p);
	}
	
	public String getName(){
		return className;
	}
	
	public static Class getClassOfPlayer(Player p){
		File file = new File("players.yml");
		classSpawnConfig = YamlConfiguration.loadConfiguration(file);
		String playerClass = classSpawnConfig.getString("Players."+p.getName());
		
		if(playerClass.equalsIgnoreCase("warrior")){
			return MFC.warriorClass;
		}
		else if(playerClass.equalsIgnoreCase("archer")){
			return MFC.archerClass;
		}
		else if(playerClass.equalsIgnoreCase("thief")){
			return MFC.thiefClass;
		}
		else if(playerClass.equalsIgnoreCase("priest")){
			return MFC.priestClass;
		}
		else{
			return null;
		}
	}
	
	public void addItem(Material material, Integer amount, String displayName){
		
		ItemStack item = new ItemStack(material, amount);
		ItemMeta itemim = item.getItemMeta();
		itemim.setDisplayName(displayName);
		item.setItemMeta(itemim);
		
		classItems.add(item);
	}
	
	public void giveItems(Player p){
		for(ItemStack item : classItems){
			p.getInventory().addItem(item);
		}
	}
	
	public Location getSpawnLocation(){
		if(getName().equalsIgnoreCase("warrior")){
			File file = new File("classes.yml");
			classSpawnConfig = YamlConfiguration.loadConfiguration(file);
			
			String locx = classSpawnConfig.getString("Warriors.x");
			String locy = classSpawnConfig.getString("Warriors.y");
			String locz = classSpawnConfig.getString("Warriors.z");
			String world = classSpawnConfig.getString("Warriors.world");
			
			int x = Integer.parseInt(locx);
			int y = Integer.parseInt(locy);
			int z = Integer.parseInt(locz);
			
			Location location = new Location(Bukkit.getWorld(world), Double.parseDouble(locx), Double.parseDouble(locy), Double.parseDouble(locz));
			return location;
		}
		if(getName().equalsIgnoreCase("thief")){
			File file = new File("classes.yml");
			classSpawnConfig = YamlConfiguration.loadConfiguration(file);
			
			String locx = classSpawnConfig.getString("Thief.x");
			String locy = classSpawnConfig.getString("Thief.y");
			String locz = classSpawnConfig.getString("Thief.z");
			String world = classSpawnConfig.getString("Thief.world");
			
			Location location = new Location(Bukkit.getWorld(world), Double.parseDouble(locx), Double.parseDouble(locy), Double.parseDouble(locz));
			return location;
		}
		if(getName().equalsIgnoreCase("priest")){
			File file = new File("classes.yml");
			classSpawnConfig = YamlConfiguration.loadConfiguration(file);
			
			String locx = classSpawnConfig.getString("Priest.x");
			String locy = classSpawnConfig.getString("Priest.y");
			String locz = classSpawnConfig.getString("Priest.z");
			String world = classSpawnConfig.getString("Priest.world");
			
			Location location = new Location(Bukkit.getWorld(world), Double.parseDouble(locx), Double.parseDouble(locy), Double.parseDouble(locz));
			return location;
		}
		if(getName().equalsIgnoreCase("archer")){
			File file = new File("classes.yml");
			classSpawnConfig = YamlConfiguration.loadConfiguration(file);
			
			String locx = classSpawnConfig.getString("Archers.x");
			String locy = classSpawnConfig.getString("Archers.y");
			String locz = classSpawnConfig.getString("Archers.z");
			String world = classSpawnConfig.getString("Archers.world");
			
			Location location = new Location(Bukkit.getWorld(world), Double.parseDouble(locx), Double.parseDouble(locy), Double.parseDouble(locz));
			return location;
		}
		return null;
	}
	
}

package mfc;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.bukkit.selections.CuboidSelection;
import com.sk89q.worldedit.bukkit.selections.Selection;

public class Portal {
	
	public YamlConfiguration config;
	public static ArrayList<Portal> portals = new ArrayList<Portal>();
	public String portalName;
	//public Selection portalSelection;
	
	public Portal(String portalName){
		portals.add(this);
		this.portalName = portalName;
		//portalSelection = getWorldEdit().getSelection(p);
	}
	
	public WorldEditPlugin getWorldEdit(){
		Plugin p = Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
		if(p instanceof WorldEditPlugin){
			return (WorldEditPlugin)p;
		}
		return null;
	}
	
	public CuboidSelection getSelection(){
		if(getName().equalsIgnoreCase("warriors")){
			File file = new File("portals.yml");
			config = YamlConfiguration.loadConfiguration(file);
			
			String maxX = config.getString("Portals.Warriors.Max_Point.x");
			String maxY = config.getString("Portals.Warriors.Max_Point.y");
			String maxZ = config.getString("Portals.Warriors.Max_Point.z");
			String maxWorld = config.getString("Portals.Warriors.Max_Point.world");
			
			Location maxPoint = new Location(Bukkit.getWorld(maxWorld), Double.parseDouble(maxX), Double.parseDouble(maxY), Double.parseDouble(maxZ));
			
			String minX = config.getString("Portals.Warriors.Min_Point.x");
			String minY = config.getString("Portals.Warriors.Min_Point.y");
			String minZ = config.getString("Portals.Warriors.Min_Point.z");
			String minWorld = config.getString("Portals.Warriors.Min_Point.world");
			
			Location minPoint = new Location(Bukkit.getWorld(minWorld), Double.parseDouble(minX), Double.parseDouble(minY), Double.parseDouble(minZ));
			CuboidSelection selection = new CuboidSelection(Bukkit.getWorld(maxWorld), maxPoint, minPoint);

			
			return selection;
		}
		if(getName().equalsIgnoreCase("archers")){
			File file = new File("portals.yml");
			config = YamlConfiguration.loadConfiguration(file);
			
			String maxX = config.getString("Portals.Archers.Max_Point.x");
			String maxY = config.getString("Portals.Archers.Max_Point.y");
			String maxZ = config.getString("Portals.Archers.Max_Point.z");
			String maxWorld = config.getString("Portals.Archers.Max_Point.world");
			
			Location maxPoint = new Location(Bukkit.getWorld(maxWorld), Double.parseDouble(maxX), Double.parseDouble(maxY), Double.parseDouble(maxZ));
			
			String minX = config.getString("Portals.Archers.Min_Point.x");
			String minY = config.getString("Portals.Archers.Min_Point.y");
			String minZ = config.getString("Portals.Archers.Min_Point.z");
			String minWorld = config.getString("Portals.Archers.Min_Point.world");
			
			Location minPoint = new Location(Bukkit.getWorld(minWorld), Double.parseDouble(minX), Double.parseDouble(minY), Double.parseDouble(minZ));
			
			CuboidSelection selection = new CuboidSelection(Bukkit.getWorld(maxWorld), maxPoint, minPoint);
			return selection;
		}
		if(getName().equalsIgnoreCase("thief")){
			File file = new File("portals.yml");
			config = YamlConfiguration.loadConfiguration(file);
			
			String maxX = config.getString("Portals.Thief.Max_Point.x");
			String maxY = config.getString("Portals.Thief.Max_Point.y");
			String maxZ = config.getString("Portals.Thief.Max_Point.z");
			String maxWorld = config.getString("Portals.Thief.Max_Point.world");
			
			Location maxPoint = new Location(Bukkit.getWorld(maxWorld), Double.parseDouble(maxX), Double.parseDouble(maxY), Double.parseDouble(maxZ));
			
			String minX = config.getString("Portals.Thief.Min_Point.x");
			String minY = config.getString("Portals.Thief.Min_Point.y");
			String minZ = config.getString("Portals.Thief.Min_Point.z");
			String minWorld = config.getString("Portals.Thief.Min_Point.world");
			
			Location minPoint = new Location(Bukkit.getWorld(minWorld), Double.parseDouble(minX), Double.parseDouble(minY), Double.parseDouble(minZ));
			
			CuboidSelection selection = new CuboidSelection(Bukkit.getWorld(maxWorld), maxPoint, minPoint);
			return selection;
		}
		if(getName().equalsIgnoreCase("priest")){
			File file = new File("portals.yml");
			config = YamlConfiguration.loadConfiguration(file);
			
			String maxX = config.getString("Portals.Priest.Max_Point.x");
			String maxY = config.getString("Portals.Priest.Max_Point.y");
			String maxZ = config.getString("Portals.Priest.Max_Point.z");
			String maxWorld = config.getString("Portals.Priest.Max_Point.world");
			
			Location maxPoint = new Location(Bukkit.getWorld(maxWorld), Double.parseDouble(maxX), Double.parseDouble(maxY), Double.parseDouble(maxZ));
			
			String minX = config.getString("Portals.Priest.Min_Point.x");
			String minY = config.getString("Portals.Priest.Min_Point.y");
			String minZ = config.getString("Portals.Priest.Min_Point.z");
			String minWorld = config.getString("Portals.Priest.Min_Point.world");
			
			Location minPoint = new Location(Bukkit.getWorld(minWorld), Double.parseDouble(minX), Double.parseDouble(minY), Double.parseDouble(minZ));
			
			CuboidSelection selection = new CuboidSelection(Bukkit.getWorld(maxWorld), maxPoint, minPoint);
			return selection;
		}
		return null;
	}
	
	public String getName(){
		return portalName;
	}
	
	public static Portal getPortal(String portalName){
		for(Portal portal : portals){
			if(portal.getName().equalsIgnoreCase(portalName)){
				return portal;
			}
		}
		return null;
	}
	
	
	
}

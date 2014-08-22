package Listeners;

import mfc.MFC;
import mfc.Portal;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class TeleportListener implements Listener{
	Portal wPortal = Portal.getPortal("warriors");
	Portal aPortal = Portal.getPortal("archers");
	Portal tPortal = Portal.getPortal("thief");
	Portal pPortal = Portal.getPortal("priest");
	@EventHandler
	public void onPortalEnter(PlayerMoveEvent e){
		Player player = e.getPlayer();
		
	
		if(wPortal.getSelection().contains(player.getLocation())){
			player.teleport(MFC.warriorClass.getSpawnLocation());
			MFC.warriorClass.addPlayer(player);
			MFC.warriorClass.addItem(Material.PAPER, 1, ChatColor.GREEN + "You are in the Warriors class!");
			MFC.warriorClass.giveItems(player);
		}
		if(aPortal.getSelection().contains(player.getLocation())){
			player.teleport(MFC.archerClass.getSpawnLocation());
			MFC.archerClass.addPlayer(player);
			MFC.archerClass.addItem(Material.PAPER, 1, ChatColor.GREEN + "You are in the Archers class!");
			MFC.archerClass.giveItems(player);
		}
		if(tPortal.getSelection().contains(player.getLocation())){
			player.teleport(MFC.thiefClass.getSpawnLocation());
			MFC.thiefClass.addPlayer(player);
			MFC.thiefClass.addItem(Material.PAPER, 1, ChatColor.GREEN + "You are in the Thief class!");
			MFC.thiefClass.giveItems(player);
		}
		if(pPortal.getSelection().contains(player.getLocation())){
			player.teleport(MFC.priestClass.getSpawnLocation());
			MFC.priestClass.addPlayer(player);
			MFC.priestClass.addItem(Material.PAPER, 1, ChatColor.GREEN + "You are in the Priests class!");
			MFC.priestClass.giveItems(player);
		}
	}
	
	
}

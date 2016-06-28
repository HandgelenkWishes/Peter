package Events;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuit implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage("§f[§cGun§8Game§f]"+ChatColor.GRAY + "[" + ChatColor.DARK_GREEN + ">>>" + ChatColor.GRAY + "] " + ChatColor.GOLD + p.getDisplayName());

		p.setGameMode(GameMode.SURVIVAL);
		p.setExp(0);
		p.setLevel(1);
		p.setFoodLevel(20);
		p.setFireTicks(0);
		p.setHealth(20);
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);

	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event){
		Player player = (Player)event.getPlayer();
		event.setQuitMessage("§f[§cGun§8Game§f]"+ChatColor.GRAY + "[" + ChatColor.DARK_RED + "<<<" + ChatColor.GRAY + "] " + ChatColor.GOLD + player.getDisplayName());
	}

}

package Events;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class MobSpawn implements Listener {
	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent e) {
		Player p = ((OfflinePlayer) e).getPlayer();
		if(!p.isOp()){
		e.setCancelled(true);
		}
	}

}

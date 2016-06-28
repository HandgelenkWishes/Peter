package Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropItem implements Listener{
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		e.setCancelled(true);
		
	}

}

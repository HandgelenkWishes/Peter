package Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class PickUpItem implements Listener {

	@EventHandler
	public void onPickupItem(PlayerPickupItemEvent e) {
		e.setCancelled(true);
	}

}

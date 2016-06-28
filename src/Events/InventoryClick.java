package Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener{
	@EventHandler
	public void onInvClick(InventoryClickEvent e){
		e.setCancelled(true);
	}

}

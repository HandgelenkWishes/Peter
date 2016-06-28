package Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

	 @EventHandler
	  public void onDeath(PlayerDeathEvent e){
	    e.getEntity().setLevel(e.getEntity().getLevel() - 3);
	    e.getEntity().getKiller().setLevel(e.getEntity().getKiller().getLevel() + 1);
	    
	    e.getDrops().clear();
	    e.setDroppedExp(0);
	    e.setKeepLevel(true);
	    if ((e.getEntity().getKiller() instanceof Player)) {
	    	    	
			e.setDeathMessage(ChatColor.AQUA + e.getEntity().getName() + ChatColor.DARK_GRAY + " wurde von "
					+ ChatColor.AQUA + e.getEntity().getKiller().getName() + ChatColor.DARK_GRAY + " getötet!");
		} else {
			e.setDeathMessage(ChatColor.AQUA + e.getEntity().getName() + " ist gestorben!");

		}
	  }
}

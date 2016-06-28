package Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockBreakBlockPlace implements Listener{
	@EventHandler
	public void onBreak(BlockBreakEvent e){
		e.setCancelled(true);
	}
	@EventHandler
	public void onPlace(BlockPlaceEvent e){
		Player p = e.getPlayer();
		if(p.isOp()){
			e.setCancelled(false);
		}else{
		e.setCancelled(true);
		}
	}

}

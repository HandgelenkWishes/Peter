package Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import Locations.GunGame;

public class PlayerRespawn implements Listener{
private GunGame plugin;

public PlayerRespawn(GunGame plugin)
{
  this.plugin = plugin;
}

@EventHandler
public void onRespawn(PlayerRespawnEvent e){
	Player p = e.getPlayer();
  if (p.getLevel() <= 1) {
    p.setLevel(1);
  }
  e.setRespawnLocation(this.plugin.rj.onRespawnLocation(e.getPlayer()));
}
}
package ScoreBoard;

import java.io.IOException;
import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class Events implements Listener {

	public static HashMap<String, Integer> PlayerKills = new HashMap<String, Integer>();
	public static HashMap<String, Integer> PlayerDeaths = new HashMap<String, Integer>();
	
	public static Plugin plugin;
	@SuppressWarnings("static-access")
	public Events(Plugin plugin){
		this.plugin = plugin;
	}
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		@SuppressWarnings("unused")
		Player player = (Player)event.getPlayer();
		
		ScoreboardAdder.createScoreboard(event.getPlayer());
	}


	
	@EventHandler
	public void onPlayerDeathEvent(PlayerDeathEvent e) throws IOException {
		Player toter = e.getEntity();
		if (!PlayerDeaths.containsKey(toter.getName())){
			PlayerDeaths.put(toter.getName(), 0);
		}
		PlayerDeaths.put(toter.getName(), PlayerDeaths.get(toter.getName()) + 1);
		ScoreboardAdder.createScoreboard(toter);
		
		if(e.getEntity().getKiller() instanceof Player){
			Player killer = e.getEntity().getKiller();
			if (!PlayerKills.containsKey(killer.getName())){
				PlayerKills.put(killer.getName(), 0);
			}
			PlayerKills.put(killer.getName(), PlayerKills.get(killer.getName()) + 1);
			ScoreboardAdder.createScoreboard(killer);
		}
	}
	
}

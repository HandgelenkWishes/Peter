package Locations;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import Events.Achievement;
import Events.BlockBreakBlockPlace;
import Events.DropItem;
import Events.FoodLevelChange;
import Events.InventoryClick;
import Events.JoinQuit;
import Events.LevelChange;
import Events.MobSpawn;
import Events.PickUpItem;
import Events.PlayerDeath;
import Events.PlayerRespawn;
import Events.WeatherChange;
import Manager.CommandManager;
import ScoreBoard.Events;

public class GunGame extends JavaPlugin {
	public YamlConfiguration cfg = (YamlConfiguration) getConfig();
	public static final File player_data = new File("GunGame/player_data");
	public SpawnLocation sj = new SpawnLocation(this);
	public RespawnLocation rj = new RespawnLocation(this);

	public void onEnable() {
		loadConfig();

		Bukkit.getPluginManager().registerEvents(new JoinQuit(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerRespawn(this), this);
		Bukkit.getPluginManager().registerEvents(new Achievement(), this);
		Bukkit.getPluginManager().registerEvents(new BlockBreakBlockPlace(), this);
		Bukkit.getPluginManager().registerEvents(new MobSpawn(), this);
		Bukkit.getPluginManager().registerEvents(new DropItem(), this);
		Bukkit.getPluginManager().registerEvents(new FoodLevelChange(), this);
		Bukkit.getPluginManager().registerEvents(new InventoryClick(), this);
		Bukkit.getPluginManager().registerEvents(new LevelChange(), this);
		Bukkit.getPluginManager().registerEvents(new PickUpItem(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerDeath(), this);
		Bukkit.getPluginManager().registerEvents(new WeatherChange(), this);
		Bukkit.getPluginManager().registerEvents(new Events(this), this);
		loadConfig();
		getCommand("gungame").setExecutor(new CommandManager(this));
	}

	public static File getPlayerFile(Player p) {
		return new File(player_data, p.getUniqueId().toString() + ".yml");
	}

	public void loadConfig() {
		@SuppressWarnings("unused")
		
		YamlConfiguration cfg = (YamlConfiguration) getConfig();
		saveConfig();
	}

}

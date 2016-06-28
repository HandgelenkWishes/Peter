package ScoreBoard;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import Events.LevelChange;
import Locations.GunGame;

public class ScoreboardAdder extends LevelChange {

	public static ArrayList<String> sb = new ArrayList<String>();

	@SuppressWarnings("deprecation")
	public static void createScoreboard(Player p) {

		if (p != null) {

			ScoreboardManager sm = p.getServer().getScoreboardManager();
			Scoreboard board = sm.getNewScoreboard();

			Objective score = board.registerNewObjective("aaa", "bbb");
			score.setDisplayName("§f[§cGun§8Game§f]");
			score.setDisplaySlot(DisplaySlot.SIDEBAR);

			Score linie = score.getScore(Bukkit.getOfflinePlayer("§7Highscroe:"));
			Score kills = score.getScore(Bukkit.getOfflinePlayer("§2Kills:"));
			Score deaths = score.getScore(Bukkit.getOfflinePlayer("§4Deaths:"));
			@SuppressWarnings("unused")
			Score kdr = score.getScore(Bukkit.getOfflinePlayer("§Highscore:"));

			linie.setScore(0);
			if (Events.PlayerKills.containsKey(p.getName())) {
				kills.setScore(Events.PlayerKills.get(p.getName()));
			} else {
				kills.setScore(0);
			}

			if (Events.PlayerDeaths.containsKey(p.getName())) {
				deaths.setScore(Events.PlayerDeaths.get(p.getName()));
			} else {
				deaths.setScore(0);
			}

			if (!(GunGame.player_data.exists())) {
				try {
					GunGame.player_data.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			File playerFile = GunGame.getPlayerFile(p);
			FileConfiguration config = YamlConfiguration.loadConfiguration(playerFile);
			if (!playerFile.exists()) {
				try {
					playerFile.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			int highestLevel = config.getInt("highest_level");

			linie.setScore(highestLevel);

			p.setScoreboard(board);
		}

	}

}
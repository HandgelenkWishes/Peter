package Events;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.inventory.ItemStack;

import Locations.GunGame;

public class LevelChange implements Listener {

	@EventHandler

	public void onJoinItem(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (p.getLevel() <= 1) {

			ItemStack holzaxt = new ItemStack(Material.WOOD_AXE);
			p.getInventory().setItem(0, holzaxt);

		} else {
			p.kickPlayer("§cEs ist ein Fehler aufgetreten! Bitte joine erneut.");
		}
	}

	@EventHandler

	public void onLevelChange(PlayerLevelChangeEvent e) {
		Player p = e.getPlayer();
		int newLevel = e.getNewLevel();

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

		if (newLevel > highestLevel) {
			p.sendMessage("§cDu hast einen neuen Highscore!");
			config.set("highest_level", newLevel);
			try {
				config.save(playerFile);
			} catch (IOException e1) {

				e1.printStackTrace();
			}

		}

		if (e.getPlayer().getLevel() <= 1) {
			ItemStack holzaxt = new ItemStack(Material.WOOD_AXE);
			e.getPlayer().getInventory().setItem(0, holzaxt);
		}
		if (newLevel == 2) {
			e.getPlayer().playSound(e.getPlayer().getEyeLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100.0F, 100.0F);
			ItemStack holzschwert = new ItemStack(Material.WOOD_SWORD);
			e.getPlayer().getInventory().setItem(0, holzschwert);
		}
		if (newLevel == 3) {
			e.getPlayer().playSound(e.getPlayer().getEyeLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100.0F, 100.0F);
			ItemStack steinaxt = new ItemStack(Material.STONE_AXE);
			e.getPlayer().getInventory().setItem(0, steinaxt);
		}
		if (newLevel == 4) {
			e.getPlayer().playSound(e.getPlayer().getEyeLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100.0F, 100.0F);
			ItemStack steinschwert = new ItemStack(Material.STONE_SWORD);
			e.getPlayer().getInventory().setItem(0, steinschwert);
		}
		if (newLevel == 5) {
			e.getPlayer().playSound(e.getPlayer().getEyeLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100.0F, 100.0F);
			ItemStack eisenaxt = new ItemStack(Material.IRON_AXE);
			e.getPlayer().getInventory().setItem(0, eisenaxt);
			Bukkit.broadcastMessage("§a" + e.getPlayer().getName() + "§2 hat eine 5er Killstreak!");

		}
		if (newLevel == 6) {
			e.getPlayer().playSound(e.getPlayer().getEyeLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100.0F, 100.0F);
			ItemStack eisenschwert = new ItemStack(Material.IRON_SWORD);
			e.getPlayer().getInventory().setItem(0, eisenschwert);
		}
		if (newLevel == 7) {
			e.getPlayer().playSound(e.getPlayer().getEyeLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100.0F, 100.0F);
			ItemStack diamantaxt = new ItemStack(Material.DIAMOND_AXE);
			e.getPlayer().getInventory().setItem(0, diamantaxt);
		}
		if (newLevel == 8) {
			e.getPlayer().playSound(e.getPlayer().getEyeLocation(), Sound.ENTITY_PLAYER_LEVELUP, 100.0F, 100.0F);
			ItemStack diamantschwert = new ItemStack(Material.DIAMOND_SWORD);
			e.getPlayer().getInventory().setItem(0, diamantschwert);
		}

	}
}
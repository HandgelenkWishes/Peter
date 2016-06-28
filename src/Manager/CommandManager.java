package Manager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import Locations.GunGame;

public class CommandManager implements CommandExecutor {
	private GunGame plugin;

	public CommandManager(GunGame plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String abel, String[] args) {
		Player p = (Player) sender;

		if (sender instanceof Player) {

			if (args.length == 0) {
				p.sendMessage("§cNutze /GunGame <help>");
				return true;
			}
			if (args[0].equalsIgnoreCase("help")) {
				p.sendMessage("6/GunGame SetSpawn");
				return true;
			}
			if (args[0].equalsIgnoreCase("setspawn")) {
				this.plugin.cfg.set("spawn.world", p.getWorld().getName());
				this.plugin.cfg.set("spawn.x", Double.valueOf(p.getLocation().getX()));
				this.plugin.cfg.set("spawn.y", Double.valueOf(p.getLocation().getY()));
				this.plugin.cfg.set("spawn.z", Double.valueOf(p.getLocation().getZ()));
				this.plugin.cfg.set("spawn.yaw", Double.valueOf(p.getLocation().getYaw()));
				this.plugin.cfg.set("spawn.pitch", Double.valueOf(p.getLocation().getPitch()));

				this.plugin.saveConfig();
				p.sendMessage("§cDu hast den GunGame Spawn gesetzt!");
				return true;
			}

		} else {
			sender.sendMessage("DU BIST KEIN EMNSCH BIIIATCH");
		}

		return false;
	}
}

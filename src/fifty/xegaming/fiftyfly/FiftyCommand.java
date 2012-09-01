package fifty.xegaming.fiftyfly;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class FiftyCommand {

	public final FiftyFly plugin;

	private String info, noFly, noPerm, toManyArgs, patchNotes, flightT;

	public FiftyCommand(FiftyFly plugin) {

		this.plugin = plugin;
	}

	public void isEnabled(CommandSender sender, Player player) {

		player.setAllowFlight(true);
		sender.sendMessage(ChatColor.YELLOW + "[FiftyFly] " + ChatColor.AQUA
				+ "Flying has been enabled");
	}

	public void isDisabled(CommandSender sender, Player player) {

		player.setAllowFlight(false);
		player.setFlying(false);
		sender.sendMessage(ChatColor.YELLOW + "[FiftyFly] "
				+ ChatColor.DARK_AQUA + "Flying has been disabled");
	}

	public boolean isFlight(Player player) {

		if (player.getAllowFlight()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isCreative(Player player) {

		if (player.getGameMode() == GameMode.CREATIVE) {
			return true;
		} else {
			return false;
		}
	}

	public String pluginInfo() {

		info = (ChatColor.YELLOW + "[FiftyFly] " + ChatColor.BLUE + "v1.0: "
				+ ChatColor.RED + "XEGaming " + ChatColor.GREEN
				+ "fly mod created by " + ChatColor.YELLOW + "Fiftysilver"
				+ ChatColor.GREEN + "\nTo enable/disable fly please do "
				+ ChatColor.YELLOW + "/ff " + ChatColor.GREEN
				+ "\nPatch notes for current version can be found by typing "
				+ ChatColor.YELLOW + "/fiftynote ");
		return info;
	}

	public String noFlyCreative() {
		noFly = (ChatColor.YELLOW + "[FiftyFly] " + ChatColor.DARK_RED + "You cannot toggle flight in creative ");
		return noFly;
	}

	public String noPermission() {
		noPerm = (ChatColor.YELLOW + "[FiftyFly] " + ChatColor.RED + "You do not have permission to use this command. ");
		return noPerm;
	}

	public String toManyArguments() {
		toManyArgs = (ChatColor.YELLOW + "[FiftyFly] " + ChatColor.BLUE + "You have entered to many arguments. ");
		return toManyArgs;
	}

	public String directToToggle() {
		flightT = (ChatColor.YELLOW + "[FiftyFly] " + ChatColor.GREEN
				+ "Although flight has been enabled please use "
				+ ChatColor.YELLOW + "/fiftyfly " + ChatColor.GREEN + "for new flight plugin.");
		return flightT;
	}

	public String fiftyNotes() {
		patchNotes = (ChatColor.BLUE
				+ "-----"
				+ ChatColor.YELLOW
				+ "[FIftyFly] "
				+ ChatColor.GREEN
				+ "Patch Notes "
				+ ChatColor.RED
				+ "v1.0"
				+ ChatColor.BLUE
				+ "-----"
				+ ChatColor.AQUA
				+ "\n- Created FiftyFly, enabaling players to fly in game without the use of creative mode."
				+ "\n- Removed seporate commands to enable and disable flight and added one single command."
				+ "\n- Cleaned up and orginized Java code." + "\n- Added Patch Notes command to FiftyFLy.");
		return patchNotes;
	}
}

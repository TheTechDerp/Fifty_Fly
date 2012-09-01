package fifty.xegaming.fiftyfly;

import java.util.logging.Logger;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class FiftyFly extends JavaPlugin {

	public static Permission perms = null;

	private final FiftyCommand fc = new FiftyCommand(this);

	public final Logger log = Logger.getLogger("XEGaming");
	public String fifty = "[FiftyFly] ";

	@Override
	public void onEnable() {

		if (!setPermissions()) {
			log.info(fifty + "vault failed ");
			this.setEnabled(false);
			return;
		}

		this.getCommand("FiftyFly").setExecutor(this);
		this.getServer().getPluginManager()
				.registerEvents(new FiftyListener(this, fc), this);

		log.info(fifty + "Is now enabled.");
	}

	@Override
	public void onDisable() {

		log.info(fifty + "Is now disabled.");
	}

	private boolean setPermissions() {
		RegisteredServiceProvider<Permission> rsp = getServer()
				.getServicesManager().getRegistration(Permission.class);
		perms = rsp.getProvider();
		return perms != null;
	}

	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {

		Player player = (Player) sender;

		if (commandLabel.equalsIgnoreCase("ff")) {
			if (args.length >= 1) {
				if (perms.equals(sender)) {
					sender.sendMessage(fc.toManyArguments());
				} else {
					sender.sendMessage(fc.noPermission());
				}

			} else if (args.length == 0) {
				if (perms.equals(sender)) {
					if (fc.isCreative(player)) {
						sender.sendMessage(fc.noFlyCreative());
					} else if (fc.isFlight(player)) {
						fc.isDisabled(sender, player);
					} else {
						fc.isEnabled(sender, player);
					}
				} else {
					sender.sendMessage(fc.noPermission());
				}
			}
		}

		if (commandLabel.equalsIgnoreCase("FiftyFly")) {
			if (args.length >= 1) {
				if (perms.equals(sender)) {
					sender.sendMessage(fc.toManyArguments());
				} else {
					sender.sendMessage(fc.noPermission());
				}
			} else if (args.length == 0) {
				if (perms.equals(sender)) {
					sender.sendMessage(fc.pluginInfo());
				} else {
					sender.sendMessage(fc.noPermission());
				}
			}
		}

		if (commandLabel.equalsIgnoreCase("fiftynote")) {
			if (args.length >= 1) {
				if (perms.equals(sender)) {
					sender.sendMessage(fc.toManyArguments());
				} else {
					sender.sendMessage(fc.noPermission());
				}
			} else if (args.length == 0) {
				if (perms.equals(sender)) {
					sender.sendMessage(fc.fiftyNotes());
				} else {
					sender.sendMessage(fc.noPermission());
				}
			}
		}
		return true;
	}
}

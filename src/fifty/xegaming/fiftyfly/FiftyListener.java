package fifty.xegaming.fiftyfly;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class FiftyListener implements Listener {

	private final FiftyFly plugin;
	private final FiftyCommand plugin2;

	public FiftyListener(FiftyFly plugin, FiftyCommand plugin2) {

		this.plugin = plugin;
		this.plugin2 = plugin2;
	}

	@EventHandler
	public void onChangeWorld(PlayerChangedWorldEvent event) {

		Player player = event.getPlayer();
		if (player.getAllowFlight() && !plugin2.isCreative(player)) {
			player.setAllowFlight(true);
			event.getPlayer().sendMessage(
					ChatColor.YELLOW + "[FiftyFly] " + ChatColor.AQUA
							+ "You have retained flight, carry on");
		}
	}

	@EventHandler
	public void onDie(PlayerDeathEvent event) {
		Player player = event.getEntity();
		if (player.getAllowFlight() && !plugin2.isCreative(player)) {
			player.setAllowFlight(true);
			event.getEntity()
					.sendMessage(
							ChatColor.YELLOW
									+ "[FiftyFly] "
									+ ChatColor.DARK_AQUA
									+ "Your flight has remained enabled but does not work. Please disable and enable flight to resume flight");
		}
	}
}

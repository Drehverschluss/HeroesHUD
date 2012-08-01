package me.Drehverschluss.HeroesHUD.Listener;

import me.Drehverschluss.HeroesHUD.HeroesHUD;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

public class CommandListener implements CommandExecutor {
	
	HeroesHUD plugin;

	public CommandListener(HeroesHUD heroesHUD) {
		plugin = heroesHUD;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if ((sender instanceof Player)) {
			
			Player player = (Player) sender;
			SpoutPlayer spoutp = SpoutManager.getPlayer(player);
			if (spoutp.isSpoutCraftEnabled()) {
				spoutp.getMainScreen().attachPopupScreen(new HeroesSelectGUI(plugin, spoutp));
			}
			
		}
		return true;
	}
}

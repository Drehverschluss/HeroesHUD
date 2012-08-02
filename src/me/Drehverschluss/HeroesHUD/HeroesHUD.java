package me.Drehverschluss.HeroesHUD;

import me.Drehverschluss.HeroesHUD.Listener.HeroesHUDGUI;
import me.Drehverschluss.HeroesHUD.Listener.HeroesHUDPlayerListener;
import me.Drehverschluss.HeroesHUD.Listener.HeroesSelectGUI;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.herocraftonline.heroes.Heroes;
import com.herocraftonline.heroes.characters.CharacterManager;

public class HeroesHUD extends JavaPlugin{
	
	
	private CharacterManager heroManager;
	private HeroesHUDGUI hhgui; 
	
	public String HeroesSelectGuiBackground;

    private void setupHeroManager() {
    	
        Plugin plugin = getServer().getPluginManager().getPlugin("Heroes");
 
        heroManager = ((Heroes) plugin).getCharacterManager();
    }
 
    public CharacterManager getHeroManager() {
        return heroManager;
    }
    
    public HeroesHUDGUI getGUI() {
    	return hhgui;
    }

	@Override
	public void onEnable() {
		
		
		//Alles einschalten
		FileConfiguration config = this.getConfig();
		config.options().copyDefaults(true);
		saveConfig();
		setupHeroManager();
		manageStuff();
		//GUI Versuch
		HeroesSelectGuiBackground = config.getString("texture.background", "https://dl.dropbox.com/u/39281853/SpoutServer/backgroundNew.png");
		if (HeroesSelectGuiBackground.substring(HeroesSelectGuiBackground.length() - 4, HeroesSelectGuiBackground.length()).equalsIgnoreCase(".png")) {
			return;
		}
		if (Helper.checkURL(HeroesSelectGuiBackground)) {
			return;
		}
		
		//CommandListener cmdExecutor = new CommandListener(this);
		//getCommand("hsg").setExecutor(cmdExecutor);
	}
	
	public void manageStuff() {		
		PluginManager pm = getServer().getPluginManager();
		
		//Listener....
		pm.registerEvents(new HeroesHUDPlayerListener(this), this);
		hhgui = new HeroesHUDGUI(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if ((sender instanceof Player)) {
			
			
			Player player = (Player) sender;
			SpoutPlayer spoutp = SpoutManager.getPlayer(player);
			if(cmd.getName().equalsIgnoreCase("hsg")) {
				if(args.length == 0) {
					spoutp.getMainScreen().attachPopupScreen(new HeroesSelectGUI(this, spoutp));
					
				}
			}
		}
		return true;
	}
}

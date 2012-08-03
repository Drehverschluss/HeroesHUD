package me.Drehverschluss.HeroesHUD;

import me.Drehverschluss.HeroesHUD.Listener.HeroesHUDPlayerListener;
import me.Drehverschluss.HeroesHUD.gui.HeroesHUDGUI;
import me.Drehverschluss.HeroesHUD.gui.HeroesSelectGUI;
//import me.Drehverschluss.test.HeroesHUDHealthBar;

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
import com.herocraftonline.heroes.characters.classes.HeroClassManager;

public class HeroesHUD extends JavaPlugin{
	
	private CharacterManager heroManager;
	private HeroClassManager classManager;
	private HeroesHUDGUI hhgui;
	
	public String HeroesSelectGuiBackgroundMain;
	public String HeroesSelectGuiBackgroundClasses;

    private void setupHeroManager() {
    	
        Plugin plugin = getServer().getPluginManager().getPlugin("Heroes");
 
        heroManager = ((Heroes) plugin).getCharacterManager();
    }
    
    private void setupClassManager() {
    	
    	Plugin plugin = getServer().getPluginManager().getPlugin("Heroes");
    	
    	classManager = ((Heroes) plugin).getClassManager();
    }
    
    public HeroClassManager getClassManager() {
    	return classManager;
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
		setupClassManager();
		manageStuff();
		//GUI Versuch
		HeroesSelectGuiBackgroundMain = config.getString("texturen.backgroundMain", "https://dl.dropbox.com/u/39281853/SpoutServer/HeroesHUD/backgroundMain.png");
//		if (HeroesSelectGuiBackgroundMain.substring(HeroesSelectGuiBackgroundMain.length() - 4, HeroesSelectGuiBackgroundMain.length()).equalsIgnoreCase(".png")) {
//			System.out.println("FAIL! MainPicture must be a png");
//			return;
//		}
//		if (Helper.checkURL(HeroesSelectGuiBackgroundMain)) {
//			System.out.println("Fail!Fail!FAIL!");
//			return;
//		}
		HeroesSelectGuiBackgroundClasses = config.getString("texturen.backgroundClasses", "https://dl.dropbox.com/u/39281853/SpoutServer/HeroesHUD/backgroundClasses.png");
//		if (HeroesSelectGuiBackgroundClasses.substring(HeroesSelectGuiBackgroundClasses.length() -4, HeroesSelectGuiBackgroundClasses.length()).equals(".png")) {
//			System.out.println("FAIL! ClassesPicture must be a png");
//			return;
//		}
//		if (Helper.checkURL(HeroesSelectGuiBackgroundClasses)) {
//			System.out.println("Fail!Fail!FAIL!");
//			return;
//		}
		
		SpoutManager.getFileManager().addToPreLoginCache(this, HeroesSelectGuiBackgroundClasses);
		SpoutManager.getFileManager().addToPreLoginCache(this, HeroesSelectGuiBackgroundMain);
		
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

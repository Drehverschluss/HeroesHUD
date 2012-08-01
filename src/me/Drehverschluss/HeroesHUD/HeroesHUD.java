package me.Drehverschluss.HeroesHUD;

import me.Drehverschluss.HeroesHUD.Listener.HeroesHUDGUI;
import me.Drehverschluss.HeroesHUD.Listener.HeroesHUDPlayerListener;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.herocraftonline.heroes.Heroes;
import com.herocraftonline.heroes.characters.CharacterManager;

public class HeroesHUD extends JavaPlugin{
	
	
	private CharacterManager heroManager;
	private HeroesHUDGUI hhgui; 

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
		getConfig().options().copyDefaults(true);
		saveConfig();
		setupHeroManager();
		manageStuff();		
	}
	
	public void manageStuff() {		
		PluginManager pm = getServer().getPluginManager();
		
		//Listener....
		pm.registerEvents(new HeroesHUDPlayerListener(this), this);
		hhgui = new HeroesHUDGUI(this);
	}
}

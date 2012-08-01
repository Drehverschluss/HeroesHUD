package me.Drehverschluss.test;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import me.Drehverschluss.HeroesHUD.HeroesHUD;

import org.bukkit.configuration.file.YamlConfiguration;

public class HeroesHudFileManager {
	
	private HeroesHUD plugin;
	private String positionPath	= "Position:";
	private String colorPath	= "Colors:";
	private String xPath		= "x: ";
	private String yPath		= "y: ";
	private String xPosPath		= positionPath + xPath;
	
	public int xPos				= 10;
	public int yPos				= 10;
	
	public HeroesHudFileManager(HeroesHUD plugin) {
		this.plugin = plugin;
		
		loadConfig();
		
	}
	
	private void loadConfig() {
		
		File configFile = new File(plugin.getDataFolder(), "worlds.yml");
		
		if (!configFile.exists()) {
			try {
				configFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);
		
		plugin.getLogger().log(Level.INFO, "Starting Config Genaration....");
		
		config.options().header("HeroesHUD config.yml");
		config.options().copyDefaults(true);	
		
		try {
			config.save(configFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	

	
}

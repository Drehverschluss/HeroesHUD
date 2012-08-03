package me.Drehverschluss.HeroesHUD.Listener;

import me.Drehverschluss.HeroesHUD.HeroesHUD;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.event.spout.SpoutCraftEnableEvent;
import org.getspout.spoutapi.gui.Screen;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.herocraftonline.heroes.api.events.ClassChangeEvent;
import com.herocraftonline.heroes.api.events.ExperienceChangeEvent;
import com.herocraftonline.heroes.api.events.SkillDamageEvent;
import com.herocraftonline.heroes.characters.Hero;
import com.herocraftonline.heroes.characters.classes.HeroClass;

public class HeroesHUDPlayerListener implements Listener {
	
	private HeroesHUD plugin;
	public HeroesHUDPlayerListener(HeroesHUD plugin) {
		this.plugin = plugin;	
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		plugin.getGUI().clearPlayer(event.getPlayer().getName());
	}
	
	@EventHandler
	public void onSpoutCraftLogin(SpoutCraftEnableEvent event) {
		
		Player p = event.getPlayer();
		Hero hero = plugin.getHeroManager().getHero(p);
		HeroClass primclass = hero.getHeroClass();
		HeroClass secclass = hero.getSecondClass();
		SpoutPlayer sp = SpoutManager.getPlayer(p);
		
		int xpprim = (int)Math.round(hero.currentXPToNextLevel(primclass));
		int xpsec = (int)Math.round(hero.currentXPToNextLevel(secclass));
		
		if (hero != null) {
		
			String text = primclass + ": " + ChatColor.RED + hero.getHealth() + " / " + hero.getMaxHealth() +
					  "\n" + ChatColor.DARK_RED + "Lvl/Exp: " + ChatColor.RED + hero.getLevel(primclass) + " / " + xpprim;
			
			if (secclass != null) {
				text += "\n" + ChatColor.DARK_GREEN + "Prof: " + ChatColor.GREEN + secclass + 
						"\n" + ChatColor.DARK_GREEN + "LvL/Exp: " + ChatColor.GREEN + hero.getLevel(secclass) + " / " + xpsec;
			} else {
				text += "\n" + ChatColor.DARK_GREEN + "You Dont have a" +
						"\n" + ChatColor.DARK_GREEN + "Secondary Class!";
			}
			plugin.getGUI().updateLabel(sp,text);
		}	
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDamage(SkillDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			
			Player p = (Player) event.getEntity();
			Hero hero = plugin.getHeroManager().getHero(p);
			HeroClass primclass = hero.getHeroClass();
			HeroClass secclass = hero.getSecondClass();
			SpoutPlayer sp = SpoutManager.getPlayer(p);
			
			int xpprim = (int)Math.round(hero.currentXPToNextLevel(primclass));
			int xpsec = (int)Math.round(hero.currentXPToNextLevel(secclass));
			
			if (hero != null) {
			
				String text = primclass + ": " + ChatColor.RED + hero.getHealth() + " / " + hero.getMaxHealth() +
						  "\n" + ChatColor.DARK_RED + "Lvl/Exp: " + ChatColor.RED + hero.getLevel(primclass) + " / " + xpprim;
				
				if (secclass != null) {
					
					text += "\n" + ChatColor.DARK_GREEN + "Prof: " + ChatColor.GREEN + secclass + 
							"\n" + ChatColor.DARK_GREEN + "LvL/Exp: " + ChatColor.GREEN + hero.getLevel(secclass) + " / " + xpsec;
				} else {
					text += "\n" + ChatColor.DARK_GREEN + "You Dont have a" +
							"\n" + ChatColor.DARK_GREEN + "Secondary Class!";
				}
				plugin.getGUI().updateLabel(sp,text);
			}
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerDamage(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			
			Player p = (Player) event.getEntity();
			Hero hero = plugin.getHeroManager().getHero(p);
			HeroClass primclass = hero.getHeroClass();
			HeroClass secclass = hero.getSecondClass();
			SpoutPlayer sp = SpoutManager.getPlayer(p);
			
			int xpprim = (int)Math.round(hero.currentXPToNextLevel(primclass));
			int xpsec = (int)Math.round(hero.currentXPToNextLevel(secclass));
			
			if (hero != null) {
			
				String text = primclass + ": " + ChatColor.RED + hero.getHealth() + " / " + hero.getMaxHealth() +
						  "\n" + ChatColor.DARK_RED + "Lvl/Exp: " + ChatColor.RED + hero.getLevel(primclass) + " / " + xpprim;
				
				if (secclass != null) {
					
					text += "\n" + ChatColor.DARK_GREEN + "Prof: " + ChatColor.GREEN + secclass + 
							"\n" + ChatColor.DARK_GREEN + "LvL/Exp: " + ChatColor.GREEN + hero.getLevel(secclass) + " / " + xpsec;
				} else {
					text += "\n" + ChatColor.DARK_GREEN + "You Dont have a" +
							"\n" + ChatColor.DARK_GREEN + "Secondary Class!";
				}
				plugin.getGUI().updateLabel(sp,text);
			}
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onRegainHealth(EntityRegainHealthEvent event) {
		
		Player p = (Player) event.getEntity();
		Hero hero = plugin.getHeroManager().getHero(p);
		HeroClass primclass = hero.getHeroClass();
		HeroClass secclass = hero.getSecondClass();
		SpoutPlayer sp = SpoutManager.getPlayer(p);
		
		int xpprim = (int)Math.round(hero.currentXPToNextLevel(primclass));
		int xpsec = (int)Math.round(hero.currentXPToNextLevel(secclass));
		
		if (hero != null) {
		
			String text = primclass + ": " + ChatColor.RED + hero.getHealth() + " / " + hero.getMaxHealth() +
					  "\n" + ChatColor.DARK_RED + "Lvl/Exp: " + ChatColor.RED + hero.getLevel(primclass) + " / " + xpprim;
			
			if (secclass != null) {
				
				text += "\n" + ChatColor.DARK_GREEN + "Prof: " + ChatColor.GREEN + secclass + 
						"\n" + ChatColor.DARK_GREEN + "LvL/Exp: " + ChatColor.GREEN + hero.getLevel(secclass) + " / " + xpsec;
			} else {
				text += "\n" + ChatColor.DARK_GREEN + "You Dont have a" +
						"\n" + ChatColor.DARK_GREEN + "Secondary Class!";
			}
			plugin.getGUI().updateLabel(sp,text);
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onLevelChange(PlayerLevelChangeEvent event) {
	
		Player p = (Player) event.getPlayer();
		Hero hero = plugin.getHeroManager().getHero(p);
		HeroClass primclass = hero.getHeroClass();
		HeroClass secclass = hero.getSecondClass();
		SpoutPlayer sp = SpoutManager.getPlayer(p);
		
		int xpprim = (int)Math.round(hero.currentXPToNextLevel(primclass));
		int xpsec = (int)Math.round(hero.currentXPToNextLevel(secclass));
		
		if (hero != null) {
		
			String text = primclass + ": " + ChatColor.RED + hero.getHealth() + " / " + hero.getMaxHealth() +
					  "\n" + ChatColor.DARK_RED + "Lvl/Exp: " + ChatColor.RED + hero.getLevel(primclass) + " / " + xpprim;
			
			if (secclass != null) {
				
				text += "\n" + ChatColor.DARK_GREEN + "Prof: " + ChatColor.GREEN + secclass + 
						"\n" + ChatColor.DARK_GREEN + "LvL/Exp: " + ChatColor.GREEN + hero.getLevel(secclass) + " / " + xpsec;
			} else {
				text += "\n" + ChatColor.DARK_GREEN + "You Dont have a" +
						"\n" + ChatColor.DARK_GREEN + "Secondary Class!";
			}
			plugin.getGUI().updateLabel(sp,text);
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onExpChange(ExperienceChangeEvent event) {
		
		Hero hero = event.getHero();
		Player p = hero.getPlayer();
		HeroClass primclass = hero.getHeroClass();
		HeroClass secclass = hero.getSecondClass();
		SpoutPlayer sp = SpoutManager.getPlayer(p);
		
		double xpprim = hero.currentXPToNextLevel(primclass);
		double xpsec = hero.currentXPToNextLevel(secclass);
		int xpprimround = 0;
		int xpsecround = 0;
		
		if (event.getHeroClass().isPrimary()) {
			double getprim = event.getExpChange();
			xpprimround = (int)Math.round(xpprim + getprim);
		}else if (event.getHeroClass().isSecondary()) {
			double getsec = event.getExpChange();
			xpsecround = (int)Math.round(xpsec + getsec);
		}

		if (hero != null) {
		
		String text = primclass + ": " + ChatColor.RED + hero.getHealth() + " / " + hero.getMaxHealth() +
				"\n" + ChatColor.DARK_RED + "Lvl/Exp: " + ChatColor.RED + hero.getLevel(primclass) + " / " + xpprimround;

		if (secclass != null) {

				text += "\n" + ChatColor.DARK_GREEN + "Prof: " + ChatColor.GREEN + secclass + 
						"\n" + ChatColor.DARK_GREEN + "LvL/Exp: " + ChatColor.GREEN + hero.getLevel(secclass) + " / " + xpsecround;
			} else {
				text += "\n" + ChatColor.DARK_GREEN + "You Dont have a" +
						"\n" + ChatColor.DARK_GREEN + "Secondary Class!";
			}
		plugin.getGUI().updateLabel(sp,text);
		}
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onClassChange(ClassChangeEvent event) {
		
		Hero hero = event.getHero();
		Player p = hero.getPlayer();
		HeroClass toclass = event.getTo();
		SpoutPlayer sp = SpoutManager.getPlayer(p);
		HeroClass secclass = hero.getSecondClass();
		HeroClass primclass = hero.getHeroClass();
		
		if (toclass.isSecondary()) {
			secclass = event.getTo();
		} else if (toclass.isPrimary()) {
			primclass = event.getTo();
		}
		
		int xpprim = (int)Math.round(hero.currentXPToNextLevel(primclass));
		int xpsec = (int)Math.round(hero.currentXPToNextLevel(secclass));
		
		String test = primclass + ": " + ChatColor.RED + hero.getHealth() + " / " + hero.getMaxHealth() +
				  "\n" + ChatColor.DARK_RED + "Lvl/Exp: " + ChatColor.RED + hero.getLevel(primclass) + " / " + xpprim;
		
		if (secclass != null) {
			
			test += "\n" + ChatColor.DARK_GREEN + "Prof: " + ChatColor.GREEN + secclass + 
					"\n" + ChatColor.DARK_GREEN + "LvL/Exp: " + ChatColor.GREEN + hero.getLevel(secclass) + " / " + xpsec;
		} else {
			test += "\n" + ChatColor.DARK_GREEN + "You Dont have a" +
					"\n" + ChatColor.DARK_GREEN + "Secondary Class!";
		}
		plugin.getGUI().updateLabel(sp,test);
	}
	
	@EventHandler
    public void onButtonClick(ButtonClickEvent event) {
		
        Screen screen = event.getScreen();
        if (screen instanceof GenericWindow) {
            GenericWindow window = ((GenericWindow) screen);
            window.onButtonClick(event.getButton());
        }
    }
}
	

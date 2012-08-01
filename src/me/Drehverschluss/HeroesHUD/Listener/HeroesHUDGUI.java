package me.Drehverschluss.HeroesHUD.Listener;

import java.util.HashMap;
import java.util.Map;

import me.Drehverschluss.HeroesHUD.HeroesHUD;

import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.InGameHUD;
import org.getspout.spoutapi.gui.Label;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;


public class HeroesHUDGUI {
	
	private Map<String, Label>labels = new HashMap<String, Label>();
	
	private final HeroesHUD plugin;
	private double pos_x;
	private double pos_y;
	
	public HeroesHUDGUI(HeroesHUD plugin) {
		this.plugin = plugin;
		pos_x = this.plugin.getConfig().getDouble("Config.Position.vertikal_x");
		pos_y = this.plugin.getConfig().getDouble("Config.Position.horizontal_y");
	}
	
	public void updateLabel(SpoutPlayer player, String text) {
		Label label = labels.get(player.getName());
		if (label != null) {
			label.setText(text);
		} else {
			showClass(player, text);
		}
	}
	


	private void showClass(SpoutPlayer player, String text) {
		GenericLabel label = new GenericLabel();
		InGameHUD screen = player.getMainScreen();
		
		label.setAlign(WidgetAnchor.TOP_LEFT);
		label.setTextColor(new Color (170,0,0));
		label.setDirty(true);
		label.setAutoDirty(true);

		label.setText(text);
		label.setWidth(GenericLabel.getStringWidth(label.getText()));
		label.setHeight(GenericLabel.getStringHeight(label.getText()));
		label.setX((int)(screen.getWidth() * (pos_x/100)));
		label.setY(screen.getHeight() - (int)(screen.getHeight() * (pos_y/100)));
		
		labels.put(player.getName(), label);
		
		screen.attachWidget(plugin, label);	
	}
	
	public void clearPlayer(String player) {
		if (labels.containsKey(player)) {
			labels.remove(player);
		}
	}

}

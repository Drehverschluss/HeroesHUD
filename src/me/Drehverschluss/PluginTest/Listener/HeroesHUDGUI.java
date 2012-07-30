package me.Drehverschluss.PluginTest.Listener;

import java.util.HashMap;
import java.util.Map;

import me.Drehverschluss.PluginTest.HeroesHUD;

import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.Label;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;


public class HeroesHUDGUI {
	private final HeroesHUD plugin;
	
	private Map<String, Label>labels = new HashMap<String, Label>();
	
	public HeroesHUDGUI(HeroesHUD plugin) {
		this.plugin = plugin;
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

		
		label.setAlign(WidgetAnchor.TOP_LEFT);
		label.setTextColor(new Color (170,0,0));
		label.setDirty(true);
		label.setAutoDirty(true);

		label.setText(text);
		label.setWidth(GenericLabel.getStringWidth(label.getText()));
		label.setHeight(GenericLabel.getStringHeight(label.getText()));
		label.setX(10);
		label.setY(10);
		
		labels.put(player.getName(), label);
		
		player.getMainScreen().attachWidget(plugin, label);	
	}
	
	public void clearPlayer(String player) {
		if (labels.containsKey(player)) {
			labels.remove(player);
		}
	}

}

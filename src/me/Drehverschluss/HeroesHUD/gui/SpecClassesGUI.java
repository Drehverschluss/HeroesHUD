package me.Drehverschluss.HeroesHUD.gui;

import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

import me.Drehverschluss.HeroesHUD.HeroesHUD;
import me.Drehverschluss.HeroesHUD.Listener.GenericWindow;

public class SpecClassesGUI extends GenericWindow {
	private HeroesHUD plugin;
	private Button buttonBack;
	private SpoutPlayer spoutp;
	
	
	public SpecClassesGUI(HeroesHUD plugin, SpoutPlayer spoutp) {
		this.plugin = plugin;
		this.spoutp = spoutp;
		
		int screenWidth = spoutp.getMainScreen().getWidth();
		int screenHeight = spoutp.getMainScreen().getHeight();
		int x = (screenWidth / 2) - 170;
		int y = (screenHeight / 2) - 100;
		
		GenericTexture backgroundClasses = new GenericTexture();
		
		// BackgroundClasses!
		backgroundClasses.setUrl(plugin.HeroesSelectGuiBackgroundClasses);
		backgroundClasses.setX(x).setY(y);
		backgroundClasses.setWidth(340).setHeight(200);
		backgroundClasses.setPriority(RenderPriority.Highest);
		
		// Button4 Back Classes
		buttonBack = new GenericButton();
		buttonBack.setText("Back");
		buttonBack.setWidth(GenericLabel.getStringWidth(buttonBack.getText()) + 5 + 30).setHeight(GenericLabel.getStringHeight(buttonBack.getText()) + 5);
		buttonBack.setX(backgroundClasses.getX() + 270);
		buttonBack.setY(backgroundClasses.getY() + 150 + buttonBack.getHeight());
		buttonBack.setDirty(true);
		buttonBack.setAutoDirty(true);
		
		super.attachWidgets(plugin, backgroundClasses, buttonBack);
		super.setAnchor(WidgetAnchor.TOP_LEFT);
	
	}
	
	@Override
	public void onButtonClick(Button button) {
		
		if (button.equals(buttonBack)) {
			spoutp.getMainScreen().getActivePopup().close();
			spoutp.getMainScreen().attachPopupScreen(new HeroesSelectGUI(plugin, spoutp));
		}
		
	}

}

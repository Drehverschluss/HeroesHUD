package me.Drehverschluss.HeroesHUD.gui;

import org.getspout.spoutapi.gui.*;
import org.getspout.spoutapi.player.SpoutPlayer;

import me.Drehverschluss.HeroesHUD.HeroesHUD;
import me.Drehverschluss.HeroesHUD.Listener.GenericWindow;

public class ClassesGUI extends GenericWindow {
	
	private HeroesHUD plugin;
	private Button buttonExit;
	private SpoutPlayer spoutp;
	
	
	public ClassesGUI(HeroesHUD plugin, SpoutPlayer spoutp) {
		this.plugin = plugin;
		this.spoutp = spoutp;
		
		int screenWidth = spoutp.getMainScreen().getWidth();
		int screenHeight = spoutp.getMainScreen().getHeight();
		int x = (screenWidth / 2) - 170;
		int y = (screenHeight / 2) - 100;
		
		Texture backgroundClasses = new GenericTexture();
		
		// BackgroundClasses!
		backgroundClasses.setUrl(plugin.HeroesSelectGuiBackgroundClasses);
		backgroundClasses.setX(x).setY(y);
		backgroundClasses.setWidth(340).setHeight(200);
		backgroundClasses.setPriority(RenderPriority.Highest);
		
		// Button4 Back Classes
		buttonExit = new GenericButton();
		buttonExit.setText("Back");
		buttonExit.setWidth(GenericLabel.getStringWidth(buttonExit.getText()) + 5 + 30).setHeight(GenericLabel.getStringHeight(buttonExit.getText()) + 5);
		buttonExit.setX(backgroundClasses.getX() + 245);
		buttonExit.setY(backgroundClasses.getY() + 140 + buttonExit.getHeight());
		buttonExit.setDirty(true);
		buttonExit.setAutoDirty(true);
		
		super.attachWidgets(plugin, backgroundClasses, buttonExit);
		super.setAnchor(WidgetAnchor.TOP_LEFT);
	
	}
	
	@Override
	public void onButtonClick(Button button) {
		
		if (button.equals(buttonExit)) {
			spoutp.getMainScreen().getActivePopup().close();
			spoutp.getMainScreen().attachPopupScreen(new HeroesSelectGUI(plugin, spoutp));
		}
		
	}

}

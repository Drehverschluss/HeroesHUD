package me.Drehverschluss.HeroesHUD.Listener;

import me.Drehverschluss.HeroesHUD.HeroesHUD;

import org.getspout.spoutapi.gui.*;
import org.getspout.spoutapi.player.SpoutPlayer;

public class HeroesSelectGUI extends GenericPopup {
	
	private HeroesHUD plugin;
	private Button button1, button2, button3;
	
	public HeroesSelectGUI(HeroesHUD plugin, SpoutPlayer spoutp) {
		this.plugin = plugin;
		
		int screenWidth = spoutp.getMainScreen().getWidth();
		int screenHeight = spoutp.getMainScreen().getHeight();
		int x = (screenWidth / 2) - 170;
		int y = (screenHeight / 2) - 100;
		
		GenericTexture background = new GenericTexture();
		
		//Background!
		background.setX(x).setY(y);
		background.setWidth(340).setHeight(200);
		background.setUrl(plugin.HeroesSelectGuiBackground);
		background.setFixed(false);
		background.setPriority(RenderPriority.Highest);
		
		//Button1
		button1 = new GenericButton();
		button1.setText("Select");
		button1.setWidth(GenericLabel.getStringWidth(button1.getText()) + 5 + 30).setHeight(GenericLabel.getStringHeight(button1.getText()) + 5);
		button1.setX(background.getX() + 46);
		button1.setY(background.getY() + 103);
		button1.setDirty(true);
        button1.setAutoDirty(true);
        
		//Button2
		button2 = new GenericButton();
		button2.setText("Select");
		button2.setWidth(GenericLabel.getStringWidth(button2.getText()) + 5 + 30).setHeight(GenericLabel.getStringHeight(button2.getText()) + 5);
		button2.setX(background.getX() + 225);
		button2.setY(background.getY() + 103);
		button2.setDirty(true);
        button2.setAutoDirty(true);
        
        //Button3
        button3 = new GenericButton();
		button3.setText("Select");
		button3.setWidth(GenericLabel.getStringWidth(button3.getText()) + 5 + 30).setHeight(GenericLabel.getStringHeight(button3.getText()) + 5);
		button3.setX(background.getX() + 141);
		button3.setY(background.getY() + 145 + button1.getHeight());
		button3.setDirty(true);
        button3.setAutoDirty(true);
		
        super.attachWidgets(plugin, background, button1, button2, button3);
        super.setAnchor(WidgetAnchor.TOP_LEFT);
	}

	public HeroesHUD getSelectGUI() {
		return plugin;
	}

}

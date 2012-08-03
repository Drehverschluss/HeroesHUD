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

public class ChooseGUI extends GenericWindow {
	
	private HeroesHUD plugin;
	private Button buttonConfirm;
	private Button buttonCancel;
	private Button buttonBack;
	private SpoutPlayer spoutp;
	
	public ChooseGUI(HeroesHUD plugin, SpoutPlayer spoutp) {
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
		buttonConfirm = new GenericButton();
		buttonConfirm.setText("Confirm");
		buttonConfirm.setWidth(GenericLabel.getStringWidth(buttonConfirm.getText()) + 5 + 30).setHeight(GenericLabel.getStringHeight(buttonConfirm.getText()) + 5);
		buttonConfirm.setX(backgroundClasses.getX() + 20);
		buttonConfirm.setY(backgroundClasses.getY() + 150 + buttonConfirm.getHeight());
		buttonConfirm.setDirty(true);
		buttonConfirm.setAutoDirty(true);
		
		buttonCancel = new GenericButton();
		buttonCancel.setText("Cancel");
		buttonCancel.setWidth(GenericLabel.getStringWidth(buttonCancel.getText()) + 5 + 30).setHeight(GenericLabel.getStringHeight(buttonCancel.getText()) + 5);
		buttonCancel.setX(backgroundClasses.getX() + 250);
		buttonCancel.setY(backgroundClasses.getY() + 150 + buttonCancel.getHeight());
		buttonCancel.setDirty(true);
		buttonCancel.setAutoDirty(true);
		
		buttonBack = new GenericButton();
		buttonBack.setText("Back to Menu");
		buttonBack.setWidth(GenericLabel.getStringWidth(buttonBack.getText()) + 5 + 30).setHeight(GenericLabel.getStringHeight(buttonBack.getText()) + 5);
		buttonBack.setX(backgroundClasses.getX() + 123);
		buttonBack.setY(backgroundClasses.getY() + 150 + buttonBack.getHeight());
		buttonBack.setDirty(true);
		buttonBack.setAutoDirty(true);
		
		//Label Beginn
		//GenericLabel label = new GenericLabel();
		
		super.attachWidgets(plugin, backgroundClasses, buttonConfirm, buttonCancel, buttonBack);
		super.setAnchor(WidgetAnchor.TOP_LEFT);
	}
	
	@Override
	public void onButtonClick(Button button) {
		if (button.equals(buttonConfirm)) {
			spoutp.chat("/hero confirm");
			spoutp.getMainScreen().getActivePopup().close();
			
		} else if (button.equals(buttonCancel)) {
			spoutp.chat("/hero cancel");
			spoutp.getMainScreen().getActivePopup().close();
			
		} else if (button.equals(buttonBack)) {
			spoutp.chat("/hero cancel");
			spoutp.getMainScreen().getActivePopup().close();
			spoutp.getMainScreen().attachPopupScreen(new HeroesSelectGUI(plugin, spoutp));
		}
	}
}

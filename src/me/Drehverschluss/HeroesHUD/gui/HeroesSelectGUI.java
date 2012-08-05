package me.Drehverschluss.HeroesHUD.gui;

import me.Drehverschluss.HeroesHUD.HeroesHUD;
import me.Drehverschluss.HeroesHUD.Listener.GenericWindow;

import org.getspout.spoutapi.gui.*;
import org.getspout.spoutapi.player.SpoutPlayer;

public class HeroesSelectGUI extends GenericWindow {

	private HeroesHUD plugin;
	private Button button1, button2;
	private SpoutPlayer spoutp;

	public HeroesSelectGUI(HeroesHUD plugin, SpoutPlayer spoutp) {
		this.plugin = plugin;
		this.spoutp = spoutp;

		GenericTexture backgroundMain = new GenericTexture();
		
		int screenWidth = spoutp.getMainScreen().getWidth();
		int screenHeight = spoutp.getMainScreen().getHeight();
		int x = (screenWidth / 2) - 170;
		int y = (screenHeight / 2) - 100;

		// BackgroundMain!

		backgroundMain.setX(x).setY(y);
		backgroundMain.setWidth(340).setHeight(200);
		backgroundMain.setUrl(plugin.HeroesSelectGuiBackgroundMain);
		backgroundMain.setFixed(false);
		backgroundMain.setPriority(RenderPriority.Highest);

		// Button1 Main
		button1 = new GenericButton();
		button1.setText("Primary");
		button1.setWidth(GenericLabel.getStringWidth(button1.getText()) + 5 + 30).setHeight(GenericLabel.getStringHeight(button1.getText()) + 5);
		button1.setX(backgroundMain.getX() + 20);
		button1.setY(backgroundMain.getY() + 65);
		button1.setDirty(true);
		button1.setAutoDirty(true);

		// Button2 Main
		button2 = new GenericButton();
		button2.setText("Profession");
		button2.setWidth(GenericLabel.getStringWidth(button2.getText()) + 5 + 30).setHeight(GenericLabel.getStringHeight(button2.getText()) + 5);
		button2.setX(backgroundMain.getX() + 235);
		button2.setY(backgroundMain.getY() + 65);
		button2.setDirty(true);
		button2.setAutoDirty(true);

		// Button3 Main
//		button3 = new GenericButton();
//		button3.setText("Spezialisation");
//		button3.setWidth(GenericLabel.getStringWidth(button3.getText()) + 5 + 30).setHeight(GenericLabel.getStringHeight(button3.getText()) + 5);
//		button3.setX(backgroundMain.getX() + 125);
//		button3.setY(backgroundMain.getY() + 140 + button1.getHeight());
//		button3.setDirty(true);
//		button3.setAutoDirty(true);

		super.attachWidgets(plugin, backgroundMain, button1, button2);
		super.setAnchor(WidgetAnchor.TOP_LEFT);
	}

	public HeroesHUD getSelectGUI() {
		return plugin;
	}

	@Override
	public void onButtonClick(Button button) {

		if (button.equals(button1)) {
			spoutp.getMainScreen().getActivePopup().close();
			spoutp.getMainScreen().attachPopupScreen(new PrimClassesGUI(plugin, spoutp));
		} else if (button.equals(button2)) {
			spoutp.getMainScreen().getActivePopup().close();
			spoutp.getMainScreen().attachPopupScreen(new ProfClassesGUI(plugin, spoutp));
		}
	}

}

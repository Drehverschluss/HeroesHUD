package me.Drehverschluss.HeroesHUD.gui;

import java.util.ArrayList;
import java.util.List;

import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.RenderPriority;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.herocraftonline.heroes.characters.classes.HeroClass;

import me.Drehverschluss.HeroesHUD.HeroesHUD;
import me.Drehverschluss.HeroesHUD.Listener.GenericWindow;

public class SpecClassesGUI extends GenericWindow {
	
	private HeroesHUD plugin;
	private Button buttonBack;
	private SpoutPlayer spoutp;
	private final int VERTICAL_SPACE = 15, HORIZONTAL_SPACE = 11;
	
	
	public SpecClassesGUI(HeroesHUD plugin, SpoutPlayer spoutp, String heroName) {
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
		int columns = 0;
		int rows = 0;
		int index = 0;
		int basicX = backgroundClasses.getX() + 20;
		int basicY = backgroundClasses.getY() + 50;
		
		List<HeroClass> classes = new ArrayList<HeroClass>( plugin.getClassManager().getClass(heroName).getSpecializations());
		
		for (int i = 0; i < classes.size(); i++) {
			HeroClass heroClass = classes.get(i);
			//System.out.println(heroClass); // da bekomm ichs dann in der liste!
			
			if (index != 0 && index % 5 == 0) {
				rows++;
				columns = 0;
			}
			
			index++;
			
			Button button = new GenericButton(heroClass.getName());
			button.setWidth(65).setHeight(GenericLabel.getStringHeight(button.getText()) + 6);
			button.setX(basicX + (rows * (VERTICAL_SPACE + button.getWidth())));
			button.setY(basicY + (columns * (HORIZONTAL_SPACE + button.getHeight())));
			button.setTooltip(heroClass.getDescription());
			
			columns++;
			
			super.attachWidgets(plugin, backgroundClasses, button, buttonBack);
			super.setAnchor(WidgetAnchor.TOP_LEFT);
		}
	}
	
	@Override
	public void onButtonClick(Button button) {
		for (HeroClass heroClass : plugin.getClassManager().getClasses()) {
			if (button.getText().equals(heroClass.getName())) {
				if (heroClass.isSecondary()) {
					spoutp.chat("/hero prof " + heroClass.getName());
					String choosenClass = heroClass.getName();
					spoutp.getMainScreen().getActivePopup().close();
					spoutp.getMainScreen().attachPopupScreen(new ChooseGUI(plugin, spoutp, choosenClass));
				} else {
				spoutp.chat("/hero choose " + heroClass.getName());
				String choosenClass = heroClass.getName();
				spoutp.getMainScreen().getActivePopup().close();
				spoutp.getMainScreen().attachPopupScreen(new ChooseGUI(plugin, spoutp, choosenClass));
				}
			}
		}
		if (button.equals(buttonBack)) {
			spoutp.getMainScreen().getActivePopup().close();
			spoutp.getMainScreen().attachPopupScreen(new HeroesSelectGUI(plugin, spoutp));
		}
	}
}

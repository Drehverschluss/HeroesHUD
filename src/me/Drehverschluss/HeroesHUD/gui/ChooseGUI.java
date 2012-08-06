package me.Drehverschluss.HeroesHUD.gui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
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

public class ChooseGUI extends GenericWindow {
	
	private HeroesHUD plugin;
	private Button buttonConfirm;
	private Button buttonCancel;
	private Button buttonSpez;
	private SpoutPlayer spoutp;
	private final int VERTICAL_SPACE = 2, HORIZONTAL_SPACE = 75;
	
	private String heroName1;
	
	public ChooseGUI(HeroesHUD plugin, SpoutPlayer spoutp, String choosenClass) {
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
		
		buttonSpez = new GenericButton();
		buttonSpez.setText("Spezialisations");
		buttonSpez.setWidth(GenericLabel.getStringWidth(buttonSpez.getText()) + 5 + 30).setHeight(GenericLabel.getStringHeight(buttonSpez.getText()) + 5);
		buttonSpez.setX(backgroundClasses.getX() + 123);
		buttonSpez.setY(backgroundClasses.getY() + 150 + buttonSpez.getHeight());
		buttonSpez.setDirty(true);
		buttonSpez.setAutoDirty(true);
		
		
		//Label Beginn
		List<String> classesSkills = new ArrayList<String>( plugin.getClassManager().getClass(choosenClass).getSkillNames());
		
		int columns = 0;
		int rows = 0;
		int index = 0;
		int basicX = backgroundClasses.getX() + 10;
		int basicY = backgroundClasses.getY() + 45;
		
		for (int i = 0; i < classesSkills.size(); i++) {
			String classSkills = classesSkills.get(i);
			
			
			if (index != 0 && index % 10 == 0) {
				rows++;
				columns = 0;
			}
			
			index++;
		
			//System.out.println(classSkills);
			
			//Label mit Skills Max = 20 Skills
			GenericLabel label1 = new GenericLabel();
			label1.setText(classSkills);
			label1.setWidth(GenericLabel.getStringWidth(label1.getText()));
			label1.setHeight(GenericLabel.getStringHeight(label1.getText()));
			label1.setX(basicX + 180 + (rows * (HORIZONTAL_SPACE)));
			label1.setY(basicY + (columns * (VERTICAL_SPACE + GenericLabel.getStringHeight(label1.getText()))));
			label1.setDirty(true);
			label1.setAutoDirty(true);
			
			columns++;
			
			//Label mit KlassesnNamen
			HeroClass heroClass = plugin.getClassManager().getClass(choosenClass);
			GenericLabel label2 = new GenericLabel();
			label2.setText(ChatColor.GOLD + heroClass.getName());
			heroName1 = heroClass.getName();
			label2.setHeight(GenericLabel.getStringHeight(label2.getText()));
			label2.setScale(2);
			label2.setX(basicX);
			label2.setY(basicY);
			label2.setShadow(true);
			
			//Neuer Label! Armor und so!
			GenericLabel label3 = new GenericLabel();
			label3.setText(ChatColor.BLACK + "-------------------------" + 
					"\n" + ChatColor.DARK_GREEN + "MaxLevel: " + heroClass.getMaxLevel() + 
					"\n" + "BaseHealth: " + ChatColor.DARK_RED + heroClass.getBaseMaxHealth() + 
					"\n" + "Health / Level: " + ChatColor.RED + heroClass.getMaxHealthPerLevel() + 
					"\n" + 
					"\n" + "BaseMana: " + ChatColor.DARK_BLUE + heroClass.getBaseMaxMana() + 
					"\n" + "Mana / Level: " + ChatColor.DARK_BLUE + heroClass.getMaxManaPerLevel() + 
					"\n" + "ManaRegain: " + ChatColor.BLUE + heroClass.getManaRegen() + 
					"\n" + "ManaRegain / Level: " + ChatColor.BLUE + heroClass.getMaxManaPerLevel());
			label3.setHeight(GenericLabel.getStringHeight(label3.getText()));
			label3.setX(basicX);
			label3.setY(basicY + 20);
			label3.setShadow(false);
			
			//System.out.println(abc);
			
			super.attachWidgets(plugin, backgroundClasses, buttonConfirm, buttonCancel, buttonSpez, label1, label2, label3);
			super.setAnchor(WidgetAnchor.TOP_LEFT);
		}
	}
	
	@Override
	public void onButtonClick(Button button) {
		if (button.equals(buttonConfirm)) {
			spoutp.chat("/hero confirm");
			spoutp.getMainScreen().getActivePopup().close();
			
		} else if (button.equals(buttonCancel)) {
			spoutp.chat("/hero cancel");
			spoutp.getMainScreen().getActivePopup().close();
			spoutp.getMainScreen().attachPopupScreen(new HeroesSelectGUI(plugin, spoutp));
			
		} else if (button.equals(buttonSpez)) {
			spoutp.chat("/hero cancel");
			String heroName = plugin.getClassManager().getClass(heroName1).getName();
			System.out.println(heroName); //der name wenn man auf spec drückt!
			spoutp.getMainScreen().getActivePopup().close();
			spoutp.getMainScreen().attachPopupScreen(new SpecClassesGUI(plugin, spoutp, heroName));
		}
	}
}

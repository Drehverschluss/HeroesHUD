package me.Drehverschluss.HeroesHUD;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Helper {
	private static Set<Material> leather = new HashSet<Material>();
	
	static {
		leather.add(Material.WOOD_AXE);
	}
	
	public static boolean isLeather(Material mat) {
		return leather.contains(mat);
	}
	
	public static boolean hasLeather(PlayerInventory inv) {
		for (ItemStack i: inv.getArmorContents()) {
			if (isLeather(i.getType())) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean checkURL(String strUrl)
    {
        try {
            URL url = new URL(strUrl);
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.connect();

            if (urlConn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                return false;
            }
        } catch (IOException e) {
            return false;
        }

        return true;
    }
}

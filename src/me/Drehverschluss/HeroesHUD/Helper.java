package me.Drehverschluss.HeroesHUD;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Helper {
	
	
	public static boolean checkURL(String strUrl) {
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

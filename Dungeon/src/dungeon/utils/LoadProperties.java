package dungeon.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {

	public LoadProperties(){
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("config.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			int maxLevels;
			int maxDungeons;
			try{
			maxLevels=Integer.parseInt(prop.getProperty("level"));
			maxDungeons=Integer.parseInt(prop.getProperty("dungeon"));
			}catch(NumberFormatException nfe) {
		    	maxLevels=10;
		    	maxDungeons=10;
		    	System.out.println("Error in file \"config.properties\" then initialize number of dungeons and number of levels to 10");
		    }
			Constants.setMAX_DUNGEONS(maxDungeons);
			Constants.setMAX_LEVELS(maxLevels);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

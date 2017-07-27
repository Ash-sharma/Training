package automation.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
	
	public String URL;
	public String BROWSER;
	
	public Configuration() {
		loadProperties();
	}
	
	public void loadProperties()
	{
		FileReader fr;
		Properties prop = new Properties();
		
		try {
			fr = new FileReader("config.properties");
			prop.load(fr);
			
			URL = prop.getProperty("url");
			BROWSER = prop.getProperty("browser");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException e){
			
		}
		
		
		
	}

}

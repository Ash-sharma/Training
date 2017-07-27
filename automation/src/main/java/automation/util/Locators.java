package automation.util;

import java.io.FileReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class Locators {

	public static HashMap<String,String> loc;
	static Logger logger = Logger.getLogger(Locators.class);
	public static void loadLocators(){
		
		loc = new HashMap<>();
		FileReader fr;
		Properties prop = new Properties();
		try{
			fr = new FileReader("locators.properties");
			prop.load(fr);
		    Enumeration en = prop.propertyNames();
		    
		    while(en.hasMoreElements()){
		    	String key = (String)en.nextElement();
		    	String val = prop.getProperty(key);
		    	loc.put(key, val);
		    }
			
		}
		catch(Exception e){
			logger.error(e.getMessage());
		}
	}
	
	
	public static By get(String key){
		
		if(key.contains("-")){
			String[] vals = key.split("-");
			if(vals[0].equals("id")){
				return By.id(loc.get(key));
			}
			else if(vals[0].equals("name")){
				return By.name(loc.get(key));
			}
			else if(vals[0].equals("xpath")){
				return By.xpath(loc.get(key));
			}
			else if(vals[0].equals("css")){
				return By.cssSelector(loc.get(key));
			}
			else if(vals[0].equals("link")){
				return By.linkText(loc.get(key));
			}
			else if(vals[0].equals("pLink")){
				return By.partialLinkText(loc.get(key));
			}
			else if(vals[0].equals("tag")){
				return By.tagName(loc.get(key));
			}
			else if(vals[0].equals("class")){
				return By.className(loc.get(key));
			}
		
			
			
		}
		return By.cssSelector(loc.get(key));
	}
	
}

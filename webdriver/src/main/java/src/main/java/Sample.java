package src.main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Sample {
	
	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", String.format("%s/chromedriver.exe", System.getProperty("user.dir")));
   /*  System.setProperty("webdriver.gecko.driver", String.format("%s/geckodriver.exe", System.getProperty("user.dir")));

      DesiredCapabilities capabilities = DesiredCapabilities.firefox();

        capabilities.setCapability("marionette", true);*/
        WebDriver driver = new FirefoxDriver();
        driver.get("http://google.com");
	}

}

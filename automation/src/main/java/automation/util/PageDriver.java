package automation.util;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class PageDriver {
	
	private WebDriver driver;
	Configuration config;
	Logger  logger;
	
	
	public PageDriver(Configuration config){
		
		this.config = config;
		logger = Logger.getLogger(PageDriver.class);
		start();
	}
	
	private void start(){
		
		String browser = config.BROWSER;
		logger.debug("getting value of briwser" + browser);
		switch(browser){
		case "firefox":
			driver = startFirefox();
			break;
		case "chrome":
			driver = startChrome();
			break;
		case "ie":
			driver = startIE();
			break;
		default:
			driver = startHtmlUnit();
			break;
		}
		
		driver.get(config.URL);
	}

	private WebDriver startFirefox()
	{
		System.setProperty("webdriver.gecko.driver", 
				String.format("%s/geckodriver.exe", 
						System.getProperty("user.dir")));

		return new FirefoxDriver();
	}
	
	private WebDriver startChrome(){
		System.setProperty("webdriver.chrome.driver", 
				String.format("%s/chromedriver.exe", 
						System.getProperty("user.dir")));
		return new ChromeDriver();

	}
	
	private WebDriver startIE()
	{
		return new InternetExplorerDriver();
	}
	
	private WebDriver startHtmlUnit()
	{
		return new HtmlUnitDriver();
	}

	public void quit(){
		driver.quit();
	}
	
	public WebElement findElement(String locator)
	{
		WebElement elem = driver.findElement(Locators.get(locator));
		
		return elem;
	}
	
	public String getCurrentUrl(){
		
		return driver.getCurrentUrl();
	}
}

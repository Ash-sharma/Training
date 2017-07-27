package automation;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import automation.util.Configuration;
import automation.util.Locators;
import automation.util.PageDriver;

public class BaseTest {
	
	public PageDriver driver;
	public static final Configuration _config;
	
	static{
		_config = new Configuration();
	}
	
	
	@BeforeSuite
	public void beforeSuite(){
				this.driver = new PageDriver(_config);
				Locators.loadLocators();
	}
	
	@AfterSuite
	public void afterSuite()
	{
		driver.quit();
	}

}

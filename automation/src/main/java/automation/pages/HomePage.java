package automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automation.util.PageDriver;

public class HomePage extends BasePage{

	
	public HomePage(PageDriver driver)
	{
		super(driver);
	}
	
	public boolean isLogoAvailable()
	{
		boolean isPresent = false;
		WebElement elem = driver.findElement("xpath-logoElem");
		
		if(elem.isDisplayed())
			isPresent = true;
		
		return isPresent;
	}
	
	public boolean performLogin(String uName,String pwd)
	{
		boolean isUserLoggedIn  = true;
		driver.findElement("id-uName").sendKeys(uName);
		driver.findElement("id-pwd").sendKeys(pwd);
		driver.findElement("id-loginBtn").click();
		
		return isUserLoggedIn;
	}
}

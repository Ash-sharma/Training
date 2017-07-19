package src.main.training;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class WebdriverApi2 {
	WebDriver driver;
	
	WebdriverApi2(){
		System.setProperty("webdriver.chrome.driver", 
				String.format("%s/chromedriver.exe", 
						System.getProperty("user.dir")));
		this.driver = new ChromeDriver();
	}
	
	public void windowHandle()
	{
		driver.get("http://www.naukri.com");
		/*String window = driver.getWindowHandle();
		driver.switchTo().window(window);*/
		
		Set<String> ws = driver.getWindowHandles();
		
		for(String s : ws)
		{
			System.out.println(s);
			driver.switchTo().window(s);
			driver.close();
		}
		
	}
	
	public void actionsAPI(){
		
		driver.get("http://www.amazon.com");
		
		/*WebElement elem = driver.findElement(By.xpath(".//*[@id='nav-link-shopall']/span[2]"));
		Actions act = new Actions(driver);
		
		act.moveToElement(elem).moveToElement(driver.findElement(By.xpath(".//*[@id='nav-flyout-shopAll']/div[2]/span[1]/span"))).click().build().perform();*/
		
		//.click();
		
		Set<Cookie> cks = driver.manage().getCookies();

		for(Cookie c : cks)
		{
		  System.out.println(c.getName());
		}
		
		Cookie cr = new Cookie("training", "webdriver");
		
		driver.manage().addCookie(cr);
		
	}
	
	void selectAPI()
	{
		driver.get("http://www.facebook.com");
		WebElement elem = driver.findElement(By.id("month"));
		Select se = new Select(elem);
		se.selectByIndex(2);
		List<WebElement> all = se.getOptions();
		for(WebElement e : all){
			System.out.println(e.getText());
		}
	}
	
	void takeScreenAPI(){
		driver.get("http://www.google.com");
		driver.manage().window().maximize();

		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			System.out.println(src.getAbsolutePath());
		    FileUtils.copyFile(src, new File("C:/Users/Pavitar Kaur/screen1.png"));
		}
		 
		catch (IOException e)
		 {
		  e.printStackTrace();
		 
		 }
	}
	
	void jsAPI(){
		driver.get("http://www.facebook.com");
		WebElement e = driver.findElement(By.linkText("Forgot account?"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",e );
		js.executeScript("window.location='http://www.google.com'");
		js.executeScript("window.scrollBy(0,300)");

	}
	
	void dsCapAPI(){
		
		driver.get("http://www.facebook.com");
		
		/*DesiredCapabilities dc = DesiredCapabilities.firefox();
         FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setAcceptUntrustedCertificates(true);
        firefoxProfile.setPreference("browser.download.folderList", 2);
        firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
      //  firefoxProfile.setPreference("browser.download.dir", _configuration.TestResultPath);
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv");
        firefoxProfile.setPreference("browser.download.manager.alertOnEXEOpen", false);
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.ms-excel;application/msword;application/octet-stream");

        firefoxProfile.setPreference("browser.download.manager.showWhenStarting",
                false);
        firefoxProfile.setPreference("browser.download.manager.focusWhenStarting",
                false);
        firefoxProfile.setPreference("browser.download.useDownloadDir", true);
        firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
        firefoxProfile.setPreference("browser.download.manager.alertOnEXEOpen", false);
        firefoxProfile.setPreference("browser.download.manager.closeWhenDone", true);
        firefoxProfile.setPreference("browser.download.manager.showAlertOnComplete",
                false);
        firefoxProfile.setPreference("browser.download.manager.useWindow", false);
        firefoxProfile.setPreference(
                "services.sync.prefs.sync.browser.download.manager.showWhenStarting",
                false);
        firefoxProfile.setPreference("pdfjs.disabled", true);
        
        dc.setCapability(FirefoxDriver.PROFILE,firefoxProfile);
        new FirefoxDriver(dc);*/
     // FirefoxBinary fb = new FirefoxBinary("sdasdasd");
      /*  fb.setEnvironmentProperty("DISPLAY", ":2");*/
     //   new FirefoxDriver(fb,firefoxProfile);*/

	}
	
	void test(){
		driver.get("https://www.google.com/gmail/about/");
		driver.findElement(By.xpath("html/body/nav/div/a[2]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("identifierId")).sendKeys("ptalwar0687");
		driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();
		driver.findElement(By.name("password")).sendKeys("ptalwar0687");
	}
	public static void main(String[] args) {
		new WebdriverApi2().test();
		
	}
}

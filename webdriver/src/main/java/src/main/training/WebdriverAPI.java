package src.main.training;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverAPI {
	
	public void crooBrow(){
		
		/*System.setProperty("webdriver.gecko.driver", 
				String.format("%s/geckodriver.exe", 
						System.getProperty("user.dir")));
		WebDriver driver = new FirefoxDriver();*/
		
		System.setProperty("webdriver.chrome.driver", 
				String.format("%s/chromedriver.exe", 
						System.getProperty("user.dir")));
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Pavitar%20Kaur/workspace1/webdriver/alert.html");
		driver.findElement(By.id("myBtn")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.authenticateUsing(new UserAndPassword("", ""));
		//alert.setCredentials(new UserAndPassword("", ""));
		/*alert.sendKeys("sumathy");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		alert.dismiss();*/
	//	System.out.println(alert.getText());
		/*alert.accept();
		//driver.quit();
		driver.get("file:///C:/Users/Pavitar%20Kaur/workspace1/webdriver/alert.html");
		driver.findElement(By.id("myBtn")).click();
		Alert alert1 = driver.switchTo().alert();*/
		//System.out.println(alert.getText());
		//alert.dismiss();
	}
	
	public void windowAPI(WebDriver driver){
		
		driver.get("http://www.facebook.com");
		Window w = driver.manage().window();
		//w.fullscreen();

		 w.maximize();
		System.out.println("Pos is " + w.getPosition() );
		System.out.println("Pos is " + w.getSize() );
		Dimension dim = new Dimension(300,300);
		w.setSize(dim);
		Point pt = new Point(1400, 1400);
		w.setPosition(pt);
		
		
		
		
		
	}
	@SuppressWarnings("unchecked")
	public void waitApi(WebDriver driver){
		
		driver.get("http://www.amazon.com");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[5]")).click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='nav-xshop']/a[5]")));
		
		Wait fWait = new FluentWait(driver).
				withTimeout(50, TimeUnit.SECONDS)
				.pollingEvery(10, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		
		WebElement elems = (WebElement) fWait.until(new Function() {
						public Object apply(Object t) {
				// TODO Auto-generated method stub
				WebDriver driver = (WebDriver) t;
				return driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[5]"));
			}
		});

		
		
	}
	
	
	public void navAPI(WebDriver driver){
		
		Navigation nav = driver.navigate();
		nav.to("http://www.amazon.com");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[5]")).click();
		nav.back();
		nav.forward();
		nav.refresh();
		try {
			nav.to(new URL("http://www.amazon.com"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void webElementApi(WebDriver driver){
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		
		email.sendKeys("training@dkmrbh.com");
		
		WebElement pwd = driver.findElement(By.name("pass"));
		pwd.sendKeys("training");
		
		WebElement btn = driver.findElement(By.id("loginbutton"));
		
		System.out.println(btn.getAttribute("class"));
		System.out.println(btn.getCssValue("font-color"));
		System.out.println(btn.getText());
		System.out.println(btn.getLocation());
		System.out.println(btn.getSize());
		System.out.println(btn.getLocation());
		
		
	//	List<WebElement> elements  = driver.findElements(By.xpath(""));
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println(driver.getPageSource());
		//System.out.println(driver.get);




		
	}

	public static void main(String[] args) {
		
		//WebDriver driver = new FirefoxDriver();
		new WebdriverAPI().crooBrow();
		//driver.get("http://www.facebook.com");
	//	new WebdriverAPI().webElementApi(driver);
		//new WebdriverAPI().navAPI(driver);
	//	new WebdriverAPI().waitApi(driver);
		/*WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("training@dkmrbh.com");
		
		WebElement pwd = driver.findElement(By.name("pass"));
		pwd.sendKeys("training");
		
		driver.findElement(By.id("loginbutton")).click();*/
		
	//	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone");
		//driver.findElement(By.xpath("//input[@type='submit' and @class='nav-input']")).click();
		
		
		//driver.findElement(By.linkText("Help"));
		//driver.findElement(By.partialLinkText("Try"));
		//driver.findElement(By.className("Help"));
		//driver.findElement(By.tagName("input"));
		//driver.quit();
		
		
	}
	
}

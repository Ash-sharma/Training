package automation;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automation.pages.HomePage;
import automation.util.ExcelUtils;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;

public class HomePageTest extends BaseTest{

	HomePage hp;
	
	@BeforeClass
	public void createObj()
	{
		hp = new HomePage(driver);
	}
	
	@DataProvider(name="user-data")
	public static Object[][] getData()
	{
		Object[][] data = new ExcelUtils().getData();
		return data;
		
	}
	@Test
	public void isLogoPresentTest(){
		assertTrue(hp.isLogoAvailable());
	}
	@Test(dataProvider="user-data")
	public void performLoginTest(String userName,String pwd){
		assertTrue(hp.performLogin(userName,pwd));
	}
	@AfterClass
	public void destroyObject()
	{
		hp = null;
	}
}

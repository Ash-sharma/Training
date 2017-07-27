package automation.pages;

import automation.util.PageDriver;

public abstract class BasePage {

	public PageDriver driver;
	
	public BasePage(PageDriver driver){
				this.driver = driver;
	}
}

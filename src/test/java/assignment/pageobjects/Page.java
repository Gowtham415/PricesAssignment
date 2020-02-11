package assignment.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

	WebDriver driver;
	 WebDriverWait driverWait;
	 Actions action;

	public Page(WebDriver driver) {
		this.driver = driver;
		driverWait = new WebDriverWait(driver, 15);
		action = new Actions(driver);
	}
	
	public <Test extends BasePage> Test getInstance(Class<Test> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

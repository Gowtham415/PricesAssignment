package assignments.testsuites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import assignment.pageobjects.BasePage;
import assignment.pageobjects.Page;

public class BaseTest {
	WebDriver driver;
	Page pages;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		pages = new BasePage(driver);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}

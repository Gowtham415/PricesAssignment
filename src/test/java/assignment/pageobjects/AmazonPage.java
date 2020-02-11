package assignment.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AmazonPage extends BasePage {

	public AmazonPage(WebDriver driver) {
		super(driver);
	}

	By searchBoxElement = By.id("twotabsearchtextbox");
	By searchButtonElement = By.xpath("//input[@type='submit' and @value='Go']");
	
	
	public void searchProduct(String productName) {
		driver.findElement(searchBoxElement).sendKeys(productName);
		driverWait.until(ExpectedConditions.elementToBeClickable(searchButtonElement)).click();
	}

	public double getProductPrice(String productName) {
		searchProduct(productName);
	//Apple iPhone XR (64GB) - Black
		By productDetails = By.xpath(
				"//div[@id='search']//span[text()='"+productName+"']//parent::a//ancestor::div[@class='sg-row'][1]/following-sibling::div[1]//a/span[1]");	
		driverWait.until(ExpectedConditions.titleContains(productName));
		String str = driverWait.until(ExpectedConditions.visibilityOfElementLocated(productDetails)).getText();
		String priceStr = str.replaceAll("[^0-9]", "");
//		System.out.println(priceStr);
		return Double.parseDouble(priceStr);
		
	}
}
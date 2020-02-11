package assignment.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FlipkartPage extends BasePage{

	public FlipkartPage(WebDriver driver) {
		super(driver);
	}
	
	public void closeLoginModal() {
		action.moveToElement(driver.findElement(By.xpath("//body/div[2]/div[1]/div/button"))).click().build().perform();
	}
	
	public void searchProduct(String productName) {
		closeLoginModal();
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='q']"))).sendKeys(productName);
		action.moveToElement(driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")))).click().build().perform();
	}
	
	public double getProductPrice(String productName) {
		searchProduct(productName);
		By productDetails = By.xpath("//div[text()='Apple iPhone XR (Black, 64 GB)']/parent::div/following-sibling::div/div[1]/div[1]/div");
		String str = driverWait.until(ExpectedConditions.visibilityOfElementLocated(productDetails)).getText();
		String priceStr = str.replaceAll("[^0-9]", "");
//		System.out.println(priceStr);
		return Double.parseDouble(priceStr);
	}
}

package assignments.testsuites;

import org.testng.annotations.Test;

import assignment.pageobjects.AmazonPage;
import assignment.pageobjects.FlipkartPage;
import assignment.utilities.PropertyFileReader;

public class PriceComparisionSuite_1 extends BaseTest{
	PropertyFileReader configReader = PropertyFileReader.getInstance();
  @Test
  public void priceCompareTest() {
	  driver.get(configReader.getproperty("amazonurl"));
	  double amazonPrice = pages.getInstance(AmazonPage.class).getProductPrice("Apple iPhone XR (64GB) - Black");
	  driver.navigate().to(configReader.getproperty("flipkarturl"));
	  double flipkartPrice = pages.getInstance(FlipkartPage.class).getProductPrice("Apple iPhone XR (Black, 64 GB)");
	  
	  if(amazonPrice>flipkartPrice) {
		  System.out.println("Apple iphone XR 64 GB is available in flipkart at a cheaper price: Rs."+flipkartPrice);
	  }else {
		  System.out.println("Apple iphone XR 64 GB is available in Amazon at a cheaper price: Rs."+amazonPrice);
	  }
  }
}

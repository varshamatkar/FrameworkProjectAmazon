package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyDetailedProductObjects {
	 public static WebDriver driver;
	 
	
    private By productTitleOnDetailsPage =By.id("productTitle");
    private By productPriceOnDetailsPage =By.xpath("(//span[@class='a-price-whole'])[1]");
    
    private By cardPopUpPrice=By.xpath(" (//span[@class='a-price-whole'])[1]");
	 
	

	public VerifyDetailedProductObjects(WebDriver driver2) {
		this.driver=driver2;
	}

	
	public WebElement getProductTitleDetailsPage() {
		return driver.findElement(productTitleOnDetailsPage);
		
		
		
	}
	public WebElement getProductPriceOnDetailsPage() {
		return driver.findElement(productPriceOnDetailsPage);
		
		
	}
	
	public WebElement getCardPopUpPrice() {
		return driver.findElement(cardPopUpPrice);
		
		
	}
	
}



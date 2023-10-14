package pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CellPhoneAndAccessoriesObjects {

public static WebDriver driver;
	
	

	private By products= By.xpath("//div[@data-component-type='s-search-result']");
	
	private By productName=By.xpath("//h2/a/span");
	private By productPrice=By.xpath("//span[@class='a-price-whole']");
	private By isBestSeller=By.xpath("//span[contains(text(), 'Best Seller')]");
	
	
	public List<WebElement> allProducts() {
		return  driver.findElements(products);
	}
	
	public CellPhoneAndAccessoriesObjects(WebDriver driver2) {
		this.driver=driver2;
	}
	public List<WebElement> getProductName() {
		return driver.findElements(productName);
		
		
	}
	public List< WebElement> getProductPrice () {
		return driver.findElements(productPrice);
		
		
	}
	public List<WebElement> isBestSeller() {
		return driver.findElements(isBestSeller);
		
		
	}
	
	
}



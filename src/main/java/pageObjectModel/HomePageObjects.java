package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects {
	public static WebDriver driver;
	
	private By all=By.xpath("//a[@id='nav-hamburger-menu']");
	private By electronics=By.xpath("//a[@data-menu-id='5']");; 
	private By cellPhonesAccessories =By.xpath("(//ul[@data-menu-id='5']/li/a)[5]");
	

	public HomePageObjects(WebDriver driver2) {
	  this.driver=driver2;
	}
	public WebElement clickAll() {
		return driver.findElement(all);
		
		
	}
	public WebElement clickElectronics() {
		return driver.findElement(electronics);
		
		
	}
	public WebElement clickCellPhoneAccessories() {
		return driver.findElement(cellPhonesAccessories);
		
		
	}
}

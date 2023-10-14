package testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjectModel.HomePageObjects;
import resources.BaseClass;

public class Homepage extends BaseClass {
	@Test
	public void handleHomePage() throws IOException, InterruptedException {
		
		driverInitialize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
	HomePageObjects obj=new HomePageObjects(driver);
	obj.clickAll().click();
	obj.clickElectronics().click();
	Thread.sleep(3000);
	obj.clickCellPhoneAccessories().sendKeys(Keys.ENTER);

	}
	}



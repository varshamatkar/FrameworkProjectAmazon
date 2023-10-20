package testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjectModel.ResultPageProductsObjects;
import pageObjectModel.HomePageObjects;
import pageObjectModel.VerifyDetailedProductObjects;

import resources.BaseClass;

public class VerifyDetailedProduct extends BaseClass{
	@Test
	public void  verifyProduct() throws IOException, InterruptedException{
		
		
		
		driverInitialize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();

		HomePageObjects homePage=new HomePageObjects(driver);
		
		homePage.clickAll().click();
		Thread.sleep(2000);
		homePage.clickElectronics().click();
		Thread.sleep(5000);
	
		homePage.clickCellPhoneAccessories().sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		
		//resultpageProductname and resultpageProductPrice store in string
		
        ResultPageProductsObjects resultProducts=new ResultPageProductsObjects(driver);
		
		
		String resultPageProductName=resultProducts.getProductName().get(3).getText();
		String resultPageProductPrice=resultProducts.getProductPrice().get(3).getText();
		System.out.println("ResultPage Product Name: "+resultPageProductName);
		System.out.println("Result page product Price: "+resultPageProductPrice);
		Thread.sleep(5000);
		
		
		//click on fourth product
		ResultPageProductsObjects cellPhoneandAcc=new ResultPageProductsObjects(driver);
	
		for(int i=0;i<cellPhoneandAcc.allProducts().size();i++) {
		 cellPhoneandAcc.allProducts().get(3).click();
	  };
		
		
		
		
		 VerifyDetailedProductObjects obj=new VerifyDetailedProductObjects(driver);
			String detailPageProductName=obj.getProductTitleDetailsPage().getText();
			String  detailPageProductPrice=obj.getProductPriceOnDetailsPage().getText();
			System.out.println("Detail Page Product Name: "+detailPageProductName);
			System.out.println("Detail page Product Price: "+detailPageProductPrice);
	  
		

	
		
		
		
		// Verify the title of the product on the both the pages
		if (resultPageProductName.equals(detailPageProductName)) {
            System.out.println("Product title on result and detail matches.");
        } else {
            System.out.println("Product title on result and detail does not match.");
        }
		
		// Verify the price of the product on the details page

		if (resultPageProductPrice.equals(detailPageProductPrice)) {
            System.out.println("Product price on result and detail page matches.");
        } else {
            System.out.println("Product price on result and detail page does not match.");
        }
		
		
		// Click on the "Add to cart" button
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();
        
       
        String cartPopupPriceText=obj.getCardPopUpPrice().getText();
        
        if (resultPageProductPrice.equalsIgnoreCase(cartPopupPriceText)) {
            System.out.println("Price in the cart popup and result page matches.");
        } else {
            System.out.println("Price in the cart popup and result page does not match.");
        }
        
    	
		TakesScreenshot screenShorts =(TakesScreenshot) driver;
		
		File src=screenShorts.getScreenshotAs(OutputType.FILE);
		
		File destination=new File("C:\\Users\\matka\\Desktop\\Software Testing\\Screen Short Hnadling\\.src.jpeg");
		
		FileUtils.copyFile(src, destination);
		
		System.out.println("Screen short is captured");
		
	}
	
	

}

package testcases;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pageObjectModel.CellPhoneAndAccessoriesObjects;
import pageObjectModel.HomePageObjects;
import resources.BaseClass;

public class CellPhoneAndAccessories extends BaseClass {
      @Test
	public void cellPhoneAndAcceHandle() throws IOException, InterruptedException {
    	  
	driverInitialize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	driver.get("https://www.amazon.com/");
	driver.manage().window().maximize();

	HomePageObjects obj=new HomePageObjects(driver);
	
	obj.clickAll().click();;
	obj.clickElectronics().click();
	Thread.sleep(3000);
	obj.clickCellPhoneAccessories().sendKeys(Keys.ENTER);
	

	FileOutputStream file=new FileOutputStream("C:\\Users\\matka\\Desktop\\Products Details on Result Page.xlsx");
		
	// Create a new Excel workbook and sheet
     XSSFWorkbook workbook = new XSSFWorkbook();
     
	XSSFSheet sheet = workbook.createSheet("Product Information");
     
     // Create headers in Excel file
     XSSFRow headerRow = sheet.createRow(0);
     headerRow.createCell(0).setCellValue("Product Name");
    
     headerRow.createCell(1).setCellValue("Product Price");
     headerRow.createCell(2).setCellValue("Best Seller");
    
     CellPhoneAndAccessoriesObjects obj2=new CellPhoneAndAccessoriesObjects(driver);
     obj2.allProducts();
     
     //calculate total number of products
      int totalProduct=obj2.allProducts().size();
      
      System.out.println("Total products found: " + totalProduct);
    
      
        for(int i=0;i<obj2.allProducts().size();i++) {
    	  
    	 String name =obj2.getProductName().get(i).getText();
    	
    	//  String price =obj2.getProductPrice().get(i).getText();
    	 
    	 XSSFRow row = sheet.createRow(i+1);
     	
         row.createCell(0).setCellValue(name);
         
       
         //row.createCell(1).setCellValue(price);
       
        
         if (obj2.allProducts().get(i).getText().contains("Best Seller")) {
             row.createCell(2).setCellValue("Yes");
         } else {
             row.createCell(2).setCellValue("No");
         }
   


      }
      
     workbook.write(file);
     System.out.println(" All product details saved in Excel file ");
   
	}
}

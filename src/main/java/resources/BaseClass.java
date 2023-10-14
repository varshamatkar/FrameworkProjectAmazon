package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class BaseClass {
	
	public static WebDriver driver;
	
	public void driverInitialize() throws IOException {
	
		
	
	FileInputStream file= new FileInputStream("C:\\Users\\matka\\CorejJava\\FrameworkDesign\\src\\main\\java\\resources\\data.properties");

	Properties p=new Properties();
	
	p.load(file);
	
	String browserName=	p.getProperty("browser");
	
	if(browserName.equalsIgnoreCase("chrome")) {
		 ChromeOptions options = new ChromeOptions();
         options.addArguments("--incognito");
         driver = new ChromeDriver(options);
		
	}
	
	else if(browserName.equalsIgnoreCase("Edge")) {
		 driver= new EdgeDriver();
		
	}
	else if(browserName.equalsIgnoreCase("fireFox")) {
		 driver= new FirefoxDriver();
		
	}
	else {
		System.out.println("Pls check youhave correct browser");
	}
	
}
	@AfterClass
	public void closeBrowser() {
		driver.quit();;
	}
	
	
	
	
}
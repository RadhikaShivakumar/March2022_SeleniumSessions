package WebDriver;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TopCastingOptions {

	public static void main(String[] args) {

	//1. For local execution
		//WebDriver driver = new ChromeDriver();
		
		
		//2. topcasting is valid. Not recommended 
		// Only two methods below to access
//		SearchContext sc = new ChromeDriver();
//		sc.findElement(null);
//		sc.findElements(null);
	
		//3. Recommended only for chrome browser.
		//ChromeDriver driver = new ChromeDriver();
		
	
		//4. ChromeDriver to Remote webdriver for local execution
		// Recommended.
//		RemoteWebDriver driver = new ChromeDriver();
//		driver.get("https://www.google.com");
//		driver.getTitle();
//		driver.getCurrentUrl();
//		driver.close();
		
		// why choose 1 over 4th option, according to standard, that coupling
		//should be between interface and class.
		
		//5. Recommended for remote Grid execution, cloud,remote machine,AWS
		//WebDriver driver = new RemoteWebDriver(new URL("192.189.90.99:4444"),capabilities);
		
		//6. only valid for chrome and edge driver, not applicable for firefox,safari,opera driver
		// every chromeDriver,edgeDriver is chromium driver class.
		//ChromiumDriver driver = new ChromeDriver();
		
		// Chromium is the technology to develop browsers.
		ChromiumDriver driver = new EdgeDriver();
		driver.get(null);
		driver.getTitle();
		driver.close();
		
		//no support for OperaClass, Opera is just like chrome, if it works on chrome, then it work in Opera browser.
		//WebDriver driver = new OperaDriver(); //from selenium 4.x
		
		
	}

}

package Navigation;

import java.net.MalformedURLException;
import java.net.URL;

/*
 * (Intv)
 Difference between navigate.to() and get() method for launching url
 
 both are same,they are used to open url. navigate.to() method inturns called
 get method itself.
 
 Navigate.to() method can be overloaded with new URL as well.
 driver.navigate().to(new URL("https://amazon.com"));
 
 		driver.get("https://www.google.com");
 		driver.navigate().to("https://amazon.com");
 		
 		
 		
 		
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethods {

	public static void main(String[] args) throws MalformedURLException {

		//Back button
		//forward button
		//refresh
		//open url
		
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //blank browser will be opened with the constructor
	
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		
		//driver.navigate().to("https://amazon.com");
		driver.navigate().to(new URL("https://amazon.com"));
		
		System.out.println(driver.getTitle());
		
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().refresh();
		
		
		
		
	}

}

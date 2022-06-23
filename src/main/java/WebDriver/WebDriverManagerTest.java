package WebDriver;
/*
 WebDriverManager does the automatic download of exe file download, but upgrading or download
 of browser has to be done by users.
 
 Where the exe files are stored-> C:\Users\Shyam\.cache\selenium\  folder
 
 Even if we delete the exe from downloads folder, it can download the exe and store it again.
 
 WebDriver manager will also take care of just starting the server and launch the browser.
 for launching the browser, we need the topcasting 
 WebDriver driver = new ChromeDriver();
 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver(); //blank browser will be opened with the constructor
		//chromeDriver driver = new ChromeDriver(); cannot use other driver objects, cannot achieve cross browser testing
		
		//enter url google.com
		driver.get("https://www.facebook.com");
		
		String title = driver.getTitle();
		System.out.println("Page title: "+title);
		
		//get current url
		System.out.println(driver.getCurrentUrl());
		
		//checkpoint: check if title is correct or not
		if(title.equals("Google"))
		{
			System.out.println("Title is correct");
		}
		else
		{
			System.out.println("Incorrect title");
		}
		
		driver.quit();
		
		
	}

}

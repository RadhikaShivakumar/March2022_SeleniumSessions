package WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {

		//launch browser:  chrome
		
		System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //blank browser will be opened with the constructor
		//chromeDriver driver = new ChromeDriver(); cannot use other driver objects, cannot achieve cross browser testing
		
		//enter url google.com
		//driver.get("https://www.facebook.com");
		driver.get("https://demo.opencart.com/index.php");
		
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
		
		//driver.quit();
		
		//automation testing -> automation steps + verification point
		
	}

}

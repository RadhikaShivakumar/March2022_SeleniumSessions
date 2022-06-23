package Assignments;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CascadingWindowHandling2_ActionsClick {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// Cascading window handling
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
				
			driver.get("https://opensource-demo.orangehrmlive.com"); //parent window
			String parentWindowId = driver.getWindowHandle();
						
			By orangeHRMLink = By.xpath("//a[normalize-space()='OrangeHRM, Inc']");
			parentWindowId = windowHandle(parentWindowId,orangeHRMLink);
			
			By openSourceHRMS = By.xpath("(//div[@class='col-xs-12 col-sm-6 col-md-2']/ul/li[1])[2]");
			parentWindowId = windowHandle(parentWindowId,openSourceHRMS);
			
			By csSupport = By.xpath("(//div[@class='col-xs-12 col-sm-6 col-md-2']/ul/li[2])[2]");
			windowHandle(parentWindowId,csSupport);
	
			driver.quit();
	}
	public static String windowHandle(String parentWindowId,By locator) throws InterruptedException {
		String childWindow = null;
		
		//Actions class
		Actions act = new Actions(driver);
		WebElement e = driver.findElement(locator);
		act.click(e).perform();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		while(it.hasNext()) {
			String childWindowID = it.next();
		
			if(!parentWindowId.equals(childWindowID)) {
				driver.switchTo().window(childWindowID);
				Thread.sleep(2000);
				System.out.println("Window Child title: " +driver.getTitle());
				childWindow = childWindowID;
			}
		}
		parentWindowId = childWindow;
		return parentWindowId;
	}

	//acceptcookies
	//actions class click
//	java script excecutor click
}
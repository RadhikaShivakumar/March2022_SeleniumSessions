package Assignments;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CascadingWindowHandling {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// Cascading window handling
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
				
			driver.get("https://opensource-demo.orangehrmlive.com"); //parent window
			String parentWindowId = driver.getWindowHandle();
						
			By cookieLocator = By.cssSelector("a.optanon-allow-all.accept-cookies-button");
			By orangeHRMLink = By.xpath("//a[normalize-space()='OrangeHRM, Inc']");
			parentWindowId = windowHandle(parentWindowId,orangeHRMLink,cookieLocator);
			
			By openSourceHRMS = By.xpath("(//div[@class='col-xs-12 col-sm-6 col-md-2']/ul/li[1])[2]");
			parentWindowId = windowHandle(parentWindowId,openSourceHRMS,cookieLocator);
			
			By csSupport = By.xpath("(//div[@class='col-xs-12 col-sm-6 col-md-2']/ul/li[2])[2]");
			windowHandle(parentWindowId,csSupport,cookieLocator);
	
	}
	public static String windowHandle(String parentWindowId,By locator,By cookieLocator) throws InterruptedException {
		String childWindow = null;
		driver.findElement(locator).click();
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
			
			//cookie -> accept cookies
			if(driver.findElement(cookieLocator).isEnabled()) {
				driver.findElement(cookieLocator).click();
			}
		}
		
		
		parentWindowId = childWindow;
		return parentWindowId;
	}

	//acceptcookies
	//actions class click
//	java script excecutor click
}
package Assignments;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlingAssignment {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		//click all links one by one and close it.
		//come back to parent and switch to second window and capture title
		//in a new window and tab once 

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com"); //parent window
		String parentWindowId = driver.getWindowHandle();
		
	
		List<String> linksList = new ArrayList<String>();
				
		linksList.add("OrangeHRM on Facebook");
		linksList.add("LinkedIn OrangeHRM group");
		linksList.add("OrangeHRM on twitter");
		linksList.add("OrangeHRM on youtube");
		
		for(int i=0; i<linksList.size();i++) {
			By xpath =  By.xpath("//img[@alt='"+linksList.get(i)+"']");
			windowHandle(parentWindowId, xpath);
		}
		driver.quit();
	}

	public static void windowHandle(String parentWindowId,By locator) throws InterruptedException {
		driver.findElement(locator).click();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		
		while(it.hasNext()) {
			String childWindowID = it.next();
			if(!parentWindowId.equals(childWindowID)) {
				driver.switchTo().window(childWindowID);
				Thread.sleep(2000);
				System.out.println("Window Child title: " +driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent window title is: " +driver.getTitle()+"\n");
	}
	
	
}

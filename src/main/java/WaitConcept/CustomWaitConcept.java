package WaitConcept;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
/*
 (Intv):
 CustomWait: with the help of static wait(Thread.sleep) need to create dynamic wait
 
 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWaitConcept {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.amazon.com/");
		By amazonScince = By.linkText("Amazon Science11");
		retryingElement(amazonScince,10,500).click();
		
	}

	public static WebElement retryingElement(By locator,int timeOut, int pollingTime) {
		WebElement element = null;
		
		int attempts = 0;
		
		while(attempts <timeOut) {
			try {
				element = driver.findElement(locator);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("Element is not found in attempt: " + attempts + " for : " + locator);
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			attempts++;
		}
		if(element == null) {
			try {
				throw new Exception("ElementNotFoundException");
			}
			catch(Exception e) {
				System.out.println("Element is not found exception... tried for : " + timeOut+ " secs with the interval of: "+ pollingTime + " ms ");
			}
			
		}
		
		return element;
	}
	
	
	
	
	
}

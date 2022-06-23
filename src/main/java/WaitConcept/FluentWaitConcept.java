package WaitConcept;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		//driver.get("https://www.freshworks.com/ae/");
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		
		//By customers = By.linkText("Customers");
		By amazonScince = By.linkText("Amazon Science11");
		
		//top casting
		//Fluentwait is implementing Wait interface
		//upto 10 seconds, ignore these exceptions,once the timeout is done
		//then, still the element is not present/visible then throw the exception
		//waitForElementPresenceWithFluentWait(amazonScince,10,1000,"Element is not found...");
	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10),Duration.ofMillis(1000));
			wait.pollingEvery(Duration.ofMillis(1000))
			.ignoring(NoSuchElementException.class)
			.withMessage("Element is not found..");
		
	//selenium is a raw library, we give fluentWait class, it is upto you
		// to use fluentWait class, we also provide a child class webdriverwait class
			//can access all methods of fluentwait.hence no methods defined in webdriverwait
			//if one can create custom wait by creating one class extending fluentWait
			
	}

	public static void waitForElementPresenceWithFluentWait(By locator,int timeOut,long pollingTime, String msg){
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
					.pollingEvery(Duration.ofMillis(pollingTime)).ignoring(NoSuchElementException.class,StaleElementReferenceException.class)
					.withMessage(msg);
					
		wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
	}
	
}

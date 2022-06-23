package WaitConcept;

import java.time.Duration;

import org.openqa.selenium.By;
/* polling time or interval time:
 * keep on checking at intervals for element availability
 * 
 * if polling time is 500ms, if first attempt is not successful,then after waiting
 * for 500ms, selenium keep checking for element availabiltt.
 * 
 * How many such attempts with default 500ms ?
 *  20 attempts will be done.
 *  
 *  Default polling time is 500ms
 *  
 *  when change the polling interval  the attempts vary
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PollingTimeConcept {

	static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By contactSales = By.linkText("CONTACT SALES");
		waitForElementToBeClickableWithPolling(contactSales,10,2000); // in this case 5 attempts.
		//Error TimeOut Exception, tried for 10 second(s) with 2000 milliseconds interval
		
	}

	
	public static void waitForElementToBeClickableWithPolling(By locator,int timeOut,long pollingTime) {
		WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(timeOut),Duration.ofMillis(pollingTime));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
}

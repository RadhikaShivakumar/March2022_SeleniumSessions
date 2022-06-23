package MouseOperations;

/*
 * 
 * diff between driver.sendkeys() and driver.click() with act.sendkeys()
 action class sendkeys will click on the element and then enter values
 action click -> move to specific element and then click on it.
 
 When to use:
 ===========
 when multiple pop-ups are opened and driver.sendkeys will not be
 able to interact. 
 
 when popups overlap the required element.
 
 In this case, we will use act.sendkeys
 
 
 
 
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClickAndSendKeys {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("http://opencart.antropy.co.uk/index.php?route=account/login");
		
		By email = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value='Login']");
		
//		Actions act = new Actions(driver);
//		act.sendKeys(getElement(email), "test@gmail.com").perform();
//		act.sendKeys(getElement(password), "test@123").perform();
//		act.click(getElement(loginBtn)).perform();
//		
		doActionSendkeys(email,"test@gmail.com");
		doActionSendkeys(password,"test@123");
		doActionClick(loginBtn);
		
		
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doActionSendkeys(By locator,String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator),value).perform();
	}
	
	public static void doActionClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
}

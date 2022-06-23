package MouseOperations;
import java.util.List;

/*
 * Without using isDisplayed method, to confirm if element is displayed or not.
 * 
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementDisplayed {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// print google footer links list

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("http://opencart.antropy.co.uk/index.php?route=account/login");
		
		By email = By.id("input-email");
		
		if(driver.findElements(email).size()>0) {
			System.out.println("Element is displayed");
		}
		

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	public static boolean isElementDisplayed(By locator) {
		WebElement ele = getElement(locator);
		List<WebElement> eleList = getElements(locator);
		if(eleList.size() > 0) {
			if(ele.isDisplayed())
			return true;
		}
		return false;
	}
}

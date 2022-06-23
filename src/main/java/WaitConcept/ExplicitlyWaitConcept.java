package WaitConcept;

/*
 * ExplicitlyWait: it is applicable for web elements and non webElements(title,url,alert)
 	This is a customized for a specific weblement
 *
 */
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitlyWaitConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		By name = By.id("Form_submitForm_Name");
		By email = By.id("Form_submitForm_Email");
		By contact = By.id("Form_submitForm_Contact");
		
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); //selenium 4.x
//		WebElement name_ele = wait.until(ExpectedConditions.presenceOfElementLocated(name));
//		name_ele.sendKeys("naveen");
//		driver.findElement(email).sendKeys("naveen@gmail.com");
//		driver.findElement(contact).sendKeys("3535345");
//		
		waitForElementPresence(name,10).sendKeys("naveen");
		getElement(email).sendKeys("naveen@gmail.com");
		getElement(contact).sendKeys("234234234");
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page. This does notnecessarily mean that the element is visible.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitForElementPresence(By locator,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); //selenium 4.x
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible.Visibility means that the element is not only displayed but also has a height and width that isgreater than 0.
	 * Parameters:locator used to find the elementReturns:the WebElement once it is located and visible
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public static WebElement waitForElementVisibility(By locator,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); //selenium 4.x
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
}

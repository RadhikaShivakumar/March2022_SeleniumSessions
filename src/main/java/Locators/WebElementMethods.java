package Locators;

/*
 getAttribute -> to get attribute value
 getText -> innertext of the dom
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementMethods {

	static WebDriver driver;
	public static void main(String[] args) {

		//WE + perform action(click,sendkeys,getText,isDisplayed)
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	//	driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		//isDisplayed
//		By email = By.id("input-email");
//		boolean flag = driver.findElement(email).isDisplayed();
//		System.out.println(flag);
	
//		if(doIsDisplayed(email))
//		{
//			doSendKeys(email,"test@gmail.com");
//		}
		
		//get the attribute value of the element: like place holder value
//		String placeholder = driver.findElement(By.id("input-email")).getAttribute("placeholder");
//		System.out.println(placeholder);
//		
//		driver.findElement(By.id("input-email")).sendKeys("naveeen20@gmail.com");
//	
		//to capture the value placed in input box.
//		String value = driver.findElement(By.id("input-email")).getAttribute("value");
//		System.out.println(value);
//		
//		driver.findElement(By.id("Form_submitForm_Name")).sendKeys("Naveen test");
//		String value = driver.findElement(By.id("Form_submitForm_Name")).getAttribute("value"); //if value attribute is not there or not, to get the value of the attribute, use 'value'
//		System.out.println(value);
//		
//		System.out.println(getAttributeValue(By.id("Form_submitForm_Name"),"value"));
//		System.out.println(getAttributeValue(By.id("Form_submitForm_Name"),"placeholder"));
//	
	
		//NoSuchElementException, locator is wrong.	
		//driver.findElement(By.id("Form_submitForm_Email111")).sendKeys("naveen@gmail.com");
		
		//InvalidSelectorException: not a valid xpath, or locator syntax error
		//driver.findElement(By.xpath("//!fk@211")).click();
	
	
	}
	
	
	public static String getAttributeValue(By locator,String attrName) {
		return getElement(locator).getAttribute(attrName);
	}
	public static void doSendKeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	}

	public static boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	public  static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
}

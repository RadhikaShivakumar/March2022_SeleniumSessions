package Locators;

import org.openqa.selenium.By;

/*
 DOM - Document object model
 whenever page is opened, DOM is loaded first.
 DOM will be loaded first in the background,from DOM elemenent will be loaded
 There are some API which reads content from DOM and display elements.
 
 
 DOM - document structure in html and xml 
 
 Locators/Selectors - inspect any web element
 
 input type = "text"
 input -> tagName
 type -> Attribute name
 text -> value of the Attribute
 
 placeholder -> Graycolor text inside the textbox like Full Name,Bussiness Email
 
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorStrategy {

	static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial");
	
		// create a WebElement(By using Locator) + perfrom action(click,sendkeys,double click,rightclick,getText,isDisplayed)
		
		//1. id 
		//1st Approach
//		driver.findElement(By.id("Form_submitForm_Name")).sendKeys("Ram kim"); //By is a class, id is a method and is a static method
//		driver.findElement(By.id("Form_submitForm_Email")).sendKeys("test@gmail.com");
//		driver.findElement(By.id("Form_submitForm_Contact")).sendKeys("989898989");
//		
		//2nd approach
//		WebElement name = driver.findElement(By.id("Form_submitForm_Name"));
//		WebElement email = driver.findElement(By.id("Form_submitForm_Email"));
//		WebElement telephone = driver.findElement(By.id("Form_submitForm_Contact"));
//		
//		name.sendKeys("Ram kim");
//		email.sendKeys("test@gmail.com");
//		telephone.sendKeys("9898989898");
		
		//3rd Approach: By locator approach or Object Repository(OR)
		// with the By locator we are not hitting server. with number of locators increase,with
		// each element we are hitting server when use driver.findElement call
		//This will be avoided with By approach
		
		
//		By name = By.id("Form_submitForm_Name"); 
//		By email = By.id("Form_submitForm_Email");
//		By telephone = By.id("Form_submitForm_Contact");
//		
//		//Here we hit the server
//		WebElement name_ele = driver.findElement(name);
//		WebElement email_ele = driver.findElement(email);
//		WebElement tele_ele = driver.findElement(telephone);
//		
//		name_ele.sendKeys("Ram kim");
//		email_ele.sendKeys("test@gmail.com");
//		tele_ele.sendKeys("9898989898");
		
		//4th Approach: unnecessary code in 3rd approach, to improve above method
		//By locator with a generic function:
//		By name = By.id("Form_submitForm_Name"); 
//		By email = By.id("Form_submitForm_Email");
//		By telephone = By.id("Form_submitForm_Contact");
//		
//		getElement(name).sendKeys("Naveen");
//		getElement(email).sendKeys("test@gmail.com");
//		getElement(telephone).sendKeys("9898989898");
		
		//5th Approach: By locator with a generic function of WebElement and action
//		By name = By.id("Form_submitForm_Name"); 
//		By email = By.id("Form_submitForm_Email");
//		By telephone = By.id("Form_submitForm_Contact");
//		
//		doSendKeys(name,"naveen");
//		doSendKeys(email,"test@gmail.com");
//		doSendKeys(telephone,"9898989898");
//		
		//6th approach: By locator with ElementUtil class having generic methods:
		//Most companies use this approach.
		
//		By name = By.id("Form_submitForm_Name"); 
//		By email = By.id("Form_submitForm_Email");
//		By telephone = By.id("Form_submitForm_Contact");
//		
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doSendKeys(name,"naveen");
//		eleUtil.doSendKeys(email,"test@gmail.com");
//		eleUtil.doSendKeys(telephone,"9898989898");
		
		//7th Approach: String locator with ElementUtil class having generic methods
		String name_id = "Form_submitForm_Name";
		String email_id = "Form_submitForm_Email";
		String tele_id = "Form_submitForm_Contact";
		
		// create a WebElement(By using Locator) + perfrom action(click,sendkeys,double click,rightclick,getText,isDisplayed)
		//create by locator from STring
		
//		doSendKeys(getBy("id", name_id),"naveen");
//		doSendKeys(getBy("id", email_id),"test@gmail.com");
//		doSendKeys(getBy("id", tele_id),"9898989898");
		
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys("id", name_id,"naveen");
		eleUtil.doSendKeys("id", email_id,"test@gmail.com");
		eleUtil.doSendKeys("id", tele_id,"9898989898");
	}
	
	
	public static By getBy(String locatorType,String locatorValue) {
		By locator = null;
		switch(locatorType.toLowerCase()) {
		
		case "id":
			locator = By.id(locatorValue);
			break;
			
			default:
				break;
		}
		return locator;
	}
	public static void doSendKeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	

}

package Locators;

/*
 if id,name,classname (Attributes) available -> preference is 1,2,3
 between xpath and css -> depends on use case to usecase.
 
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.BrowserUtil;
import Utilities.ElementUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DifferentLocators {

	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");
		//1. id: always unique attribute
		//2 name : can be duplicate
		driver.findElement(By.name("email")).sendKeys("test@gmail.com");
		driver.findElement(By.name("password")).sendKeys("test@123");
		
//		By email=By.name("email");
//		By password = By.name("password");
//		doSendKeys(email,"naveen@gmail.com");
		
		//3. class name: is not a unique attribute,can be duplicate
		// used only when we have unique class name for the element
		driver.findElement(By.className("form-control")).sendKeys("test@gmail.com");
		
//		xpath: is not an attribute, it is the address of the element in html DOM
//		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@gmail.com");
//		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@123");
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
//		
		
//		By email = By.xpath("//input[@name='email']");
//		By password = By.xpath("//input[@name='email']");
//		By loginBtn = By.xpath("//input[@value='Login']");
//		doSendKeys(email,"naveen@gmail.com");
//		doSendKeys(password,"test@123");
//		doClick(loginBtn);
		
		
//		String email_xpath = "//input[@name='email']";
//		String password_xpath = "//input[@name='email']";
//		String loginBtn_xpath = "//input[@value='Login']";
//		
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doSendKeys("xpath", email_xpath, "naveen@gmail.com");
//		eleUtil.doSendKeys("xpath", password_xpath, "test@123");
//		eleUtil.doClick(loginBtn);
//		
		
		//5. css seletor: not an attribute
//		driver.findElement(By.cssSelector("#input-email")).sendKeys("naveen@gmail.com");
//		driver.findElement(By.cssSelector("#input-password")).sendKeys("test@123");
//		driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input")).click();
//		
		
		
		//6. link text: only for links
		// highfen-reference(href)
		//driver.findElement(By.linkText("Register")).click();
	//	String text = driver.findElement(By.linkText("Register")).getText();
	//	System.out.println(text);
		
//		By registerLink = By.linkText("Register");
//		if(doGetText(registerLink).equals("Register")) {
//			System.out.println("PASS");
//		}
//		
		
		//7. partial link text: only for links having a long text
		// when have two links Forgotten password Forgotten userid then have difficult identifying element
		//driver.findElement(By.partialLinkText("Forgotten")).click();
		
		//8. tag Name: not an attribute
		// html tag like h2,div,input
		String header = driver.findElement(By.tagName("h2")).getText();
		System.out.println(header);
	}

	public static String doGetText(By locator) {
		return getElement(locator).getText();
	}
	public static void doClick(By locator) {
		getElement(locator).click();
		
	}
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
}

package Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MutliLevelMenuHandling {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://bigbasket.com");
		By parentMenu =By.xpath("//a[@class='dropdown-toggle meganav-shop']");
		
		//multiLevelMenuHandling(parentMenu,"Beverages","Tea","Green Tea","Tea Powder");
		multiLevelMenuHandling(parentMenu,"Baby Care","Baby Food & Formula","Baby Food","Cerelac");
		
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void multiLevelMenuHandling(By parentMenu,String l1,String l2,String l3,String l4) throws InterruptedException {

		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		
		act.moveToElement(driver.findElement(By.linkText(l1))).perform();
		Thread.sleep(2000);
		
		act.moveToElement(driver.findElement(By.linkText(l2))).perform();
		Thread.sleep(2000);
		
		act.moveToElement(driver.findElement(By.linkText(l3))).perform();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText(l4)).click();
		
	}
}

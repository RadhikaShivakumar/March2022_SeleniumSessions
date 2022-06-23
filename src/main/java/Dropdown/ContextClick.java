package Dropdown;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextClick {
	static WebDriver driver;
	public static void main(String[] args) {
		//Context click - right click
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

		By rightClick = By.xpath("//span[text()='right click me']");
		By rightClickMenuItems = By.xpath("//ul[@class='context-menu-list context-menu-root']/li[contains(@class,'context-menu-icon')]");
		
		//directly right click on the menu item.
		//driver.findElement(By.xpath("//span[text()='Copy']")).click();
		
		
		//List<String> list = getRightClickMenuList(rightClick,rightClickMenuItems);
		// System.out.println(list);
		
		By rightMenuItems = By.xpath("//span[text()='Copy']");
		selectRightClickMenu(rightClick,rightMenuItems);
		
	}
	

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void selectRightClickMenu(By rightClickElementLocator,By rightMenuItems) {
		Actions act = new Actions(driver);
		act.contextClick(getElement(rightClickElementLocator)).perform();
		getElement(rightMenuItems).click();
	}
	
	public static List<String> getRightClickMenuList(By rightClickElementLocator,By rightMenuItems) {

		List<String> rightMenuList = new ArrayList<String>();
		WebElement rightClick = getElement(rightClickElementLocator);

		Actions act = new Actions(driver);
		act.contextClick(rightClick).perform();
		

		List<WebElement> menuItems = driver.findElements(rightMenuItems);
		
		for(WebElement e: menuItems) {
			String text = e.getText();
			rightMenuList.add(text);
		}	
		return rightMenuList;
	}
	
	
	
}

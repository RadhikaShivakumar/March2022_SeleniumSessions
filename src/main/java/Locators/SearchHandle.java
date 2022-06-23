package Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchHandle {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://automationpractice.com/index.php");
		driver.findElement(By.id("search_query_top")).sendKeys("Dress");
		Thread.sleep(4000);
		
//		List<WebElement> suggList  = 
//				driver.findElements(By.xpath("//div[@class='ac_results']//li"));
//
//		for(WebElement e: suggList) {
//			
//			String text = e.getText();
//			if(text.contains("Casual Dresses > Printed ")) {
//				e.click();
//				break;
//			}
//		}
		
		
		driver.findElement(By.xpath("//li[contains(text(),'Casual Dresses > Printed ')]")).click();
		
		
	}

}

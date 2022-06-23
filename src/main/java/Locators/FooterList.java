package Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterList {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.freshworks.com/ae");
	
		//List<WebElement> footerList = driver.findElements(By.xpath("//ul[@class='footer-nav']/li/a"));

		List<WebElement> footerList = driver.findElements(By.xpath("//div[@class='footer-main']//ul//a"));

		
		
		//		for(WebElement e: footerList) {
//			System.out.println(e.getText());
//		}
//		
		System.out.println(footerList.size());
		footerList.stream().forEach(e -> System.out.println(e.getText()));
		driver.quit();
	}

}

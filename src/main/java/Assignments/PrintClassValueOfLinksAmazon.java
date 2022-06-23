package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintClassValueOfLinksAmazon {

	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.amazon.com/");
		//print all class value from all links
		
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		
//		for(WebElement e: linksList) {
//			String text = e.getAttribute("class");
//			System.out.println(text);
//		}

		linksList.stream()
			.filter(e -> !e.getAttribute("class").isEmpty())
				.forEach(e -> System.out.println(e.getAttribute("class")));
		
	}

}

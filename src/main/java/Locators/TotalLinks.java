package Locators;

/*
 * small set of data, streams can be preferred
 * for loops are preferred when have large data as the performance is better
 */
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {

	static WebDriver driver;
	public static void main(String[] args) {
		//  Total number of links
		// print the text of each link on the console.
		// ignore the blank text.
		// print href value
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.amazon.com/");
	
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		
		System.out.println("Total number of links: "+ linksList.size());
		
//		for(int i=0;i<linksList.size();i++) {
//			String text = linksList.get(i).getText();
//			if(!text.isEmpty()) {
//				System.out.println(text); 
//			}
//		}
		
//		for(WebElement link:linksList) {
//			String text=link.getText();
//			if(!text.isEmpty()) {
//				System.out.println(text);
//			}
//		}

		
		//Stream
//		linksList
//				.stream()
//					.forEach(ele -> System.out.println(ele.getText()));
//	
//		
		
		linksList
			.stream()
				.filter(e -> !e.getText().isEmpty())
					.forEach(e -> System.out.println(e.getText()));
		
		
	
		
		//driver.quit();
	}

}

//Assignment -> print all images and attribute value of alt
//print all class value from all links


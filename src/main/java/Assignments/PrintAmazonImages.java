package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintAmazonImages {

	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.amazon.com/");
	
		//print all images and attribute value of alt
		System.out.println("print all images and attribute value of alt");
		List<WebElement> imgList = driver.findElements(By.tagName("img"));
//		for(WebElement e: imgList) {
//			String text = e.getAttribute("alt");
//			System.out.println(text);
//		}

		
		
		imgList.stream()
			.filter(e -> !e.getAttribute("alt").isEmpty())
				.forEach(e->System.out.println(e.getAttribute("alt")));
	}

}

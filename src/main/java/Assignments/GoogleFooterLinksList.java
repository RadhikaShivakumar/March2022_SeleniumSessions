package Assignments;

/*

 */
import java.lang.reflect.Array;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleFooterLinksList {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// print google footer links list

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.google.com/");
		
		
//		List<WebElement> footerList = driver.findElements(By.tagName("a"));
//		System.out.println("With tagName 'a', prints all links not just footer.");
//		for(WebElement e: footerList) {
//			//List<String> footerLinks = new Array<String>();
//			String text = e.getText();
//			System.out.println(text);
//		}
//		
	
		List<WebElement> footerList1 = driver.findElements(By.xpath("//a[@class='pHiOh']"));
		System.out.println("With xpath pertaining to footer section....");
		for(WebElement e: footerList1) {
			//List<String> footerLinks = new Array<String>();
			String text = e.getText();
			System.out.println(text);
		}
		
		System.out.println("Since 'settings' link is not under the same xpath, extracting the value using separate xpath");
		
		System.out.println(driver.findElement(By.xpath("//div[@class='ayzqOc pHiOh']")).getText()); //settings
		
		//Issue: Here we are taking separate syso print statement to include 'settings'
		// //a[@class='pHiOh'] , //div[@class='ayzqOc pHiOh']
		// does this also considered "Take a Security Checkup" a footer link
		
		// //div[@class='KxwPGc SSwjIe']/div/a will also match the same 5 links in footer section.
	}

}

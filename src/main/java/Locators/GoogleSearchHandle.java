package Locators;
import java.util.ArrayList;
import java.util.List;

// ul - unordered list -html tag
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchHandle {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// to print links and size of links when search some text in google

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.google.com/");

		By suggestions = By.xpath("//ul[@role='listbox']//div[@class='wM6W7d']/span");
		//getGoogleSuggList(suggestions,"Selenium Testing");
		selectGoogleSuggestion(suggestions,"selenium","selenium webdriver");
		
		
		//driver.quit();
	}

	
	public static void selectGoogleSuggestion(By locator,String searchKey,String suggVal) throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys(searchKey);
		Thread.sleep(3000);
		
		List<WebElement> suggList = driver.findElements(locator);
		
		for(WebElement e: suggList) {
			String text = e.getText();
			System.out.println(text);
			if(text.contains(suggVal)) {
				e.click();
				break;
			}
		}
		
	}
	
	public static List<String> getGoogleSuggList(By locator,String searchKey) throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys(searchKey);
		Thread.sleep(3000);

		List<WebElement> suggList = driver.findElements(locator);
		List<String> suggValList = new ArrayList<String>();
		for(WebElement e: suggList) {
			String text = e.getText();
			System.out.println(text);
			suggValList.add(text);
		}
		return suggValList;
	}
	
	//links from footer section
	//print links from antropy section and footer
		
	
}

package WebTableHandling;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonFooterList {

	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		//To print particular column footer link text
		System.out.println(getFooterList("Make Money with Us"));
		System.out.println(getFooterList("Get to Know Us"));

	}

	public static List<String> getFooterList(String hearderList) {
		List<WebElement> footerList = driver.findElements(By.xpath("//div[text()='"+hearderList+"']/parent::div/ul/li"));
		List<String> footerListText = new ArrayList<String>();
		for(WebElement e: footerList) {
			String text = e.getText();
			footerListText.add(text);
		}
		return footerListText;
	}
}

package Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FooterLinksAntropyApp {

	static WebDriver driver;
	public static void main(String[] args) {
		// print footer links from Opencart Antropy application

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://opencart.antropy.co.uk/index.php?route=account/login");
		driver.manage().window().maximize();
		List<WebElement> footerList = driver.findElements(By.xpath("//footer/div[@class='container']//li/a"));
		System.out.println("Total footer links: " + footerList.size()+ "\n");
		
		for(WebElement e: footerList) {
			String text = e.getText();
			System.out.println(text);
		}
	}

}

package WebTableHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


//(Intv) Traverse entire table


public class W3CTraverseEntireTable {
	
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		int colCount = driver.findElements(By.xpath("//table[@id='customers']//tr[1]/th")).size();
	
		System.out.println("Rows: "+ rowCount);
		System.out.println("columns: "+ colCount);
		
		List<WebElement> tableList = driver.findElements(By.xpath("//table[@id='customers']//tr/td"));
		for(WebElement e: tableList) {
			System.out.println(e.getText());
		}
	
		List<WebElement> companyList = driver.findElements(By.xpath("//th[text()='Company']/parent::tr/following-sibling::tr/td[1]"));
		for(WebElement e: companyList) {
			System.out.println(e.getText());
		}
	
	}

}

package pagination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablePagination {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		int pageCount =1;
		while(true) {
			
			if(driver.findElements(By.xpath("//td[text()='Dubai']")).size()>0) {
				selectCity("Dubai");
				System.out.println("page count: "+pageCount);
				break;
			}
			else {
				//pagination logic:
				//click on button or icon
				WebElement next = driver.findElement(By.linkText("Next"));
				if(next.getAttribute("class").contains("disabled")) {
					System.out.println("pagination is over.. record not found");
					break;
				}
				next.click();
				Thread.sleep(1500);
				pageCount++;
			}
			
		}
		//table[@id='tablepress-3']//tbody/tr/td/input
		//td[text()='Dahanu']/parent::tr/td/input[@type='checkbox']
	}

	public static void selectCity(String cityName) {
		driver.findElement(By.xpath("//td[text()='"+cityName+"']/parent::tr/td/input[@type='checkbox']")).click();
	}
	
	
}

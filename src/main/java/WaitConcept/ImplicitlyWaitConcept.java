package WaitConcept;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/* Implicitly wait is a method:

 1. Global wait 
 2. It will be applied for all the web elements by default
 3. It's not a custom wait for a specific web element
 4. Not applicable for non webElements, title, url,alert
 5. only applicable for webElements
 
 problems with ImplicitlyWait
 For all webElements, the implicitly wait of 10 second is applied.
 if we have 50 elements then it will wait 50*10=500second
 
 we can override the implicitly duration, then this will be applied for future  webelements
 but unnecessary over ride statements
 
 it will drastically enhances the execution time
 
 
 */
public class ImplicitlyWaitConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); selenium 3.x
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//1st Page: home page
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		driver.findElement(By.id("Form_submitForm_Name11")).sendKeys("Naveen");
		driver.findElement(By.id("Form_submitForm_Email")).sendKeys("Naveen@gmail.com");
		driver.findElement(By.id("Form_submitForm_Contact")).sendKeys("24792823987");
		
		
		//2nd Page: contact page:
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//e4
		//e5
		//e6
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//2nd page: contact page: 10sec
		
		//3rd Page: cartPage: no wait: 0 second: nullify of implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		
	}

}

package WaitConcept;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
/*
 * document.readyState --> gives readiness of page loading.
 * if gives output as 'complete' then page loading is complete.
 * 
 * document.readyState -> has many states
 * 
 * (Intv: different states of document.ready state)
 * 	loading - still loading
 * 	interactive - document has finished loading but some sub-resourses are such
 * as scripts, images, stylesheets,frames are still loading.
 *  complete - loading complete
 *  
 *  
 *  
 *  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); equivalent to
 *  waitForPageLoad.
 *  
 *  practically, people use custom method to know states of the page loading.
 *  
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForPageLoading {

	static WebDriver driver;
	
	public static void waitForPageLoad(int timeOut) {
		
		long endTime = System.currentTimeMillis() + timeOut;
		
		while(System.currentTimeMillis() < endTime) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String state = js.executeScript("return document.readyState").toString();
			System.out.println("Page is : " +state);
			if(state.equals("complete")) {
				System.out.println("Page is fully loaded now...");
				break;
			}
		
		}
	}
	
	
	
	
	

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		//driver.get("https://ui.freecrm.com/");
		//driver.get("https://www.amazon.com");
		driver.get("https://classic.crmpro.com/index.html");
		waitForPageLoad(20);
		
		
	}

}

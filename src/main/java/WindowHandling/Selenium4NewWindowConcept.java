package WindowHandling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium4NewWindowConcept {

	public static void main(String[] args) throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://opensource-demo.orangehrmlive.com"); //parent window
			String parentWindowId=driver.getWindowHandle();
			
			//to open windows in new tab or windows
			
			//driver.switchTo().newWindow(WindowType.TAB); //its creating tab window and switching there as will.driver is available on tab window
			driver.switchTo().newWindow(WindowType.WINDOW);
			driver.navigate().to("http://amazon.com");
			System.out.println(driver.getTitle());
			Thread.sleep(5000);
			driver.close();
			
			driver.switchTo().window(parentWindowId);
			System.out.println(driver.getTitle());
			driver.quit();
			
			
			
	}

}
